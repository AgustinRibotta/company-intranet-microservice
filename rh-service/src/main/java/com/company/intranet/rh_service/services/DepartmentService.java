package com.company.intranet.rh_service.services;

import com.company.intranet.rh_service.entities.dtos.DepartmentRequestDto;

import java.util.List;
import java.util.UUID;

public interface DepartmentService{

    List<DepartmentRequestDto> finAll();
    DepartmentRequestDto finById(UUID id);
    DepartmentRequestDto save (DepartmentRequestDto departmentDto);
    DepartmentRequestDto update (DepartmentRequestDto departmentDto, UUID id);
    void delete (UUID id);
}
