package com.xt37.userservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.xt37.userservice.mapper")
@ComponentScan(basePackages = {"com.xt37"})
public class UserSerivceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSerivceApplication.class, args);
    }

}
