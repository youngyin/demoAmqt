package com.example.demoamqt;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter jsonMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }
}
