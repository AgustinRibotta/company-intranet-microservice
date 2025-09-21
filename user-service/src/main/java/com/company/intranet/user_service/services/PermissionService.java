package com.company.intranet.user_service.services;

import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.PermissionDto;


public interface PermissionService {

    
    List<PermissionDto> findAll();
    PermissionDto findById();
    PermissionDto save(PermissionDto permissionDto);
    PermissionDto update (UUID id, PermissionDto permissionDto);
    void delete (UUID id);
}
