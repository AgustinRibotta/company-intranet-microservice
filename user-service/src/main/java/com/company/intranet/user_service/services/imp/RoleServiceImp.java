package com.company.intranet.user_service.services.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.intranet.user_service.entities.dtos.RoleDto;
import com.company.intranet.user_service.repositories.IRoleRepository;
import com.company.intranet.user_service.services.IRoleService;

@Service
public class RoleServiceImp implements IRoleService {

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public List<RoleDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public RoleDto findById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
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
