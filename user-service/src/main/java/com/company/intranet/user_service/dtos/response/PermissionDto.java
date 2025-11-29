package com.company.intranet.user_service.dtos.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class PermissionDto {

    @Schema(description = "Unique identifier of the role", example = "550e8400-e29b-41d4-a716-446655440000")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;

    @Schema( required = false)
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
