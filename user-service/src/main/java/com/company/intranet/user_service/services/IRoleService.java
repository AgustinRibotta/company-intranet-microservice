package com.company.intranet.user_service.services;

import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.RoleDto;

public interface IRoleService {

    List<RoleDto> findAll();
    RoleDto findById();
    RoleDto save(RoleDto roleDto);
    RoleDto update (UUID id, RoleDto roleDto);
    void delete (UUID id);

}
