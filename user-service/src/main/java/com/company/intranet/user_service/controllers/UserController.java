package com.company.intranet.user_service.controllers;


import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.intranet.user_service.dtos.request.UserAuthenticationRequest;
import com.company.intranet.user_service.dtos.request.UserCreateDto;
import com.company.intranet.user_service.dtos.response.AuthenticationResponse;
import com.company.intranet.user_service.dtos.response.UserDto;
import com.company.intranet.user_service.services.IUserService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Users", description = "Users management operations")
@RestController
@RequestMapping(path = "/user-service/users")
public class UserController {

    final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

//    Route responsible for receiving the user and verifying if it actually exists
    @Hidden
    @PostMapping("/valid")
    public ResponseEntity<AuthenticationResponse> login (@Valid @RequestBody UserAuthenticationRequest request) {
        return ResponseEntity.ok().body(this.userService.login(request));
    }

//    Route responsible for verifying if a user actually exists.
    @Hidden
    @GetMapping("/auth/{id}/exists")
    public ResponseEntity<Void> checkUserExists(@PathVariable UUID id) {
        boolean exists = this.userService.existsById(id);
        if (exists) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Retrieve all User",
            description = "Accessible only to users with the READ_USERS permission"
    )
    @PreAuthorize("hasAuthority('READ_USERS')")
    @GetMapping()
    public ResponseEntity<List<UserDto>> retrieveAllUsers() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }

    @Operation(summary = "Retrieve user by ID",
            description = "Accessible only to users with the READ_USERS permission or the user themselves"
    )
    @PreAuthorize("@securityConfigUser.isUser(#id) or hasAuthority('READ_USERS')")
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> retrieveUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(this.userService.findById(id));
    }

    @Operation(summary = "Create a new User",
            description = "Accessible only to users with the CREATE_USERS permission"
    )
    @PreAuthorize("hasAuthority('CREATE_USERS')")
    @PostMapping()
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        UserDto newUser = this.userService.save(userCreateDto);
        URI location = URI.create("/user-service/users/" + newUser.getId());
        return ResponseEntity.created(location).body(newUser);
    }

    @Operation(summary = "Update an existing User",
            description = "Accessible only to users with the WRITE_USERS permission"
    )
    @PreAuthorize("hasAuthority('WRITE_USERS')")
    @PutMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @Valid @RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(this.userService.update(id, userCreateDto));
    }

    @Operation(summary = "Delete a User",
            description = "Accessible only to users with the DELETE_USERS permission"
    )
    @PreAuthorize("hasAuthority('DELETE_USERS')")
    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
