package com.company.intranet.auth_service.controller;

import com.company.intranet.auth_service.dto.AuthenticationRequest;
import com.company.intranet.auth_service.dto.AuthenticationResponse;
import com.company.intranet.auth_service.dto.UserAuthenticationResponse;
import com.company.intranet.auth_service.exeptions.ErrorDetails;
import com.company.intranet.auth_service.service.JwtService;
import com.company.intranet.auth_service.proxy.UserServiceProxy;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceProxy userServiceProxy;
    private final JwtService jwtService;

    public AuthController(UserServiceProxy userServiceProxy, JwtService jwtService) {
        this.userServiceProxy = userServiceProxy;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createToken(@RequestBody AuthenticationRequest request) {
        try {
            UserAuthenticationResponse user = this.userServiceProxy.login(request).getBody();

            String jwtToken = this.jwtService.generateToken(user);

            return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
        } catch (FeignException e) {
            return ResponseEntity
                    .status(e.status())
                    .body(new ErrorDetails(LocalDateTime.now(), e.contentUTF8(), "uri=" + e.request().url()));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDetails(LocalDateTime.now(), "Internal Server Error", e.getMessage()));
        }
    }
}
