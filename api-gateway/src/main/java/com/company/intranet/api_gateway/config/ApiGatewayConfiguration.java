package com.company.intranet.api_gateway.config;

import com.company.intranet.api_gateway.filters.InternalTokenFilter;
import com.company.intranet.api_gateway.filters.JwtValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder,
                                      JwtValidationFilter jwtValidationFilter,
                                      InternalTokenFilter internalTokenFilter) {
        return builder.routes()

                .route("auth-service", r -> r
                        .path("/auth/login")
                        .uri("lb://auth-service"))

                .route("user-auth-route", r -> r
                        .path("/user-service/users/valid")
                        .filters(f -> f
                                .filter(internalTokenFilter))
                        .uri("lb://user-service"))

                .route("user-service-secured", r -> r
                        .path("/user-service/**")
                        .filters(f -> f
                                .filter(jwtValidationFilter)
                                .removeRequestHeader("Host"))
                        .uri("lb://user-service"))

                .build();
    }
}