package com.company.intranet.rh_service.services.impl;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.response.ProfileResponseDto;
import com.company.intranet.rh_service.dtos.response.ProfileSummaryResponseDto;
import com.company.intranet.rh_service.entities.DepartmentEntity;
import com.company.intranet.rh_service.entities.ProfileEntity;
import com.company.intranet.rh_service.exeptions.IdNotFoundException;
import com.company.intranet.rh_service.mappers.ProfileMapper;
import com.company.intranet.rh_service.repositories.DepartmentRepository;
import com.company.intranet.rh_service.repositories.ProfileRepository;
import com.company.intranet.rh_service.services.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final DepartmentRepository departmentRepository;
    private final ProfileMapper mapper;

    public ProfileServiceImpl(ProfileRepository repository, DepartmentRepository departmentRepository, ProfileMapper mapper) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProfileSummaryResponseDto> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::toSummaryDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileResponseDto findById(UUID id) {
        ProfileEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        return this.mapper.toDto(entity) ;
    }

    @Override
    public ProfileResponseDto save(ProfileRequestDto dto) {
        ProfileEntity entity = this.mapper.toEntity(dto);
        DepartmentEntity department = this.departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new IdNotFoundException(dto.getDepartmentId()));
        entity.setDepartment(department);
        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public ProfileResponseDto update(ProfileRequestDto dto, UUID id) {
        ProfileEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        mapper.updateEntityFromDto(dto, entity);
        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public void delete(UUID id) {
        ProfileEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        this.repository.delete(entity);

    }
}
