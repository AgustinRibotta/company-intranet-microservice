package com.company.intranet.rh_service.controllers;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.response.ProfileResponseDto;
import com.company.intranet.rh_service.dtos.response.ProfileSummaryResponseDto;
import com.company.intranet.rh_service.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rh-service/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @PreAuthorize("hasAuthority('READ_PROFILE')")
    @GetMapping
    public ResponseEntity<List<ProfileSummaryResponseDto>> finAll() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @PreAuthorize("@securityConfigUser.isUser(#id) or hasAuthority('READ_PROFILE')")
    @GetMapping("/profile/{id}")
    public ResponseEntity<ProfileResponseDto> finById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@Validated @RequestBody ProfileRequestDto dto) {
        this.service.save(dto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority('UPDATE_PROFILE')")
    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponseDto> update(@Validated @RequestBody ProfileRequestDto dto, @PathVariable UUID id) {
        return ResponseEntity.ok().body(this.service.update(dto, id));
    }

    @PreAuthorize("hasAuthority('DELETE_PROFILE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
