package com.lqb.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用商品服务的接口
 * @Date 2022/6/26 23:59
 * @Create by lqb
 */
@FeignClient("PRODUCT")
public interface ProductClient {
    /**
     * 调用商品服务
     * @return 商品服务情况
     */
    @GetMapping("/getProduct")
    String getProduct();
}
