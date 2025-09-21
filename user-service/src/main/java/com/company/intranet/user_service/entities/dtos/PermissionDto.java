package com.company.intranet.user_service.entities.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class PermissionDto {

    private UUID id;

    @NotBlank(message = "Name is required")
    private String name;

    public PermissionDto() {
    }

    public PermissionDto(UUID id, @NotBlank(message = "Name is required") String name) {
        this.id = id;
        this.name = name;
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
}
