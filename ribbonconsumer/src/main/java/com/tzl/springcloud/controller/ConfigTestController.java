package com.tzl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhilong on 17/7/2.
 */
@RefreshScope
@RestController
public class ConfigTestController {
    @Value("${from}")
    private String from;
    @RequestMapping("/from")
    public String getFrom() {
        return from;
    }
}
