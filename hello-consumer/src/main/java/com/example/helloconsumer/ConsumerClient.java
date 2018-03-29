package com.example.helloconsumer;

import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerClient {

    private static Logger log = LoggerFactory.getLogger(HelloConsumerApplication.class);

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ConsumerProxyService consumerProxyService;

    @Value("${consumer.message:Hello default}")
    private String consumerMessage;

    /**
     * This is a normal method which returns a message
     * @return message
     */
    @RequestMapping(value = "/message")
    public String getMessage() {
        return consumerService.getMessage();
    }

    /**
     * This method retrieves message using feign client's proxy
     * @return message
     */
    @RequestMapping(value = "/messageProxy")
    public String getMessageProxy() {
        log.info("Message Proxy");
        return consumerProxyService.getMessage();
    }

    /**
     * This method reads message from property file and returns it
     * @return message
     */
    @RequestMapping(value = "/propertyFileMessage")
    public String getMessageFromPropertyFile() {
        return this.consumerMessage;
    }
}
