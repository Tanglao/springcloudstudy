package com.tzl.springcloud.controller;

import com.tzl.springcloud.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhilong on 17/7/2.
 */
@RestController
public class MessageController {
    @Autowired
    private MessageSender sender;
    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg) {
        sender.send(msg);
        return "ok!";
    }

}
