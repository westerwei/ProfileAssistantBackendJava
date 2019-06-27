package com.ibm.gbs.asset.profileassistant.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
Created by Wester
 */
@RestController
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class Example {

    @Autowired
    ExampleDAO dao;

    @RequestMapping("/")
    String home(){
        dao.testConnection();
        return "Hello World from Spring Boot Example!!!";

    }

    public static void main(String[] args){
        SpringApplication.run(Example.class, args);
    }
}
