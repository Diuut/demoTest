package com.diuut.ddt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("commonUtils")
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
