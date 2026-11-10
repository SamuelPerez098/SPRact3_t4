package com.ejemplo.act1_introduccion_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ejemplo.act1_introduccion_spring_boot")
public class Act1IntroduccionSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Act1IntroduccionSpringBootApplication.class, args);
    }
}