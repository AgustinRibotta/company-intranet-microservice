package com.company.intranet.auth_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Authentication information for login ")
public class AuthenticationRequest {

    @Schema(description = "Email of the login", example = "admin@admin.com")
    private String email;

    @Schema(description = "Password of the login", example = "admin")
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String email, String password) {
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
