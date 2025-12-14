package com.company.intranet.rh_service.proxy;

import com.company.intranet.rh_service.config.UserServiceFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "user-service",
        configuration = UserServiceFeignConfig.class
)
public interface UserServiceProxy {

    @GetMapping("/user-service/users/auth/{id}/exists")
    public ResponseEntity<Void> auth(@PathVariable UUID id);
}