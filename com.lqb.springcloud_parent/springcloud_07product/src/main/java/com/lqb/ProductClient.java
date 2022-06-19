package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2022/6/19 22:07
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductClient {
    public static void main(String[] args) {
        SpringApplication.run(ProductClient.class, args);
    }
}
