package com.roadrunner.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class GatewayServerApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApp.class, args);
    }

}
