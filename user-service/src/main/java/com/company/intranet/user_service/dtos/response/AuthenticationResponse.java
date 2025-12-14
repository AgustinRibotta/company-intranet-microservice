package com.company.intranet.user_service.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;
import java.util.UUID;

@Schema(hidden = true)
public class AuthenticationResponse {

    private UUID id;
    private String email;
    private Set<String> rolesName;
    private Set<String> permissionName;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(UUID id, String email, Set<String> rolesName, Set<String> permissionName) {
        this.id = id;
        this.email = email;
        this.rolesName = rolesName;
        this.permissionName = permissionName;
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

    public Set<String> getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(Set<String> permissionName) {
        this.permissionName = permissionName;
    }
}
