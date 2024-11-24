package com.example.demoamqt;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String EXCHANGE_NAME = "exampleExchange";
    public static final String QUEUE_NAME = "exampleQueue";
    public static final String ROUTING_KEY = "exampleRoutingKey";

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, true); // Durable queue
    }

    @Bean
    public DirectExchange exampleExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue exampleQueue, DirectExchange exampleExchange) {
        return BindingBuilder.bind(exampleQueue).to(exampleExchange).with(ROUTING_KEY);
    }
}
