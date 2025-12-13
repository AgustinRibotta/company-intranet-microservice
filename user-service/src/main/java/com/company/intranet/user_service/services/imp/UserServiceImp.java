package com.company.intranet.user_service.services.imp;

import com.company.intranet.user_service.dtos.request.RhRequest;
import com.company.intranet.user_service.dtos.request.UserAuthenticationRequest;
import com.company.intranet.user_service.dtos.request.UserCreateDto;
import com.company.intranet.user_service.dtos.response.AuthenticationResponse;
import com.company.intranet.user_service.dtos.response.UserDto;
import com.company.intranet.user_service.entities.PermissionEntity;
import com.company.intranet.user_service.entities.RoleEntity;
import com.company.intranet.user_service.entities.UserEntity;
import com.company.intranet.user_service.exeptions.ExternalServiceException;
import com.company.intranet.user_service.exeptions.IdNotFoundException;
import com.company.intranet.user_service.mappers.IUserMapper;
import com.company.intranet.user_service.proxy.RhServiceProxy;
import com.company.intranet.user_service.repositories.IRoleRepository;
import com.company.intranet.user_service.repositories.IUserRepository;
import com.company.intranet.user_service.services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserMapper userMapper;
    private final IRoleRepository roleRepository;
    private final RhServiceProxy proxy;

    public UserServiceImp(IUserRepository userRepository, IUserMapper userMapper, PasswordEncoder passwordEncoder,
                          IRoleRepository roleRepository, RhServiceProxy proxy) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
        this.proxy = proxy;
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

        createRhProfile(newUser);

        return this.userMapper.userEntityToUserDto(newUser);
    }

    private void createRhProfile(UserEntity user) {
        RhRequest request = new RhRequest();
        request.setUserId(user.getId());
        request.setFirstName(user.getName());
        request.setEmail(user.getEmail());

        ResponseEntity<Void> response = proxy.create(request);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ExternalServiceException(
                    "RH service responded with status: " + response.getStatusCode()
            );
        }

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


    @Override
    public AuthenticationResponse login(UserAuthenticationRequest request) {

        UserEntity authUser = this.userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User with email not found"));

        if (!passwordEncoder.matches(request.getPassword(), authUser.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        Set<String> rolesName = authUser.getRoles().stream()
                .map(RoleEntity::getName)
                .collect(Collectors.toSet());

        Set<String> permissionsName = authUser.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(PermissionEntity::getName)
                .collect(Collectors.toSet());

        return new AuthenticationResponse(
                authUser.getId(),
                authUser.getEmail(),
                rolesName,
                permissionsName
        );
    }

}
