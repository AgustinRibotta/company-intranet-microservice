package com.company.intranet.user_service.controllers;


import com.company.intranet.user_service.dtos.request.UserAuthenticationRequest;
import com.company.intranet.user_service.dtos.request.UserCreateDto;
import com.company.intranet.user_service.dtos.response.AuthenticationResponse;
import com.company.intranet.user_service.dtos.response.UserDto;
import com.company.intranet.user_service.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/user-service/users")
@Tag(name = "Users", description = "Users management operations")
public class UserController {

    final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/valid")
    public ResponseEntity<AuthenticationResponse> login (@Valid @RequestBody UserAuthenticationRequest request) {
        return ResponseEntity.ok().body(this.userService.login(request));
    }

    @PreAuthorize("hasAuthority('READ_USERS')")
    @Operation(
            summary = "Retrive all User",
            description = "Accessible only to users with the ADMIN role"
    )
    @GetMapping()
    public ResponseEntity<List<UserDto>> retriveAllUsers() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }

    @PreAuthorize("@securityConfigUser.isUser(#id) or hasAuthority('READ_USERS')")
    @Operation(summary = "Retrieve user by ID",
            description = "Accessible to ADMIN users or the user themselves"
    )
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> retrivUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(this.userService.findById(id));
    }

    @PreAuthorize("hasAuthority('CREATE_USERS')")
    @PostMapping()
    @Operation(summary = "Create a new User",
            description = "Accessible only to users with the ADMIN role"
    )
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        UserDto newUser = this.userService.save(userCreateDto);
        URI location = URI.create("/user-service/users/" + newUser.getId());
        return ResponseEntity.created(location).body(newUser);
    }

    @PreAuthorize("hasAuthority('WRITE_USERS')")
    @PutMapping(path = "/user/{id}")
    @Operation(summary = "Update an existing User",
            description = "Accessible only to users with the ADMIN role"
    )
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @Valid @RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(this.userService.update(id, userCreateDto));
    }

    @PreAuthorize("hasAuthority('DELETE_USERS')")
    @DeleteMapping(path = "/user/{id}")
    @Operation(summary = "Delete a User",
            description = "Accessible only to users with the ADMIN role"
    )
    public ResponseEntity<?> delteUser(@PathVariable UUID id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
