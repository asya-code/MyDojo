package com.mydojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication

public class MyDojoApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                MyDojoApplication.class, args);
    }
}
