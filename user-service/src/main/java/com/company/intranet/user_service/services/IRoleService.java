package com.company.intranet.user_service.services;

import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.RoleCreateDto;
import com.company.intranet.user_service.entities.dtos.RoleDto;

public interface IRoleService {

    List<RoleDto> findAll();
    RoleDto findById(UUID id);
    List<RoleDto> findByUserId(UUID userId);
    RoleDto save(RoleCreateDto roleDto);
    RoleDto update (UUID id, RoleCreateDto roleDto);
    void delete (UUID id);

}
 