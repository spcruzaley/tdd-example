package com.tdd.example.controller;

import com.tdd.example.model.User;
import com.tdd.example.service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers() {
        return userService.getUsers();
    }
}
