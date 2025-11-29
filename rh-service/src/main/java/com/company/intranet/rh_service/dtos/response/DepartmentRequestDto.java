package com.company.intranet.rh_service.dtos.response;

import jakarta.validation.constraints.NotBlank;


public class DepartmentRequestDto {


    @NotBlank(message = "Name is required")
    private String name;

    public DepartmentRequestDto() {
    }

    public DepartmentRequestDto( String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
