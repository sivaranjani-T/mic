package com.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceApplication {
  // microservices using eureka and fleignClient
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
