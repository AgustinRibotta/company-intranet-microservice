package com.company.intranet.user_service.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.UUID;

public class RoleCreateDto {

    @Schema(description = "Name of the role", example = "ADMIN", required = true)
    @NotBlank(message = "Name is required")
    private String name;

    private Set<UUID> permissions;

    public RoleCreateDto() {
    }

    public RoleCreateDto(String name, Set<UUID> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public Set<UUID> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<UUID> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
