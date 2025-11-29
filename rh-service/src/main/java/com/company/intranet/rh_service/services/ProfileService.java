package com.company.intranet.rh_service.services;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.request.ProfileResponseDto;

import java.util.UUID;

public interface ProfileService {
    ProfileResponseDto findById(UUID id);
    void save (ProfileRequestDto profileDto);
    ProfileResponseDto update (ProfileRequestDto profileDto, UUID id);
    void delete (UUID id);
}
