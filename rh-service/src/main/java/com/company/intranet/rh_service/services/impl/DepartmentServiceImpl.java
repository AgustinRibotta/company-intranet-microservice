package com.company.intranet.rh_service.services.impl;

import com.company.intranet.rh_service.dtos.request.DepartmentRequestDto;
import com.company.intranet.rh_service.dtos.response.DepartmentResponseDto;
import com.company.intranet.rh_service.entities.DepartmentEntity;
import com.company.intranet.rh_service.exeptions.IdNotFoundException;
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
        DepartmentEntity department = this.repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        return this.mapper.toDto(department);
    }

    @Override
    public DepartmentResponseDto save(DepartmentRequestDto request) {
        DepartmentEntity department = this.mapper.toEntity(request);
        return this.mapper.toDto(this.repository.save(department));
    }

    @Override
    public DepartmentResponseDto update(DepartmentRequestDto request, UUID id) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        mapper.updateEntityFromDto(request, department);
        return mapper.toDto(repository.save(department));

    }

    @Override
    public void delete(UUID id) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        this.repository.delete(department);
    }
}
