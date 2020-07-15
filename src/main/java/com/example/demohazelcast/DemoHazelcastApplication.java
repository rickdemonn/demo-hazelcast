package com.example.demohazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoHazelcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHazelcastApplication.class, args);
    }

}
