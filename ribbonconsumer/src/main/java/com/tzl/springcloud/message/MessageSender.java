package com.tzl.springcloud.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tangzhilong on 17/7/2.
 */
@Component
public class MessageSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String sendSomething) {
        String message = "hello,rabbitmq." + sendSomething;
        this.rabbitTemplate.convertAndSend("hello",message);
    }
}
