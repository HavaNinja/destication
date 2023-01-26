package com.destination.controller;

import com.destination.service.ConsumerUsersCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    private ConsumerUsersCounterService consumerUsersCounterService;

    @GetMapping
    public String getCounter() {
        return "Consumed users" + consumerUsersCounterService.getCounter().toString();
    }

    @DeleteMapping
    public void clear() {
        consumerUsersCounterService.dropCount();
    }
}
