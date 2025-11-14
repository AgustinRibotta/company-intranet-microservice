package com.company.intranet.user_service.controllers;


import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.company.intranet.user_service.entities.dtos.LoginResponse;
import com.company.intranet.user_service.entities.dtos.LoginRequest;
import com.company.intranet.user_service.entities.dtos.UserCreateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.company.intranet.user_service.entities.dtos.UserDto;
import com.company.intranet.user_service.services.IUserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/user-service/users")
@Tag(name = "Users", description = "Users management operations")
public class UserController {

    final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public ResponseEntity<LoginResponse> login (@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(this.userService.login(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(
            summary = "Retrive all User",
            description = "Accessible only to users with the ADMIN role"
    )
    @GetMapping()
    public ResponseEntity<List<UserDto>> retriveAllUsers() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }

    // @PreAuthorize("@securytiConfigUser.isUser(#id) or hasRole('ADMIN')")
    @PreAuthorize("hasRole('ADMIN') or #id == principal.username")
    @Operation(summary = "Retrieve user by ID",
            description = "Accessible to ADMIN users or the user themselves"
    )
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> retrivUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(this.userService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    @Operation(summary = "Create a new User",
            description = "Accessible only to users with the ADMIN role"
    )
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        UserDto newUser = this.userService.save(userCreateDto);
        URI location = URI.create("/user-service/users/" + newUser.getId());
        return ResponseEntity.created(location).body(newUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/user/{id}")
    @Operation(summary = "Update an existing User",
            description = "Accessible only to users with the ADMIN role"
    )
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @Valid @RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(this.userService.update(id, userCreateDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/user/{id}")
    @Operation(summary = "Delete a User",
            description = "Accessible only to users with the ADMIN role"
    )
    public ResponseEntity<?> delteUser(@PathVariable UUID id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
