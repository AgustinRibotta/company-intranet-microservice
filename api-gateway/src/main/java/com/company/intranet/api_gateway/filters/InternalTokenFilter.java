package com.company.intranet.api_gateway.filters;

import com.company.intranet.api_gateway.exeption.ErrorDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class InternalTokenFilter implements GatewayFilter {

    @Value("${internal.token}")
    private String INTERNAL_TOKEN;

    @Value("${header.name}")
    private String headerName;

//    private static final String INTERNAL_TOKEN = internalToken;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(headerName);

        if (token == null || !INTERNAL_TOKEN.equals(token)) {
            ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    "Forbidden",
                    "Invalid internal token"
            );

            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            exchange.getResponse().getHeaders().setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

            byte[] bytes = convertToJson(errorDetails);
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(bytes)));
        }

        return chain.filter(exchange);
    }

    private byte[] convertToJson(ErrorDetails errorDetails) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsBytes(errorDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"timestamp\": \"error converting response to JSONnnnnn\"}".getBytes();
        }
    }
}
