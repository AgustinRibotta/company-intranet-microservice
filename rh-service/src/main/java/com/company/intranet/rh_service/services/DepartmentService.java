package com.company.intranet.rh_service.services;

import com.company.intranet.rh_service.dtos.response.DepartmentRequestDto;
import com.company.intranet.rh_service.dtos.response.DepartmentResponseDto;

import java.util.List;
import java.util.UUID;

public interface DepartmentService{

    List<DepartmentResponseDto> findAll();
    DepartmentResponseDto findById(UUID id);
    DepartmentResponseDto save (DepartmentRequestDto departmentDto);
    DepartmentResponseDto update (DepartmentRequestDto departmentDto, UUID id);
    void delete (UUID id);
}
