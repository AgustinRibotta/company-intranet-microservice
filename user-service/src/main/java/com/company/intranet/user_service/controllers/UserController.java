package com.company.intranet.user_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.company.intranet.user_service.entities.dtos.UserDto;
import com.company.intranet.user_service.services.IUserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping( path = "/users")
    public ResponseEntity<List<UserDto>> retriveAllUsers () {
        return ResponseEntity.ok().body(userService.findAll());
    }
        

}
