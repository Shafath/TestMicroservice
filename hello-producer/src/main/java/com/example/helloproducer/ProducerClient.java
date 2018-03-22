package com.example.helloproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerClient {

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "/message")
    public String getMessage() {
        return producerService.getMessage();
    }
}
