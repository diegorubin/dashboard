package com.diegorubin.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.diegorubin.datacenter"})
@ComponentScan(basePackages = {"com.diegorubin.datacenter"})
public class DatacenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatacenterApplication.class, args);
    }
}

