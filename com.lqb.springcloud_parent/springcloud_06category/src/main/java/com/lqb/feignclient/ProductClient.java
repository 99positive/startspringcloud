package com.lqb.feignclient;

import com.lqb.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调用商品服务的接口
 * @Date 2022/6/26 23:59
 * @Create by lqb
 */
@FeignClient("PRODUCT")
public interface ProductClient {

    @GetMapping("/test3")
    String test3(@RequestParam("ids") List<String> ids);

    @GetMapping("/test2")
    String test2(@RequestParam("ids") String[] ids);

    /**
     * 调用商品服务
     * @return 商品服务情况
     */
    @GetMapping("/getProduct")
    String getProduct();

    @GetMapping("/list")
    String list();

    @GetMapping("/test")
    String test(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @GetMapping("/path/{name}/{id}")
    String getPath(@PathVariable("name") String name, @PathVariable("id") Integer id);

    @PostMapping("testObject")
    String getGoods(@RequestBody Goods goods);
}
