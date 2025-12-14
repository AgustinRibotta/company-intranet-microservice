package com.company.intranet.api_gateway.routes;

import com.company.intranet.api_gateway.filters.InternalTokenFilter;
import com.company.intranet.api_gateway.filters.JwtValidationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserServiceRoutes {

    private final InternalTokenFilter internalTokenFilter;
    private final JwtValidationFilter jwtValidationFilter;

    public UserServiceRoutes(InternalTokenFilter internalTokenFilter,
                             JwtValidationFilter jwtValidationFilter) {
        this.internalTokenFilter = internalTokenFilter;
        this.jwtValidationFilter = jwtValidationFilter;
    }

    @Bean
    public RouteLocator userRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-internal", r -> r
                        .path("/user-service/swagger-ui/**",
                                "/user-service/v3/api-docs/**",
                                "/user-service/swagger-ui.html",
                                "/user-service/webjars/**",
                                "/user-service/actuator",
                                "/user-service/actuator/**",
                                "/user-service/users/valid",
                                "/user-service/users/auth/**")
                        .filters(f -> f.filter(internalTokenFilter))
                        .uri("lb://user-service"))
                .route("user-secured", r -> r
                        .path("/user-service/**")
                        .filters(f -> f.filter(jwtValidationFilter)
                                .removeRequestHeader("Host"))
                        .uri("lb://user-service"))
                .build();
    }
}
