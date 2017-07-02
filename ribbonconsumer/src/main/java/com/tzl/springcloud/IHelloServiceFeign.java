package com.tzl.springcloud;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangzhilong on 17/6/30.
 */
//@FeignClient("helloservice")
public interface IHelloServiceFeign {
    @RequestMapping("/")
    String hello();
}
