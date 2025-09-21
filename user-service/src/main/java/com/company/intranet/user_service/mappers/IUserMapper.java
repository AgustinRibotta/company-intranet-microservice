package com.company.intranet.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.company.intranet.user_service.entities.UserEntity;
import com.company.intranet.user_service.entities.dtos.UserDto;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class} )
public interface IUserMapper {

    IUserMapper INSTANCE  = Mappers.getMapper(IUserMapper.class);

    UserDto userEntityToUserDto(UserEntity usereEntity);

    UserEntity userDtoUserEntity(UserDto userDto);

}
