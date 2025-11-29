package com.company.intranet.rh_service.entities.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public class DepartmentResponseDto {

    @Schema(description = "Unique identifier of the department",
            example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    private String name;

    public DepartmentResponseDto() {
    }

    public DepartmentResponseDto(UUID id, String name) {
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
