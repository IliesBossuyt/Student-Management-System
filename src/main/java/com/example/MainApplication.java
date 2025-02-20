package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Active Spring Boot
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);  // Démarre l'application
    }
}
