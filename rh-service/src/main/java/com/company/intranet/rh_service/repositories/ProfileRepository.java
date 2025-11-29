package com.company.intranet.rh_service.repositories;

import com.company.intranet.rh_service.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {
}
