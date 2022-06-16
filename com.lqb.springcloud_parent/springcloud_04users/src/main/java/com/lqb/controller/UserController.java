package com.lqb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date 2022/6/15 12:34
 * @Create by lqb
 */
@RestController
@RequestMapping
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")
    public String userData() {
        log.info("user data");

        //1. 调用order的方法
//        RestTemplate restTemplate = new RestTemplate();
//        String orderResult = restTemplate.getForObject("http://localhost:8084/order", String.class);
//        log.info("调用订单服务成功：{}", orderResult);

        //2. 使用ribbon组件 + RestTemplate实现负载均衡调用1.DiscoveryClient 2.LoadBalanceClient @LoadBalance
//        List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");
//        orders.forEach(x -> {
//            log.info("服务主机：{}，服务端口：{}，服务地址：{}", x.getHost(), x.getPort(), x.getUri());
//        });
//
//        String forObject = new RestTemplate().getForObject(orders.get(0).getUri() + "/order", String.class);
//        log.info("订单服务：{}", forObject);
        //3. 使用ribbon组件 + RestTemplate实现负载均衡调用.LoadBalanceClient
        ServiceInstance orders = loadBalancerClient.choose("ORDERS");
//        String forObject = restTemplate.getForObject(orders.getUri() + "/order", String.class);
//        log.info("订单服务：{}", forObject);

        //4.使用@LoadBalance注解 作用：可以让对象具有ribbon负载均衡
        String forObject = restTemplate.getForObject("http://ORDERS/order", String.class);

        return "user data " + forObject;
    }


}
