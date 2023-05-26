package com.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.provider.mapper")
public class FlayDemoProvider {
    public static void main(String[] args) {
        SpringApplication.run(FlayDemoProvider.class,args);
    }
}