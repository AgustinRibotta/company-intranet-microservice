package com.company.intranet.rh_service.mappers;

import com.company.intranet.rh_service.dtos.response.DepartmentRequestDto;
import com.company.intranet.rh_service.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentRequestDto toEntity (DepartmentEntity entity);

    DepartmentEntity toDto (DepartmentRequestDto dto);
}
