package com.company.intranet.user_service.controllers;


import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.company.intranet.user_service.entities.dtos.UserDto;
import com.company.intranet.user_service.services.IUserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDto>> retriveAllUsers() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<UserDto> retrivUserById(@PathVariable UUID id) {

        UserDto user = this.userService.findById(id);

        EntityModel<UserDto> entityModel = EntityModel.of(user);
        entityModel.add(Link.of("/user-service/users").withRel("all-users"));

        return entityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {

        UserDto newUser = this.userService.save(userDto);
        URI location = URI.create("/user-service/users/" + newUser.getId());
            
        return  ResponseEntity.created(location).body(newUser);
    }

}
