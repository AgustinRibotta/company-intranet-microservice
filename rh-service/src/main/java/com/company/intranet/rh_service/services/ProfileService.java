package com.company.intranet.rh_service.services;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.response.ProfileResponseDto;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    List<ProfileResponseDto> findAll();
    ProfileResponseDto findById(UUID id);
    ProfileResponseDto save (ProfileRequestDto profileDto);
    ProfileResponseDto update (ProfileRequestDto profileDto, UUID id);
    void delete (UUID id);
}
