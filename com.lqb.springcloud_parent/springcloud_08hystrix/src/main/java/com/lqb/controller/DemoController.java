package com.lqb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/7/2 15:39
 * @Create by lqb
 */
@RestController
@Slf4j
public class DemoController {

    @GetMapping("getDemo")
    @HystrixCommand(fallbackMethod = "demoFallBack", defaultFallback = "defaultFallback") //熔断之后的处理
    public String demo(Integer id) {

        log.info("demo test!");
        if (id < 10){
            throw new RuntimeException("id 小于 10：" + id);
        }

        return "demo test!";
    }

    @GetMapping("getDemo2")
    @HystrixCommand(defaultFallback = "defaultFallback") //熔断之后的处理
    public String demo2(Integer id) {

        log.info("demo test!");
        if (id < 10){
            throw new RuntimeException("id 小于 10：" + id);
        }

        return "demo test!";
    }

    public String demoFallBack(Integer id) {
        return "服务已经熔断~！" + id;
    }

    public String defaultFallback() {
        return "默认的熔断方法！！！";
    }
}
