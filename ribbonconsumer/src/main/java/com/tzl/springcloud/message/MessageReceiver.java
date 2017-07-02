package com.tzl.springcloud.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

/**
 * Created by tangzhilong on 17/7/2.
 */
@Component
//@RabbitListener(queues = "hello")
public class MessageReceiver {
    private Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @RabbitHandler
    public void process(String hello) {
        logger.info("I reviced :" + hello);
    }
}
