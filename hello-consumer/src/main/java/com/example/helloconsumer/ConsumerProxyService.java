package com.example.helloconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hello-producer")
public interface ConsumerProxyService {

    @RequestMapping(value = "/message")
    public String getMessage();
}
