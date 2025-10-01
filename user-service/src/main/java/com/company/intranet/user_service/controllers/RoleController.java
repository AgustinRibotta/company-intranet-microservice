package com.company.intranet.user_service.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/user-service")
public class RoleController {

    @Autowired
    IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/roles")
    public ResponseEntity<List<RoleDto>> retriveRoles() {
        return ResponseEntity.ok().body(this.roleService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/roles/role/{id}")
    public ResponseEntity<RoleDto> retriveRoleById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(this.roleService.findById(id));
    }

    // @PreAuthorize("@securytiConfigUser.isUser(#id) or hasRole('ADMIN')")
    @PreAuthorize("hasRole('ADMIN') or #id == principal.username")
    @GetMapping(path = "/user/{userId}/roles")
    public ResponseEntity<List<RoleDto>> retriveRoleByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok().body(this.roleService.findByUserId(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/roles")
    public ResponseEntity<RoleDto> saveRole(@Valid @RequestBody RoleDto roleDto) {
        RoleDto newRole = this.roleService.save(roleDto);
        URI location = URI.create("/user-service/roles/" + roleDto.getId());
        return ResponseEntity.created(location).body(newRole);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/roles/role/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable UUID id,@Valid @RequestBody RoleDto roleDto) {
        return ResponseEntity.ok().body(this.roleService.update(id, roleDto));
    }

    @DeleteMapping(path = "/roles/role/{id}")
    public ResponseEntity<?> delteRole (@PathVariable UUID id){
        this.roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
