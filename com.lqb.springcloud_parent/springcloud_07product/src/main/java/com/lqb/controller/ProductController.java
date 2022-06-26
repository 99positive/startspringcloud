package com.lqb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/6/19 22:08
 * @Create by lqb
 */
@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("getProduct")
    public String getProduct(){
        log.info("product -- run:{}", port);
        return "my product!" + port;
    }


}
