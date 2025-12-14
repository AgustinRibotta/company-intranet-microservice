package com.company.intranet.rh_service.controllers;

import com.company.intranet.rh_service.dtos.request.ProfileRequestDto;
import com.company.intranet.rh_service.dtos.response.ProfileResponseDto;
import com.company.intranet.rh_service.dtos.response.ProfileSummaryResponseDto;
import com.company.intranet.rh_service.services.ProfileService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Users Profiles", description = "Users profiles management operations")
@RestController
@RequestMapping("/rh-service/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @Operation(
            summary = "Retrieve all User Profile",
            description = "Accessible only to users with the READ_PROFILE permission"
    )
    @PreAuthorize("hasAuthority('READ_PROFILE')")
    @GetMapping
    public ResponseEntity<List<ProfileSummaryResponseDto>> finAll() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @Operation(summary = "Retrieve user profile by ID",
            description = "Accessible only to users with the READ_PROFILE permission or the user themselves"
    )
    @PreAuthorize("@securityConfigUser.isUser(#id) or hasAuthority('READ_PROFILE')")
    @GetMapping("/profile/{id}")
    public ResponseEntity<ProfileResponseDto> finById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    // Endpoint responsible for creating users profiles sent from another microservice.
    @Hidden
    @PostMapping("/create")
    public ResponseEntity<?> save(@Validated @RequestBody ProfileRequestDto dto) {
        this.service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update an existing User profile",
            description = "Accessible only to users with the UPDATE_PROFILE permission"
    )
    @PreAuthorize("hasAuthority('UPDATE_PROFILE')")
    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponseDto> update(@Validated @RequestBody ProfileRequestDto dto, @PathVariable UUID id) {
        return ResponseEntity.ok().body(this.service.update(dto, id));
    }

    @Operation(summary = "Delete a User profile",
            description = "Accessible only to users with the DELETE_PROFILE permission"
    )
    @PreAuthorize("hasAuthority('DELETE_PROFILE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
