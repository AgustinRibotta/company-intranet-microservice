package com.company.intranet.user_service.entities.dtos;

import java.util.Set;

public class UserAuthenticationResponse {

    private String email;

    private Set<String> rolesName;

    public UserAuthenticationResponse() {
    }

    public UserAuthenticationResponse(String email, Set<String> rolesName) {
        this.email = email;

        this.rolesName = rolesName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<String> getRolesName() {
        return rolesName;
    }

    public void setRolesName(Set<String> rolesName) {
        this.rolesName = rolesName;
    }
}
