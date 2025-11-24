package com.company.intranet.rh_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "profile_entity")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID userId;

    @Column(nullable = false)
    private String firstName;

    private String lastName;
    private LocalDate birthday;
    private String position;
    private LocalDate startDate;
    private Number salary;

    @OneToMany(fetch = FetchType.EAGER)
    private DepartmentEntity department;

    public ProfileEntity() {
    }

    public ProfileEntity(UUID id, UUID userId, String firstName, String lastName, LocalDate birthday, String position, LocalDate startDate, Number salarty, DepartmentEntity department) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.position = position;
        this.startDate = startDate;
        this.salary = salarty;
        this.department = department;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Number getSalary() {
        return salary;
    }

    public void setSalary(Number salary) {
        this.salary = salary;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
