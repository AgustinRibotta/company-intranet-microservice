package com.company.intranet.user_service.services.imp;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.intranet.user_service.entities.UserEntity;
import com.company.intranet.user_service.entities.dtos.UserDto;
import com.company.intranet.user_service.exeptions.UserNotFoundException;
import com.company.intranet.user_service.mappers.IUserMapper;
import com.company.intranet.user_service.repositories.IUserRepository;
import com.company.intranet.user_service.services.IUserService;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> usersEntities = this.userRepository.findAll();
        return usersEntities.stream()
                .map(user -> {
                    UserDto dto = this.userMapper.userEntityToUserDto(user);
                    dto.setPassword(null);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(UUID id) {
        UserEntity userEntity = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return this.userMapper.userEntityToUserDto(userEntity);
    }

    @Override
    public UserDto save(UserDto userDto) {

        UserEntity newUser = this.userMapper.userDtoUserEntity(userDto);
        return this.userMapper.userEntityToUserDto(this.userRepository.save(newUser));        

    }

    @Override
    public UserDto update(UUID id, UserDto userDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
