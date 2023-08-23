package com.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;
    @Value("${message:}")
    private String message;

    @Value("${server.port}")
    private int port;

    @RequestMapping("api/orders/message")
    public String display(){
        System.out.println(environment.getProperty("server.port"));
        return "Hey!. It's Order Microservice, With port: "+port;
    }

    @GetMapping("api/orders/getMsgFromMS1")
    public String getMsgFromMS1(){
        return restTemplate.getForObject("http://localhost:8080/api/users/messageToMS2",String.class);
    }

    @GetMapping("/message")
    public String getMessageFromGit(){
        return this.message;
    }

}
