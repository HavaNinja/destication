package com.destination.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Getter
public class ConsumerUsersCounterService {
    private Integer counter = 0;

    public void countConsumedUser() {
        counter++;
    }

    public void dropCount() {
        counter = 0;
    }
}
