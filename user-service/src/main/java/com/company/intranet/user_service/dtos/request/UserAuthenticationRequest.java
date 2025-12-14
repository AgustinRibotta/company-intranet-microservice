package com.company.intranet.user_service.dtos.request;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;

@Hidden
public class UserAuthenticationRequest {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public UserAuthenticationRequest() {
    }

    public UserAuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
