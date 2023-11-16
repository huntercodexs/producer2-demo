package com.huntercodexs.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("exchange-1-direct");
    }

    @Bean
    public Queue queue1Direct() {
        return new Queue("queue-1-direct", true);
    }

    @Bean
    public Queue queue2Direct() {
        return new Queue("queue-2-direct", true);
    }

    @Bean
    public Queue queue3Direct() {
        return new Queue("queue-3-direct", true);
    }

    @Bean
    Binding binding1Direct(Queue queue1Direct, DirectExchange directExchange) {
        return BindingBuilder
                .bind(queue1Direct)
                .to(directExchange)
                .with("routingKey-1-direct");
    }

    @Bean
    Binding binding2Direct(Queue queue2Direct, DirectExchange directExchange) {
        return BindingBuilder
                .bind(queue2Direct)
                .to(directExchange)
                .with("routingKey-2-direct");
    }

    @Bean
    Binding binding3Direct(Queue queue3Direct, DirectExchange directExchange) {
        return BindingBuilder
                .bind(queue3Direct)
                .to(directExchange)
                .with("routingKey-3-direct");
    }

}
