package com.company.intranet.rh_service.dtos.response;


import java.util.UUID;

public class DepartmentResponseDto {

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
