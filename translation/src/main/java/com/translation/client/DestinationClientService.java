package com.translation.client;

import com.translation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DestinationClientService {
    @Autowired
    private RestTemplate restTemplate;

    public void postUser(final User user) {
        restTemplate.postForEntity("/api/users", user, Void.class);
    }

}
