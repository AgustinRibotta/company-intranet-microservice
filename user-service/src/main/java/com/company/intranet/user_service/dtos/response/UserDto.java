package com.company.intranet.user_service.dtos.response;

import java.util.Set;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {

    @Schema(description = "Unique identifier of user role", example = "550e8400-e29b-41d4-a716-446655440000")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;

    @Schema(description = "Name of the user", example = "admin", required = true)
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "Email of the user", example = "admin@admin.com", required = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty(message = "Roles cannot be empty")
    private Set<RoleDto> roles;

    public UserDto() {
    }

    public UserDto(UUID id, @NotBlank(message = "Name is required") String name,
            @NotBlank(message = "Name is required") @Email(message = "Invalid email format") String email,
            @NotBlank(message = "Password is required") String password, Set<RoleDto> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

}
