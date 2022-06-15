package com.lqb.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("user")
    public String userData() {
        log.info("user data");

        //调用order的方法
        RestTemplate restTemplate = new RestTemplate();
        String orderResult = restTemplate.getForObject("http://localhost:8084/order", String.class);
        log.info("调用订单服务成功：{}", orderResult);

        return "user data :" + orderResult;
    }
}
