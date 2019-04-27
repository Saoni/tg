package com.example.config;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
     
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
        System.out.println("MongoDB connection established");
    }
}