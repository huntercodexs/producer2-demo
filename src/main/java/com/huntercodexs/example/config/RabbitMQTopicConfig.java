package com.huntercodexs.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("exchange-3-topic");
    }

    @Bean
    public Queue queue1Topic() {
        return new Queue("queue-1-topic", true);
    }

    @Bean
    public Queue queue2Topic() {
        return new Queue("queue-2.1-topic", true);
    }

    @Bean
    public Queue queue22Topic() {
        return new Queue("queue-2.2-topic", true);
    }

    @Bean
    public Queue queue3Topic() {
        return new Queue("queue-3-topic", true);
    }

    @Bean
    Binding binding1Topic(Queue queue1Topic, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue1Topic)
                .to(topicExchange)
                .with("routingKey-1-topic");
    }

    @Bean
    Binding binding2Topic(Queue queue2Topic, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue2Topic)
                .to(topicExchange)
                .with("routingKey-2.1-topic");
    }

    @Bean
    Binding binding22Topic(Queue queue22Topic, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue22Topic)
                .to(topicExchange)
                .with("routingKey-2.*");
    }

    @Bean
    Binding binding3Topic(Queue queue3Topic, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue3Topic)
                .to(topicExchange)
                .with("routingKey-3-topic");
    }

}
