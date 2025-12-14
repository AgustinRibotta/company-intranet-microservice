package com.company.intranet.user_service.controllers;

import com.company.intranet.user_service.dtos.request.RoleCreateDto;
import com.company.intranet.user_service.dtos.response.RoleDto;
import com.company.intranet.user_service.services.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Tag(name = "Roles", description = "Role management operations")
@RestController
@RequestMapping("/user-service/roles")
public class RoleController {

    @Autowired
    IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Operation(
            summary = "Retrieve all roles",
            description = "Accessible only to users with the READ_ROLES permission"
    )
    @PreAuthorize("hasAuthority('READ_ROLES')")
    @GetMapping()
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @Operation(summary = "Retrieve a role by ID",
            description = "Accessible only to users with the READ_ROLES permission"
    )
    @PreAuthorize("hasAuthority('READ_ROLES')")
    @GetMapping("/role/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable UUID id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @Operation(summary = "Retrieve roles by user ID",
            description = "Accessible to users with the READ_ROLES permission or the user themselves"
    )
    @PreAuthorize("@securityConfigUser.isUser(#userId) or hasAuthority('READ_ROLES')")
    @GetMapping("/user/{userId}/roles")
    public ResponseEntity<List<RoleDto>> getRolesByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(roleService.findByUserId(userId));
    }

    @Operation(summary = "Create a new role",
            description = "Accessible only to users with the CREATE_ROLES permission"
    )
    @PreAuthorize("hasAuthority('CREATE_ROLES')")
    @PostMapping()
    public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleCreateDto roleCreateDto) {
        RoleDto newRole = roleService.save(roleCreateDto);
        URI location = URI.create("/user-service/roles/" + newRole.getId());
        return ResponseEntity.created(location).body(newRole);
    }

    @Operation(summary = "Update an existing role",
            description = "Accessible only to users with the UPDATE_ROLES permission"
    )
    @PreAuthorize("hasAuthority('UPDATE_ROLES')")
    @PutMapping("/role/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable UUID id, @Valid @RequestBody RoleCreateDto roleCreateDto) {
        return ResponseEntity.ok(roleService.update(id, roleCreateDto));
    }

    @Operation(summary = "Delete a role",
            description = "Accessible only to users with the DELETE_ROLES permission"
    )
    @PreAuthorize("hasAuthority('DELETE_ROLES')")
    @DeleteMapping("/role/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
