package com.destination.service;

import com.destination.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private ConsumerUsersCounterService consumerUsersCounterService;

    public void consumeUser(final User user) {
        consumerUsersCounterService.countConsumedUser();
        log.info("User {} {}:{} has been consumed", user.getFirstName(), user.getLastName(), user.getId());
    }
}
