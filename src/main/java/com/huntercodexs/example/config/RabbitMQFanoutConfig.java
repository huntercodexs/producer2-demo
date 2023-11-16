package com.huntercodexs.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("exchange-2-fanout");
    }

    @Bean
    public Queue queue1Fanout() {
        return new Queue("queue-1-fanout", true);
    }

    @Bean
    public Queue queue2Fanout() {
        return new Queue("queue-2-fanout", true);
    }

    @Bean
    public Queue queue3Fanout() {
        return new Queue("queue-3-fanout", true);
    }

    @Bean
    Binding binding1Fanout(Queue queue1Fanout, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(queue1Fanout)
                .to(fanoutExchange);
    }

    @Bean
    Binding binding2Fanout(Queue queue2Fanout, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(queue2Fanout)
                .to(fanoutExchange);
    }

    @Bean
    Binding binding3Fanout(Queue queue3Fanout, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(queue3Fanout)
                .to(fanoutExchange);
    }

}
