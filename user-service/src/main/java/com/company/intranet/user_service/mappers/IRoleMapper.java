package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.company.intranet.user_service.entities.RoleEntity;
import com.company.intranet.user_service.entities.dtos.RoleDto;

@Mapper(componentModel = "spring", uses = {IPermissionMapper.class})
public interface IRoleMapper {

    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    RoleDto roleEntitiesToRoleDto(RoleEntity entity);
    
    RoleEntity roleDtoToRoleEntity (RoleDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    void updateRoleFromDto (RoleDto dto, @MappingTarget RoleEntity entity);
}
