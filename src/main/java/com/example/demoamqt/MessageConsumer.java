package com.example.demoamqt;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Message received from queue: " + message);
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveMessage(MessageDto message) {
        System.out.println("Message received: " + message);
    }
}
