package com.company.intranet.auth_service.proxy;

import com.company.intranet.auth_service.config.UserServiceFeignConfig;
import com.company.intranet.auth_service.dto.AuthenticationRequest;
import com.company.intranet.auth_service.dto.UserAuthenticationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "user-service",
        url = "http://localhost:8080",
        configuration = UserServiceFeignConfig.class
)
public interface UserServiceProxy {

    @PostMapping("/auth")
    public ResponseEntity<UserAuthenticationResponse> login (@RequestBody AuthenticationRequest request);
}
