package com.lqb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/6/15 12:35
 * @Create by lqb
 */
@RestController
@RequestMapping
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("order")
    public String myOrder(){
        log.info("my order");
        return "finish query order port:" + port;
    }
}
