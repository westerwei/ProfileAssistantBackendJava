package com.ibm.gbs.asset.profileassistant.test;

import com.ibm.gbs.asset.profileassistant.test.aop.LogExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/*
Created by Wester
 */
@RestController
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class Example {

    private Logger logger = LoggerFactory.getLogger(Example.class);

    @Autowired
    ExampleDAO dao;

    @LogExecution
    @RequestMapping("/test/db/connect")
    public String home() {
        dao.testConnection();
        return "Hello World from Spring Boot Example!!!";

    }

    @LogExecution
    @RequestMapping(value = "/test/{dept}/employee", method = GET, produces = "application/json")
    public List<Employee> getDeptEmployees(@PathVariable String dept) {
        return this.dao.getDeptEmployee(dept);

    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
