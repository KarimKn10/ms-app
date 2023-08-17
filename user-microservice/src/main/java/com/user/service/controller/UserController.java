package com.user.service.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("api/users/message")
    public String displayMessage(){
        return "Hey!, It's User Microservice.";
    }

    @RequestMapping("api/users/messageToMS2")
    public String sendMessageToMS2(){
        return "This Message form User Microservice";
    }
}
