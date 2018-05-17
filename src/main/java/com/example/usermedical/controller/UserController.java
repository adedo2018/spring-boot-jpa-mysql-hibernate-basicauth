package com.example.usermedical.controller;

import com.example.usermedical.model.User;
import com.example.usermedical.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }
}
