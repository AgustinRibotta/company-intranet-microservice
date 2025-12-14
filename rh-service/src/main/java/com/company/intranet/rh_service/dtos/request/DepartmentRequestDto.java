package com.company.intranet.rh_service.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


public class DepartmentRequestDto {


    @Schema(description = "Name of the department", example = "Engineering")
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
