package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ComponentScan("com.customer")
@EnableEurekaClient
public class CustomerApplication {
    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);
    }
}