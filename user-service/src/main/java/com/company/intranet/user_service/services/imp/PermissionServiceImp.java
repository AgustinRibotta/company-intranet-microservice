package com.company.intranet.user_service.services.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.intranet.user_service.entities.dtos.PermissionDto;
import com.company.intranet.user_service.repositories.IPermissionRepository;
import com.company.intranet.user_service.services.IPermissionService;

@Service
public class PermissionServiceImp implements IPermissionService {

    @Autowired
    IPermissionRepository permissionRepository;

    @Override
    public List<PermissionDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public PermissionDto findById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public PermissionDto save(PermissionDto permissionDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public PermissionDto update(UUID id, PermissionDto permissionDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
