package com.company.intranet.rh_service.services.impl;

import com.company.intranet.rh_service.dtos.request.DepartmentRequestDto;
import com.company.intranet.rh_service.dtos.response.DepartmentResponseDto;
import com.company.intranet.rh_service.entities.DepartmentEntity;
import com.company.intranet.rh_service.mappers.DepartmentMapper;
import com.company.intranet.rh_service.repositories.DepartmentRepository;
import com.company.intranet.rh_service.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartmentResponseDto> findAll() {
        List< DepartmentEntity> departments = this.repository.findAll();
        return departments.stream()
                .map(this.mapper::toDto)
                .collect(Collectors.toList());
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
