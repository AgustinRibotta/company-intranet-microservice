package com.company.intranet.user_service.controllers;

import com.company.intranet.user_service.entities.dtos.RoleCreateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.intranet.user_service.entities.dtos.RoleDto;
import com.company.intranet.user_service.services.IRoleService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user-service")
@Tag(name = "Roles", description = "Role management operations")
public class RoleController {

    @Autowired
    IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(
            summary = "Retrieve all roles",
            description = "Accessible only to users with the ADMIN role"
    )
    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Retrieve a role by ID",
            description = "Accessible only to users with the ADMIN role"
    )
    @GetMapping("/roles/role/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable UUID id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN') or #userId == principal.username")
    @Operation(summary = "Retrieve roles by user ID",
            description = "Accessible to ADMIN users or the user themselves"
    )
    @GetMapping("/user/{userId}/roles")
    public ResponseEntity<List<RoleDto>> getRolesByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(roleService.findByUserId(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new role",
            description = "Accessible only to users with the ADMIN role"
    )
    @PostMapping("/roles")
    public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleCreateDto roleCreateDto) {
        RoleDto newRole = roleService.save(roleCreateDto);
        URI location = URI.create("/user-service/roles/" + newRole.getId());
        return ResponseEntity.created(location).body(newRole);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update an existing role",
            description = "Accessible only to users with the ADMIN role"
    )
    @PutMapping("/roles/role/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable UUID id, @Valid @RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(roleService.update(id, roleDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a role",
            description = "Accessible only to users with the ADMIN role"
    )
    @DeleteMapping("/roles/role/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
