package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2022/7/2 16:12
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启feign客户端
public class OpenfeignHystrixClient {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignHystrixClient.class, args);
    }
}
