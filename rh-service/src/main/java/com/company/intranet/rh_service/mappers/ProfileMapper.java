package com.company.intranet.rh_service.mappers;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.response.ProfileResponseDto;
import com.company.intranet.rh_service.dtos.response.ProfileSummaryResponseDto;
import com.company.intranet.rh_service.entities.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);


    ProfileEntity toEntity (ProfileRequestDto dto);

    ProfileSummaryResponseDto toSummaryDto (ProfileEntity entity);

    ProfileResponseDto toDto (ProfileEntity entity);

    void updateEntityFromDto (ProfileRequestDto dto, @MappingTarget ProfileEntity entity);
}
