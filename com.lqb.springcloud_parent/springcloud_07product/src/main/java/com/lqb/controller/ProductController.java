package com.lqb.controller;

import com.lqb.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Date 2022/6/19 22:08
 * @Create by lqb
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/test6")
    public Map<String, Object> getTest6(Integer pageNo, Integer pageSize, Integer query) throws InterruptedException {

        Thread.sleep(3000);
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods(100.0, "SS", 10));
        goods.add(new Goods(29.0, "AA", 5));
        goods.add(new Goods(33.5, "BBB", 5));
        goods.add(new Goods(77.0, "EE", 5));
        goods.add(new Goods(69.0, "756", 10));
        goods.add(new Goods(85.0, "BABY", 8));

        Map<String, Object> map = new HashMap<>();
        map.put("total", 88);
        map.put("pageNo", pageNo);
        map.put("goods", goods.stream().filter(x -> x.getType().equals(query)).collect(Collectors.toList()));

        return map;
    }

    @GetMapping("/test5")
    public List<Goods> getTest5(@RequestParam("type") Integer type){
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods(100.0, "SS", 10));
        goods.add(new Goods(29.0, "AA", 8));
        goods.add(new Goods(33.5, "BBB", 6));
        goods.add(new Goods(77.0, "EE", 7));
        goods.add(new Goods(69.0, "756", 10));
        goods.add(new Goods(85.0, "BABY", 8));

        return goods.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @GetMapping("/test4")
    public Goods getTest4(){
        return new Goods(100.0, "SS", 10);
    }

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
