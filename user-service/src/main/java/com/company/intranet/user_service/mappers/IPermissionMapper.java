package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.company.intranet.user_service.entities.PermissionEntity;
import com.company.intranet.user_service.entities.dtos.PermissionDto;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {

    IPermissionMapper INSTANCE = Mappers.getMapper(IPermissionMapper.class);

    PermissionDto permissionEntityToPermissionDto(PermissionEntity permissionEntity);

    PermissionEntity permissionDtoToPermissionEntity(PermissionDto permissionDto);
}