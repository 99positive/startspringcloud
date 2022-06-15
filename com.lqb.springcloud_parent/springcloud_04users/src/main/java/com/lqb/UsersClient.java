package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2022/6/15 12:28
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UsersClient {
    public static void main(String[] args) {
        SpringApplication.run(UsersClient.class, args);
    }
}
