package com.tss.webapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplications {

    @Autowired
    @Qualifier("applicationName")
    private String applicatoinName;

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world - " + applicatoinName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplications.class, args);
    }
}
