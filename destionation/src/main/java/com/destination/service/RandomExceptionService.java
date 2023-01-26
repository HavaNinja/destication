package com.destination.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class RandomExceptionService {
    final Random random = new Random();
    public void testYourLuck() {

        int randomInt =  random.nextInt(50 - 1) + 1;
        if (randomInt > 25) {
            throw new RuntimeException("Some exception was throw, test your luck a little bit later ;)");
        }
    }
}
