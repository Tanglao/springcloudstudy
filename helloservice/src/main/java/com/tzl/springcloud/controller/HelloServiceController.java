package com.tzl.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * Created by tangzhilong on 17/6/24.
 */
@RestController
public class HelloServiceController {

    @Autowired
    private DiscoveryClient client;
    private static Logger logger = LoggerFactory.getLogger(HelloServiceController.class);

    @Autowired
    Registration registration;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String sayhello(){
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

    @RequestMapping("/i")
    public String serviceInfo(){
        List<ServiceInstance> instanceList = client.getInstances(registration.getServiceId());
        String seviceId= registration.getServiceId();
        if(instanceList.size()>0) {
            return "Get service,host:" + instanceList.get(0).getHost() + ",service name:" + instanceList.get(0).getServiceId();
        }else {
            return "nothing!";
        }
    }
}
