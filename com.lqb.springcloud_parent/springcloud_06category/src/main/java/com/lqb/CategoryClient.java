package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2022/6/26 23:36
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CategoryClient {

    public static void main(String[] args) {
        SpringApplication.run(CategoryClient.class, args);
    }
}
