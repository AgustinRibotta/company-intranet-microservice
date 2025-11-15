package com.company.intranet.auth_service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceFeignConfig implements RequestInterceptor {

    private static final String INTERNAL_TOKEN = "mi-token-secreto";

    @Override
    public void apply(RequestTemplate template) {
        template.header("X-Internal-Token", INTERNAL_TOKEN);
    }
}
