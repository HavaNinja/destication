package com.destination.controller;

import com.destination.model.User;
import com.destination.service.RandomExceptionService;
import com.destination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RandomExceptionService randomExceptionService;

    @PostMapping
    public void postUser(@RequestBody User user) {
        randomExceptionService.testYourLuck();
        userService.consumeUser(user);
    }
}
