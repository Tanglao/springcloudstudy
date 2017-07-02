package com.tzl.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tangzhilong on 17/6/24.
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hello() {
        return restTemplate.getForEntity("http://HELLOSERVICE/",String.class).getBody();
    }
    public String fallback() {
        return "helloservice error!";
    }
}
