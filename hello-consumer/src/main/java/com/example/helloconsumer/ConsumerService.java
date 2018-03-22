package com.example.helloconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "dummyMessage")
    public String getMessage() {
        URI uri = URI.create("http://HELLO-PRODUCER/message");
        URI testUri = URI.create("http://localhost:8082/message");
        return this.restTemplate.getForObject(testUri, String.class);
    }

    public String dummyMessage() {
        return "It's a dummy message";
    }
}
