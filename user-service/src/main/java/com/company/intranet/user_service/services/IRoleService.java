package com.company.intranet.user_service.services;

import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.RoleDto;

public interface IRoleService {

    List<RoleDto> findAll();
    RoleDto findById(UUID id);
    List<RoleDto> findByUserId(UUID userId);
    RoleDto save(RoleDto roleDto);
    RoleDto update (UUID id, RoleDto roleDto);
    void delete (UUID id);

}
 