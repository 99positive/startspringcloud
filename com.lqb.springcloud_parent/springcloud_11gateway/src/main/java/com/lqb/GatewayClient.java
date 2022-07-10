package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2022/7/3 21:49
 * @Create by lqb
 */
@SpringBootApplication
//@EnableDiscoveryClient
public class GatewayClient {

    public static void main(String[] args) {
        SpringApplication.run(GatewayClient.class, args);
    }
}
