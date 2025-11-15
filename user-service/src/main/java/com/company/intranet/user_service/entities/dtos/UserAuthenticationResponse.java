package com.company.intranet.user_service.entities.dtos;

import java.util.Set;
import java.util.UUID;

public class UserAuthenticationResponse {

    private UUID id;

    private String email;

    private Set<String> rolesName;

    public UserAuthenticationResponse(UUID id) {
    }

    public UserAuthenticationResponse(UUID id, String email, Set<String> rolesName) {
        this.id = id;
        this.email = email;

        this.rolesName = rolesName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
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
