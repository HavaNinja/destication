package com.translation.service;

import com.translation.client.DestinationClientService;
import com.translation.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DeadLetterQueueListener {
    @Autowired
    private DestinationClientService destinationClientService;

    @RabbitListener(queues = "deadLetter.queue")
    public void handleQueueMessage(final User user) {
        destinationClientService.postUser(user);
        log.info("User {} {} with id: {} was retrieved for dead latter queue and send to the consumer", user.getFirstName(), user.getLastName(), user.getId());
    }
}
