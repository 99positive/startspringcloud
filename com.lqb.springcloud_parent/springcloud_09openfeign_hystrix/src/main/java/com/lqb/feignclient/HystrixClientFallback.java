package com.lqb.feignclient;

import org.springframework.stereotype.Component;

/**
 * @Date 2022/7/2 16:33
 * @Create by lqb
 */
@Component
public class HystrixClientFallback implements HystrixClient {

    @Override
    public String demo(Integer id) {
        return "当前服务不可用，请稍后再试！" + id;
    }
}
