package com.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("api/orders/message")
    public String display(){
        return "Hey!. It's Order Microservice";
    }

    @GetMapping("api/orders/getMsgFromMS1")
    public String getMsgFromMS1(){
        return restTemplate.getForObject("http://localhost:9091/api/users/messageToMS2",String.class);
    }

}
