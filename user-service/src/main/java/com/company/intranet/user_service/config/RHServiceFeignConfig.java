package com.company.intranet.user_service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class RHServiceFeignConfig implements RequestInterceptor {

    @Value("${internal.token}")
    private String INTERNAL_TOKEN;

    @Value("${header.name}")
    private String headerName;

    @Override
    public void apply(RequestTemplate template) {
        template.header(headerName, INTERNAL_TOKEN);
    }
}
