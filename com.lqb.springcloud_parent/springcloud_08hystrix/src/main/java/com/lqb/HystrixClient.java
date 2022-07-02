package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2022/7/2 15:21
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //开启Hystrix服务熔断
public class HystrixClient {
    public static void main(String[] args) {
        SpringApplication.run(HystrixClient.class, args);
    }
}
