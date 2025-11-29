package com.company.intranet.rh_service.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.UUID;

public class ProfileRequestDto {

    @Schema(description = "User Id of the Profile", required = true)
    @NotBlank(message = "User Id is required")
    private UUID userId;

    @Schema(description = "Email of the user", example = "admin@admin.com", required = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Name of the user", example = "admin", required = true)
    @NotBlank(message = "Name is required")
    private String firstName;

    private String lastName;
    private LocalDate birthday;
    private LocalDate startDate;
    private String position;
    private Number salary;

    @NotEmpty(message = "Department cannot be empty")
    private UUID departmentId;

    public ProfileRequestDto() {
    }

    public ProfileRequestDto(UUID userId, String email, String firstName, String lastName, LocalDate birthday, LocalDate startDate, String position, Number salary, UUID department) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.startDate = startDate;
        this.position = position;
        this.salary = salary;
        this.departmentId = department;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Number getSalary() {
        return salary;
    }

    public void setSalary(Number salary) {
        this.salary = salary;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }
}
