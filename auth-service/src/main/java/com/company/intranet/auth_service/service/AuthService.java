package com.company.intranet.auth_service.service;

import com.company.intranet.auth_service.dto.AuthenticationRequest;
import com.company.intranet.auth_service.dto.AuthenticationResponse;
import com.company.intranet.auth_service.dto.UserAuthenticationResponse;
import com.company.intranet.auth_service.exeptions.ErrorDetails;
import com.company.intranet.auth_service.proxy.UserServiceProxy;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserServiceProxy userServiceProxy;
    private final JwtService jwtService;

    public AuthService(UserServiceProxy userServiceProxy, JwtService jwtService) {
        this.userServiceProxy = userServiceProxy;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {

        try {
            UserAuthenticationResponse user = userServiceProxy.login(request).getBody();

            if (user == null) {
                throw new ErrorDetails(
                        LocalDateTime.now(),
                        "Empty response from user-service",
                        "user-service returned null body"
                );
            }

            String token = jwtService.generateToken(user);

            return new AuthenticationResponse(token);

        } catch (FeignException e) {
            throw new ErrorDetails(
                    LocalDateTime.now(),
                    e.contentUTF8(),
                    "uri=" + e.request().url()
            );
        }
    }
}
