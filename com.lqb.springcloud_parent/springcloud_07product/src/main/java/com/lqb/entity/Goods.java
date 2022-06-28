package com.lqb.entity;

import lombok.*;

/**
 * @Date 2022/6/27 23:58
 * @Create by lqb
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    public Double price;

    public String name;

    public Integer type;
}
