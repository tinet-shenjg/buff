package com.shenjg.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.shenjg.admin.mapper")
public class AdminApplication{

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
