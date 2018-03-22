package com.example.helloproducer;

import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    public String getMessage() {
        return "Hello from here!";
    }
}
