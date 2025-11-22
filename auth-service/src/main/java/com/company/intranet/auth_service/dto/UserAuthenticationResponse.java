package com.company.intranet.auth_service.dto;

import java.util.Set;
import java.util.UUID;

public class UserAuthenticationResponse {

    private UUID id;

    private String email;

    private Set<String> rolesName;

    private Set<String> permissionName;

    public UserAuthenticationResponse() {

    }

    public UserAuthenticationResponse(UUID id, String email, Set<String> rolesName, Set<String> permissionName) {
        this.id = id;
        this.email = email;
        this.rolesName = rolesName;
        this.permissionName = permissionName;
    }

    public Set<String> getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(Set<String> permissionName) {
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


}
