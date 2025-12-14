package com.company.intranet.rh_service.dtos.response;


import java.time.LocalDate;
import java.util.UUID;

public class ProfileResponseDto {

    private UUID userId;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDate startDate;
    private String position;
    private Integer salary;
    private DepartmentResponseDto department;

    public ProfileResponseDto() {
    }

    public ProfileResponseDto(UUID userId, String email, String firstName, String lastName, LocalDate birthday, LocalDate startDate, String position, Integer salary, DepartmentResponseDto department) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.startDate = startDate;
        this.position = position;
        this.salary = salary;
        this.department = department;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public DepartmentResponseDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentResponseDto department) {
        this.department = department;
    }
}
