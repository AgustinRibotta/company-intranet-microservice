package com.company.intranet.auth_service.dto;

public class AuthenticationRequest {

    private String susername;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String susername, String password) {
        this.susername = susername;
        this.password = password;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
