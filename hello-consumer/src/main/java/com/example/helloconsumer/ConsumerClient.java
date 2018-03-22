package com.example.helloconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerClient {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/message")
    public String getMessage() {
        return consumerService.getMessage();
    }
}
