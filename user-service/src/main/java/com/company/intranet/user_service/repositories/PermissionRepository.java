package com.company.intranet.user_service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.intranet.user_service.entities.PermissionEntity;

public interface PermissionRepository extends JpaRepository<PermissionEntity, UUID> {

}
