package com.user.service.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger =  LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("api/users/simple-api")
    @Retry(name = "sample-api",fallbackMethod = "getError")
    public String get(){
        logger.info("Retry");
        return restTemplate.getForObject("http://localhost:8080/api/users/message",String.class);
    }

    public String getError(Exception e){
        return "User Service is down now";
    }
}
