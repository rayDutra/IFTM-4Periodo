package com.iftm.startexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.iftm.startexample.repositories")
@EnableFeignClients
public class StartExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartExampleApplication.class, args);
    }
}
