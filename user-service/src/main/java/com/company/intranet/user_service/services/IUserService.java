package com.company.intranet.user_service.services;

import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.UserDto;

public interface IUserService  {

    List<UserDto> findAll();
    UserDto findById(UUID id);
    UserDto save(UserDto userDto);
    UserDto update (UUID id, UserDto userDto);
    void delete (UUID id);

}
