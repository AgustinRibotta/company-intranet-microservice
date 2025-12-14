package com.company.intranet.user_service.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class PermissionDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;
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
