package com.company.intranet.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder, InternalTokenFilter internalTokenFilter) {
        return builder.routes()

                // Ruta protegida: solo microservicio interno puede acceder
                .route("user-auth-route", r -> r
                        .path("/auth")
                        .filters(f -> f
                                .filter(internalTokenFilter)
                                .rewritePath("/auth", "/user-service/users/auth"))
                        .uri("lb://user-service"))

                // Resto de rutas libres
                .route("user-service-free-route", r -> r
                        .path("/user-service/**")
                        .filters(f -> f.removeRequestHeader("Host"))
                        .uri("lb://user-service"))

                .build();
    }
}