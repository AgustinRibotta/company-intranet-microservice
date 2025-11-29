package com.company.intranet.rh_service.services.impl;

import com.company.intranet.rh_service.dtos.response.DepartmentRequestDto;
import com.company.intranet.rh_service.dtos.response.DepartmentResponseDto;
import com.company.intranet.rh_service.repositories.DepartmentRepository;
import com.company.intranet.rh_service.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<DepartmentResponseDto> findAll() {
        return List.of();
    }

    @Override
    public DepartmentResponseDto findById(UUID id) {
        return null;
    }

    @Override
    public DepartmentResponseDto save(DepartmentRequestDto departmentDto) {
        return null;
    }

    @Override
    public DepartmentResponseDto update(DepartmentRequestDto departmentDto, UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
