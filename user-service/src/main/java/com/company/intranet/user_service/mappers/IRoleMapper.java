package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.company.intranet.user_service.entities.RoleEntity;
import com.company.intranet.user_service.entities.dtos.RoleDto;

@Mapper(componentModel = "spring", uses = {IPermissionMapper.class})
public interface IRoleMapper {

    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    RoleDto roleEntitiesToRoleDto(RoleEntity roleEntity);
    
    RoleEntity roleDtoToRoleEntity (RoleDto roleDto);

}
