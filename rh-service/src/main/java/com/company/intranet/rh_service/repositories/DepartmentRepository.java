package com.company.intranet.rh_service.repositories;

import com.company.intranet.rh_service.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, UUID> {
}
