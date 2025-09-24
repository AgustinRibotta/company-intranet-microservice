package com.company.intranet.user_service.controllers;


import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
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
@RequestMapping("/user-service")
public class UserController {

    final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDto>> retriveAllUsers() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }

    @GetMapping(path = "/users/user/{id}")
    public ResponseEntity<UserDto> retrivUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body( this.userService.findById(id));
    }

    @PostMapping(path = "/users")
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {

        UserDto newUser = this.userService.save(userDto);
        URI location = URI.create("/user-service/users/" + newUser.getId());
            
        return  ResponseEntity.created(location).body(newUser);
    }

    @PutMapping( path = "/users/user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id,@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.userService.update(id, userDto));
    }

    @DeleteMapping( path = "/users/user/{id}")
    public ResponseEntity<?> delteUser (@PathVariable UUID id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
