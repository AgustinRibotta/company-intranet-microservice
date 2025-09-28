package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.company.intranet.user_service.entities.UserEntity;
import com.company.intranet.user_service.entities.dtos.UserDto;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class} )
public interface IUserMapper {

    IUserMapper INSTANCE  = Mappers.getMapper(IUserMapper.class);

    UserDto userEntityToUserDto(UserEntity entity);

    UserEntity userDtoUserEntity(UserDto dto);

    @Mapping(target = "id", ignore = true)
    void updateUserFromDto(UserDto dto, @MappingTarget UserEntity entity);
}
