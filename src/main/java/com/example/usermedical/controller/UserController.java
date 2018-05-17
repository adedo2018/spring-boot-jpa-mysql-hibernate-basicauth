package com.example.usermedical.controller;

import com.example.usermedical.model.User;
import com.example.usermedical.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sample controller to retrieve a user
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * retrieve a user provided the id
     * @param id to retrieve a user
     * @return a user whose id is provided
     */
    @GetMapping("/users/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }
}
