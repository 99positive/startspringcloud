package com.lqb.controller;

import com.lqb.feignclient.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/6/26 23:38
 * @Create by lqb
 */
@RestController
@Slf4j
public class CategoryController {
    @Value("${server.port}")
    private int port;

    @Autowired
    private ProductClient productClient;

    @GetMapping("getCategory")
    public String getCategory(){
        log.info("category -- run:{}", port);

        String product = productClient.getProduct();

        log.info("category get product : {}", product);

        return "my category!" + port;
    }
}
