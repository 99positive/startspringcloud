package com.lqb.controller;

import com.alibaba.fastjson.JSONObject;
import com.lqb.entity.Goods;
import com.lqb.feignclient.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
        Goods back = productClient.test4();
//        String back = productClient.test3(Arrays.asList("aaa", "bbb"));
//        String back = productClient.test2(new String[]{"aaa", "bb"});

//        String product = productClient.getProduct();
//        log.info("category get product : {}", product);
//        String list = productClient.list();
//        log.info("category get list : {}", list);
//        String test = productClient.test("张三", 19);
//        log.info("category get myTest : {}", test);
//        String path = productClient.getPath("张三", 66666);
//        log.info("what! get path : {}", path);
//        String goods = productClient.getGoods(new Goods(99.9, "aa", 88));
//        log.info("goods:{}", goods);

//        return "category:" + port + goods;
        return "category:" + port + back;
    }

    @GetMapping("getObject")
    public String getObject(){
        log.info("object -- run{}", port);
//        List<Goods> goodsList = productClient.test5(10);
        AtomicReference<String> s = new AtomicReference<>("");
//        goodsList.forEach(x -> {
//            s.updateAndGet(v -> v + x);
//        });

        String obj = productClient.test6(1, 5, 5);
        JSONObject jsonObject = JSONObject.parseObject(obj);

        log.info("{}{}", jsonObject.get("total"), jsonObject.get("pageNo"));
        List<Goods> goods = JSONObject.parseArray(jsonObject.get("goods").toString(), Goods.class);
        goods.forEach(x -> {
            log.info("{}", x);
        });
        log.info("!!!");
        return obj;
    }
}
