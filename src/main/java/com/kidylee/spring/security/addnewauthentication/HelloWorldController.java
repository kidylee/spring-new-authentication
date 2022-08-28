package com.kidylee.spring.security.addnewauthentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloWorldController {

    @GetMapping
    public String get() {

        return "Hello world!";
    }
}
