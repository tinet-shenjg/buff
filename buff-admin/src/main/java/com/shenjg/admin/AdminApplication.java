package com.shenjg.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.shenjg")
@EnableFeignClients("com.shenjg")
public class AdminApplication{

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
