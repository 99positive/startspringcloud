package com.lqb.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Date 2022/7/10 23:00
 * @Create by lqb
 */
@Configuration
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 类似于 doFilter
     * @param exchange 交换 封装了request response
     * @param chain 过滤链
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("经过全局Filter.....");
        // 放行filter
        Mono<Void> filter = chain.filter(exchange);
        System.out.println("响应回来再处理Filter.....");
        return filter;
    }

    /**
     * 排序
     * @return 用来指定执行顺序，默认按照自然数排序， -1在所有filter执行之前执行
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
