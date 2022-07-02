package com.lqb.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date 2022/7/2 16:24
 * @Create by lqb
 */
@FeignClient(value="HYSTRIX", fallback = HystrixClientFallback.class) //fallback 调用服务不可用的时候调用该方法
public interface HystrixClient {

    @GetMapping("demo")
    String demo(@RequestParam("id") Integer id);
}
