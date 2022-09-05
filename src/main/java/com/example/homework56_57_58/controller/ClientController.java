package com.example.homework56_57_58.controller;

import com.example.homework56_57_58.model.User;
import com.example.homework56_57_58.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class ClientController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration-user")
    public String registrationUser(@RequestBody User user) {
        userService.registrationUser(user);
        return "USER REGISTRATION GOOD!";
    }
}
