package com.lqb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date 2022/6/15 23:23
 * @Create by lqb
 */
@Configuration //代表这是一个springboot配置类 spring.xml 工厂创建bean id class=""
public class BeansConfig {
    /**
     * 工厂中创建restTemplate
     * @return
     */
    @Bean
    @LoadBalanced()
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
