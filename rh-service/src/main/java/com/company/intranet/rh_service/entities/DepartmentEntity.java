package com.company.intranet.rh_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "department_entity")
public class DepartmentEntity {

    private UUID id;
    private String name;

    public DepartmentEntity() {
    }

    public DepartmentEntity(UUID id, String name) {
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
