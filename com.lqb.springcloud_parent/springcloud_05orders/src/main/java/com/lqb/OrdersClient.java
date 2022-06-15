package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2022/6/15 12:27
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrdersClient {

    public static void main(String[] args) {
        SpringApplication.run(OrdersClient.class, args);
    }
}
