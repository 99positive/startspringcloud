package com.lqb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/6/19 22:08
 * @Create by lqb
 */
@RestController
public class ProductController {

    @GetMapping("getProduct")
    public String getProduct(){
        return "my product!";
    }

}
