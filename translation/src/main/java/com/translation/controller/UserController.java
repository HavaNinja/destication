package com.translation.controller;

import com.translation.client.DestinationClientService;
import com.translation.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private DestinationClientService destinationClientService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping
    public Integer postUser(@RequestBody final List<User> users) {

        users.forEach(user -> amqpTemplate.convertAndSend("javainuseExchange", "javainuse", user));

        for (int i = 0; i <users.size() ; i++) {
            destinationClientService.postUser(users.get(i));

        }

        return users.size();
    }
}
