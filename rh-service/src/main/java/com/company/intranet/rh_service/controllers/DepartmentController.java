package com.company.intranet.rh_service.controllers;

import com.company.intranet.rh_service.dtos.request.DepartmentRequestDto;
import com.company.intranet.rh_service.dtos.response.DepartmentResponseDto;
import com.company.intranet.rh_service.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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


    @PreAuthorize("hasAuthority('READ_DP')")
    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentResponseDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @PreAuthorize("hasAuthority('CREATE_DP')")
    @PostMapping()
    public ResponseEntity<DepartmentResponseDto> save (@Validated @RequestBody DepartmentRequestDto dto) {
        DepartmentResponseDto newD = this.service.save(dto);
        URI location = URI.create("/rh/departments/" + newD.getId());
        return ResponseEntity.created(location).body(newD);
    }

    @PreAuthorize("hasAuthority('UPDATE_DP')")
    @PutMapping("/department/{id}")
    public ResponseEntity<DepartmentResponseDto> update (@RequestBody DepartmentRequestDto dto, @PathVariable UUID id) {
        return ResponseEntity.ok().body(this.service.update(dto, id));
    }

    @PreAuthorize("hasAuthority('DELETE_DP')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable UUID id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
