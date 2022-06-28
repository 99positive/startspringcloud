package com.lqb.controller;

import com.lqb.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 2022/6/19 22:08
 * @Create by lqb
 */
@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/test3")
    public String getTest3(@RequestParam("ids") List<String> ids){
        for (String id :ids) {
            log.info("id:{}", id);
        }
        return "test3";
    }

    @GetMapping("/test2")
    public String getTest2(@RequestParam("ids") String[] ids){
        for (String id :ids) {
            log.info("id:{}", id);
        }
        return "test2";
    }

    @GetMapping("getProduct")
    public String getProduct(){
        log.info("product -- run:{}", port);
        return "my product!" + port;
    }

    @GetMapping("list")
    public String list() {
        log.info("shopping list: {}", port);
        return "shopping list:" + port;
    }

    //定义一个接受零散类型参数接口 queryString
    @GetMapping("/test")
    public String test(String name, Integer age) {
        log.info("name: {}, age: {}", name, age);
        return "name age：" + name + " - " + age;
    }

    //定义一个接受零散类型参数接口 path
    @GetMapping("/path/{name}/{id}")
    public String getPath(@PathVariable("name") String name, @PathVariable("id")Integer id) {
        log.info("name: {}, id: {}", name, id);
        return "name age：" + name + " - " + id;
    }

    /**
     * 对象参数
     * @return
     */
    @PostMapping("testObject")
    public String getObject(@RequestBody Goods goods) {
        log.info("goods:{}", goods.toString());
        return goods.toString();
    }
}
