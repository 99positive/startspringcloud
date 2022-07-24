package com.lqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Date 2022/7/10 23:42
 * @Create by lqb
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer // 配置中心
@ServletComponentScan(basePackages = "com.lqb.filters")
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
