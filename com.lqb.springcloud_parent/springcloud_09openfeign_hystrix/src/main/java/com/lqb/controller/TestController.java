package com.lqb.controller;

import com.lqb.feignclient.HystrixClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/7/2 16:17
 * @Create by lqb
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("test")
    public String test(){

        String demo = hystrixClient.demo(88);
        log.info("test ok; {}", demo);

        return "test ok!" + demo;
    }
}
