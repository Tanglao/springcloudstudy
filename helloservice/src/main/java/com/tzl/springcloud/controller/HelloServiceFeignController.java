package com.tzl.springcloud.controller;

import api.IHelloServiceApi;
import bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Random;

/**
 * Created by tangzhilong on 17/7/1.
 */
@RestController
public class HelloServiceFeignController implements IHelloServiceApi {
    private static Logger logger = LoggerFactory.getLogger(HelloServiceFeignController.class);
    @Override
    public String hello() {
        Random r =new Random();

        try {
            int ri=r.nextInt(5);
            logger.info("random:"+ri);
            Thread.sleep(500*ri);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Who call me ?");
        return "Hello everybody!";
    }

    @Override
    public String sayHelloTo(String uname) {
        return "hello,"+uname ;
    }

    @Override
    public User getInfo(String uid) {
        return new User("1","tzl");
    }

    @Override
    public String getInfo(User user) {
        return MessageFormat.format("user info : id:{0},name:{1}",user.getUid(),user.getUname());
    }
}
