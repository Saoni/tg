package com.example.config;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.service","com.example.dto","com.example.models","com.example.repositories"})
@EnableMongoRepositories("com.example.repositories")
public class AppConfig {
 public static void main(String[] args) {
  SpringApplication.run(AppConfig.class, args);
  System.out.println("Application started");
 }
}