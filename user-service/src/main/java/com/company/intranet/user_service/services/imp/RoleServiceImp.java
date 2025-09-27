package com.company.intranet.user_service.services.imp;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.company.intranet.user_service.entities.RoleEntity;
import com.company.intranet.user_service.entities.UserEntity;
import com.company.intranet.user_service.entities.dtos.RoleDto;
import com.company.intranet.user_service.exeptions.IdNotFoundException;
import com.company.intranet.user_service.mappers.IRoleMapper;
import com.company.intranet.user_service.repositories.IRoleRepository;
import com.company.intranet.user_service.repositories.IUserRepository;
import com.company.intranet.user_service.services.IRoleService;

@Service
public class RoleServiceImp implements IRoleService {

    IRoleRepository roleRepository;
    IRoleMapper roleMapper;
    IUserRepository userRepository;

    public RoleServiceImp(IRoleRepository roleRepository, IRoleMapper roleMapper, IUserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<RoleDto> findAll() {
        List<RoleEntity> roleEntities = this.roleRepository.findAll();
        return roleEntities.stream()
        .map(role -> {
            RoleDto dto = this.roleMapper.roleEntitiesToRoleDto(role);
            return dto;
        })
        .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(UUID id) {
        RoleEntity userEntity = this.roleRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException(id));
        return this.roleMapper.roleEntitiesToRoleDto(userEntity);
    }

    @Override
    public List<RoleDto> findByUserId(UUID userId) {
        UserEntity userEntity = this.userRepository.findById(userId)
            .orElseThrow(() -> new IdNotFoundException(userId));

        Set<RoleEntity> roleEntities = userEntity.getRoles();
        
        return roleEntities.stream()
        .map(role -> {
            RoleDto dto = this.roleMapper.roleEntitiesToRoleDto(role);
            return dto;
        })
        .collect(Collectors.toList());

    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public RoleDto update(UUID id, RoleDto roleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



}
