package com.king.pro02springboot2web.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户
 */
@Data
@ToString
// @AllArgsConstructor //有参
@NoArgsConstructor //无参
public class User {
    private String name;
    private Integer age;

    private Pet pet;
    //有参构造器需要定制，自己写

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}