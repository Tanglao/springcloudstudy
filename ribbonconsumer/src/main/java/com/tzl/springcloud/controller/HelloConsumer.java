package com.tzl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tzl.springcloud.FeignHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhilong on 17/6/24.
 */
@RestController
public class HelloConsumer {

//    @Autowired
//    private HelloService helloService;

//    @Autowired
//    private IHelloServiceFeign helloServiceFeign;

    private Logger logger = LoggerFactory.getLogger(HelloConsumer.class);
    @Autowired
    private FeignHelloService feignHelloService;
    @RequestMapping(value = "/invokehello")
    @HystrixCommand(fallbackMethod = "invokeHelloFail")
    public String hello() {
//        return helloService.hello();
        logger.info("call helloservice hello method");
        return feignHelloService.hello();
    }

    public String invokeHelloFail() {
        return "invokeHelloFail";
    }
}
