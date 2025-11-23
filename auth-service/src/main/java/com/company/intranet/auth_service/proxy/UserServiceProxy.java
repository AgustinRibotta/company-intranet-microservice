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
        configuration = UserServiceFeignConfig.class
)
public interface UserServiceProxy {

    @PostMapping("/user-service/users/valid")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody AuthenticationRequest request);
}