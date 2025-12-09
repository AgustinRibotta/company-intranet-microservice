package com.company.intranet.api_gateway.routes;

import com.company.intranet.api_gateway.filters.InternalTokenFilter;
import com.company.intranet.api_gateway.filters.JwtValidationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RhServiceRoutes {

    private final InternalTokenFilter internalTokenFilter;
    private final JwtValidationFilter jwtValidationFilter;

    public RhServiceRoutes(InternalTokenFilter internalTokenFilter,
                           JwtValidationFilter jwtValidationFilter) {
        this.internalTokenFilter = internalTokenFilter;
        this.jwtValidationFilter = jwtValidationFilter;
    }

    @Bean
    public RouteLocator rhRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rh-internal", r -> r
                        .path("/rh-service/swagger-ui/**",
                                "/rh-service/v3/api-docs/**",
                                "/rh-service/swagger-ui.html",
                                "/rh-service/webjars/**",
                                "/rh-service/actuator",
                                "/rh-service/actuator/**")
                        .filters(f -> f.filter(internalTokenFilter))
                        .uri("lb://rh-service"))
                .route("rh-secured", r -> r
                        .path("/rh-service/**")
                        .filters(f -> f.filter(jwtValidationFilter)
                                .removeRequestHeader("Host"))
                        .uri("lb://rh-service"))
                .build();
    }
}
