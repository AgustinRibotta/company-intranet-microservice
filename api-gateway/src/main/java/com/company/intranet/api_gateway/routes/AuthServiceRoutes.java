package com.company.intranet.api_gateway.routes;

import com.company.intranet.api_gateway.filters.InternalTokenFilter;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;

@Component
public class AuthServiceRoutes {

    private final InternalTokenFilter internalTokenFilter;

    public AuthServiceRoutes(InternalTokenFilter internalTokenFilter) {
        this.internalTokenFilter = internalTokenFilter;
    }

    @Bean
    public RouteLocator authRoutes(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("auth-login", r -> r
                        .path("/auth-service/login")
                        .uri("lb://auth-service"))

                .route("auth-docs", r -> r
                        .path("/auth-service/swagger-ui/**",
                                "/auth-service/v3/api-docs/**",
                                "/auth-service/swagger-ui.html",
                                "/auth-service/webjars/**")
                        .uri("lb://auth-service"))

                .route("auth-internal", r -> r
                        .path("/auth-service/actuator",
                                "/auth-service/actuator/**")
                        .filters(f -> f.filter(internalTokenFilter))
                        .uri("lb://auth-service"))

                .build();

    }
}