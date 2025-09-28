package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.company.intranet.user_service.entities.PermissionEntity;
import com.company.intranet.user_service.entities.dtos.PermissionDto;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {

    IPermissionMapper INSTANCE = Mappers.getMapper(IPermissionMapper.class);

    PermissionDto permissionEntityToPermissionDto(PermissionEntity entity);

    PermissionEntity permissionDtoToPermissionEntity(PermissionDto dto);

    @Mapping(target = "id", ignore = true)
    void updatePermissionFromDto(PermissionDto dto, @MappingTarget PermissionEntity entity);
}