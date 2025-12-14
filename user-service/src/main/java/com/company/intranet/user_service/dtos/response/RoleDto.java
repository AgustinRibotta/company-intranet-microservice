package com.company.intranet.user_service.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.UUID;

public class RoleDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;
    private String name;
    private Set<PermissionDto> permissions;

    public RoleDto() {
    }

    public RoleDto(UUID id, @NotBlank(message = "Name is required") String name, Set<PermissionDto> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
