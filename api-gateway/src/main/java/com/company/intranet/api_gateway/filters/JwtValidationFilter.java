package com.company.intranet.api_gateway.filters;

import com.company.intranet.api_gateway.exeption.ErrorDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;  // Importar el módulo JavaTimeModule
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class JwtValidationFilter implements GatewayFilter {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return handleUnauthorized(exchange, "Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);

        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception e) {
            return handleUnauthorized(exchange, "Invalid JWT token");
        }

        return chain.filter(exchange);
    }

    private Mono<Void> handleUnauthorized(ServerWebExchange exchange, String errorMessage) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                "Unauthorized",
                errorMessage
        );

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        byte[] bytes = convertToJson(errorDetails);

        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(bytes)));
    }

    private byte[] convertToJson(ErrorDetails errorDetails) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsBytes(errorDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"timestamp\": \"error converting response to JSON\"}".getBytes();
        }
    }
}
