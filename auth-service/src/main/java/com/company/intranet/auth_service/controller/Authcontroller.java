package com.company.intranet.auth_service.controller;

import com.company.intranet.auth_service.dto.AuthenticationRequest;
import com.company.intranet.auth_service.dto.AuthenticationResponse;
import com.company.intranet.auth_service.dto.UserAuthenticationResponse;
import com.company.intranet.auth_service.proxy.JwtService;
import com.company.intranet.auth_service.proxy.UserServiceProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    private final UserServiceProxy userServiceProxy;
    private final JwtService jwtService;

    public Authcontroller(UserServiceProxy userServiceProxy, JwtService jwtService) {
        this.userServiceProxy = userServiceProxy;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createToken (@RequestBody AuthenticationRequest request) {
        final UserAuthenticationResponse user = this.userServiceProxy.login(request).getBody();
        final String jwtToken = this.jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}
