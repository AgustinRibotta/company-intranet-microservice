package com.company.intranet.user_service.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;
import java.util.UUID;

@Schema(description = "User information for create or update ")
public class UserCreateDto {
    @Schema(description = "Name of the user", example = "admin")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "Email of the user", example = "admin@admin.com")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Password of the user", example = "admin")
    @NotBlank(message = "Password is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Schema(description = "Roles of the user", example = "123e4567-e89b-12d3-a456-426614174000")
    @NotEmpty(message = "Roles cannot be empty")
    private Set<UUID> roles;

    public UserCreateDto() {
    }

    public UserCreateDto(String name, String email, String password, Set<UUID> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public Set<UUID> getRoles() {
        return roles;
    }

    public void setRoles(Set<UUID> roles) {
        this.roles = roles;
    }
}
