package com.company.intranet.rh_service.services.impl;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.response.ProfileResponseDto;
import com.company.intranet.rh_service.dtos.response.ProfileSummaryResponseDto;
import com.company.intranet.rh_service.entities.DepartmentEntity;
import com.company.intranet.rh_service.entities.ProfileEntity;
import com.company.intranet.rh_service.exeptions.IdNotFoundException;
import com.company.intranet.rh_service.mappers.ProfileMapper;
import com.company.intranet.rh_service.proxy.UserServiceProxy;
import com.company.intranet.rh_service.repositories.DepartmentRepository;
import com.company.intranet.rh_service.repositories.ProfileRepository;
import com.company.intranet.rh_service.services.ProfileService;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final DepartmentRepository departmentRepository;
    private final ProfileMapper mapper;
    private final UserServiceProxy proxy;

    public ProfileServiceImpl(ProfileRepository repository, DepartmentRepository departmentRepository, ProfileMapper mapper, UserServiceProxy proxy) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
        this.proxy = proxy;
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
    public ProfileResponseDto save(ProfileRequestDto request) {
        ProfileEntity profile = this.mapper.toEntity(request);
        if (request.getDepartmentId() != null) {
            DepartmentEntity dept = departmentRepository
                    .findById(request.getDepartmentId())
                    .orElseThrow(() ->
                            new IdNotFoundException(request.getDepartmentId()));

            profile.setDepartment(dept);
        } else {
            profile.setDepartment(null);
        }
        return this.mapper.toDto(this.repository.save(profile));
    }

    @Override
    public ProfileResponseDto update(ProfileRequestDto request, UUID id) {

        ProfileEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));

        try {
            this.proxy.auth(entity.getUserId());
        } catch (FeignException.NotFound e) {
            throw new IdNotFoundException(entity.getUserId());
        }

        if (request.getDepartmentId() != null) {
            DepartmentEntity department = this.departmentRepository.findById(request.getDepartmentId())
                    .orElseThrow(() -> new IdNotFoundException(request.getDepartmentId()));
            entity.setDepartment(department);
        }
        this.mapper.updateEntityFromDto(request, entity);

        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public void delete(UUID id) {
        ProfileEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        this.repository.delete(entity);

    }
}
