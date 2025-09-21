package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;

import com.company.intranet.user_service.entities.PermissionEntity;
import com.company.intranet.user_service.entities.dtos.PermissionDto;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {

    PermissionDto permissionEnttityPermissionDto(PermissionEntity permission);

    PermissionEntity permissionDtoToPermissionEntity(PermissionDto permissionDto);
}