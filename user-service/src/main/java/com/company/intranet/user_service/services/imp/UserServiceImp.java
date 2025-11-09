package com.company.intranet.user_service.services.imp;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.company.intranet.user_service.entities.dtos.UserCreateDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.intranet.user_service.entities.RoleEntity;
import com.company.intranet.user_service.entities.UserEntity;
import com.company.intranet.user_service.entities.dtos.UserDto;
import com.company.intranet.user_service.exeptions.IdNotFoundException;
import com.company.intranet.user_service.mappers.IUserMapper;
import com.company.intranet.user_service.repositories.IRoleRepository;
import com.company.intranet.user_service.repositories.IUserRepository;
import com.company.intranet.user_service.services.IUserService;

@Service
public class UserServiceImp implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserMapper userMapper;
    private final IRoleRepository roleRepository;

    public UserServiceImp(IUserRepository userRepository, IUserMapper userMapper, PasswordEncoder passwordEncoder,
            IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

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
                .orElseThrow(() -> new IdNotFoundException(id));
        return this.userMapper.userEntityToUserDto(userEntity);
    }

    @Override
    public UserDto save(UserCreateDto userCreateDto) {
        UserEntity newUser = new UserEntity();
        newUser.setName(userCreateDto.getName());
        newUser.setEmail(userCreateDto.getEmail());

        Set<RoleEntity> roles = userCreateDto.getRoles().stream()
                .map(r -> this.roleRepository.findById(r)
                        .orElseThrow(() -> new IdNotFoundException(r)))
                .collect(Collectors.toSet());

        newUser.setRoles(roles);
        newUser.setPassword(this.passwordEncoder.encode(userCreateDto.getPassword()));

        newUser = this.userRepository.save(newUser);
        return this.userMapper.userEntityToUserDto(newUser);
    }

    @Override
    public UserDto update(UUID id, UserCreateDto userCreateDto) {

        UserEntity userEntity = this.userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));

        userEntity.setName(userCreateDto.getName());
        userEntity.setEmail(userCreateDto.getEmail());

        if (userCreateDto.getRoles() != null) {
            Set<RoleEntity> roles = userCreateDto.getRoles().stream()
                    .map(r -> this.roleRepository.findById(r)
                            .orElseThrow(() -> new IdNotFoundException(r)))
                    .collect(Collectors.toSet());
            userEntity.setRoles(roles);
        }

        userEntity.setPassword(this.passwordEncoder.encode(userCreateDto.getPassword()));

        userEntity = this.userRepository.save(userEntity);

        return this.userMapper.userEntityToUserDto(userEntity);
    }

    @Override
    public void delete(UUID id) {
        this.userRepository.deleteById(id);
    }

}
