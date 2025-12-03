package com.company.intranet.rh_service.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class ProfileResponseDto {

    @NotBlank(message = "Id is required")
    private UUID id;

    @Schema(description = "Email of the user", example = "admin@admin.com", required = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Name of the user", example = "admin", required = true)
    @NotBlank(message = "Name is required")
    private String firstName;

    private String lastName;
    private String position;


    @NotEmpty(message = "Department cannot be empty")
    private DepartmentResponseDto department;

    public ProfileResponseDto() {
    }

    public ProfileResponseDto(UUID id, String email, String firstName, String lastName, String position, DepartmentResponseDto department) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public DepartmentResponseDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentResponseDto department) {
        this.department = department;
    }
}
