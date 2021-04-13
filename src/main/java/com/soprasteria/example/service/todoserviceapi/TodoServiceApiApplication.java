package com.soprasteria.example.service.todoserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.*;

@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
public class TodoServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApiApplication.class, args);
    }
}
