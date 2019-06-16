package com.ibm.gbs.asset.profileassistant.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
Created by Wester
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home(){
        return "Hello World from Spring Boot Example!!!";
    }

    public static void main(String[] args){
        SpringApplication.run(Example.class, args);
    }
}
