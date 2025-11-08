package com.company.intranet.user_service.entities.dtos;

import java.util.Set;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class RoleDto {

    @Schema(description = "Unique identifier of the role", example = "550e8400-e29b-41d4-a716-446655440000")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;

    @Schema(description = "Name of the role", example = "ADMIN", required = true)
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "Permissions associated with the role")
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
