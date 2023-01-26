package com.translation.service;

import com.translation.client.DestinationClientService;
import com.translation.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueListener {
    @Autowired
    private DestinationClientService destinationClientService;

    @RabbitListener(queues = "javainuse.queue")
    public void recievedMessage(final User user) {

        destinationClientService.postUser(user);
        log.info("User {} {} with id: {} was received and send to the consumer", user.getFirstName(), user.getLastName(), user.getId());
    }
}
