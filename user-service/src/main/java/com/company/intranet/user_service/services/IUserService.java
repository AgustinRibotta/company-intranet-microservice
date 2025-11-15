package com.company.intranet.user_service.services;

import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.UserAuthenticationResponse;
import com.company.intranet.user_service.entities.dtos.UserAuthenticationRequest;
import com.company.intranet.user_service.entities.dtos.UserCreateDto;
import com.company.intranet.user_service.entities.dtos.UserDto;

public interface IUserService  {

    List<UserDto> findAll();
    UserDto findById(UUID id);
    UserDto save(UserCreateDto userDto);
    UserDto update (UUID id, UserCreateDto userDto);
    void delete (UUID id);
    UserAuthenticationResponse login (UserAuthenticationRequest request);

}
