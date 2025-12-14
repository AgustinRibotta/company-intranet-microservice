package com.company.intranet.rh_service.controllers;

import com.company.intranet.rh_service.dtos.request.DepartmentRequestDto;
import com.company.intranet.rh_service.dtos.response.DepartmentResponseDto;
import com.company.intranet.rh_service.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Tag(name = "Departments", description = "Departments management operations")
@RestController
@RequestMapping("/rh-service/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @Operation(
            summary = "Retrieve all Department",
            description = "Accessible only to user with thr READ_DP permission "
    )
    @PreAuthorize("hasAuthority('READ_DP')")
    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> findAll(){
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @Operation(
            summary = "Retrieve Department by id",
            description = "Accessible only to user with thr READ_DP permission "
    )
    @PreAuthorize("hasAuthority('READ_DP')")
    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentResponseDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @Operation(
            summary = "Create new Department",
            description = "Accessible only to user with thr CREATE_DP permission "
    )
    @PreAuthorize("hasAuthority('CREATE_DP')")
    @PostMapping()
    public ResponseEntity<DepartmentResponseDto> save (@Validated @RequestBody DepartmentRequestDto dto) {
        DepartmentResponseDto newD = this.service.save(dto);
        URI location = URI.create("/rh/departments/" + newD.getId());
        return ResponseEntity.created(location).body(newD);
    }

    @Operation(
            summary = "Update Department by id",
            description = "Accessible only to user with thr UPDATE_DP permission "
    )
    @PreAuthorize("hasAuthority('UPDATE_DP')")
    @PutMapping("/department/{id}")
    public ResponseEntity<DepartmentResponseDto> update (@RequestBody DepartmentRequestDto dto, @PathVariable UUID id) {
        return ResponseEntity.ok().body(this.service.update(dto, id));
    }

    @Operation(summary = "Delete a Department",
            description = "Accessible only to users with the DELETE_DP permission"
    )
    @PreAuthorize("hasAuthority('DELETE_DP')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable UUID id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
