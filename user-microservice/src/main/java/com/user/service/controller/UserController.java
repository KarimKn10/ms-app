package com.user.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    Environment environment;
    @Value("${message:}")
    private String message;
    @Value("${server.port}")
    private int port;

    @RequestMapping("api/users/message")
    public String displayMessage(){
        System.out.println(environment.getProperty("local.server.port"));
        return "Hey!, It's User Microservice. with port: "+port;
    }

    @RequestMapping("api/users/messageToMS2")
    public String sendMessageToMS2(){
        return "This Message form User Microservice";
    }

    @GetMapping("/message")
    public String getMessageFromGit(){
        return this.message;
    }
}
