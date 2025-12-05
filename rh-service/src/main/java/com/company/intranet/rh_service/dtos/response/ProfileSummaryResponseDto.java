package com.company.intranet.rh_service.dtos.response;


import java.util.UUID;

public class ProfileSummaryResponseDto {

    private UUID id;

    private String email;

    private String firstName;

    private String lastName;
    private String position;


    private DepartmentResponseDto department;

    public ProfileSummaryResponseDto() {
    }

    public ProfileSummaryResponseDto(UUID id, String email, String firstName, String lastName, String position, DepartmentResponseDto department) {
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
