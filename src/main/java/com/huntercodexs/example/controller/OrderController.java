package com.huntercodexs.example.controller;

//import com.huntercodexs.example.config.QueueSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
@CrossOrigin(origins = "*")
public class OrderController {

    private final AmqpTemplate amqpTemplate;

    public OrderController(AmqpTemplate queueSender) {
        this.amqpTemplate = queueSender;
    }

    @GetMapping("/producer2-demo/direct/1")
    public String direct1(){
        amqpTemplate.convertAndSend("exchange-1-direct", "routingKey-1-direct", "test message to DIRECT");
        return "DIRECT 1 OK !";
    }

    @GetMapping("/producer2-demo/direct/2")
    public String direct2(){
        amqpTemplate.convertAndSend("exchange-1-direct", "routingKey-2-direct", "test message to DIRECT");
        return "DIRECT 2 OK !";
    }

    @GetMapping("/producer2-demo/direct/3")
    public String direct3(){
        amqpTemplate.convertAndSend("exchange-1-direct", "routingKey-3-direct", "test message to DIRECT");
        return "DIRECT 3 OK !";
    }

    @GetMapping("/producer2-demo/fanout/1")
    public String fanout1(){
        amqpTemplate.convertAndSend("exchange-2-fanout", "routingKey-1-fanout", "test message to FANOUT");
        return "FANOUT 1 OK !";
    }

    @GetMapping("/producer2-demo/fanout/2")
    public String fanout2(){
        amqpTemplate.convertAndSend("exchange-2-fanout", "routingKey-2-fanout", "test message to FANOUT");
        return "FANOUT 2 OK !";
    }

    @GetMapping("/producer2-demo/fanout/3")
    public String fanout3(){
        amqpTemplate.convertAndSend("exchange-2-fanout", "routingKey-3-fanout", "test message to FANOUT");
        return "FANOUT 3 OK !";
    }

    @GetMapping("/producer2-demo/topic/1")
    public String topic1(){
        amqpTemplate.convertAndSend("exchange-3-topic", "routingKey-1-topic", "test message to TOPIC");
        return "TOPIC 1 OK !";
    }

    @GetMapping("/producer2-demo/topic/2")
    public String topic2(){
        amqpTemplate.convertAndSend("exchange-3-topic", "routingKey-2.1-topic", "test message to TOPIC");
        return "TOPIC 2 OK !";
    }

    @GetMapping("/producer2-demo/topic/3")
    public String topic3(){
        amqpTemplate.convertAndSend("exchange-3-topic", "routingKey-3-topic", "test message to TOPIC");
        return "TOPIC 3 OK !";
    }
    
}
