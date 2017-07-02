package com.tzl.springcloud.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by tangzhilong on 17/7/2.
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
    private Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("I received that:" + payload);
    }
}
