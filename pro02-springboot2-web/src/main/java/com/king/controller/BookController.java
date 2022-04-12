package com.king.controller;

import com.king.bean.testdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author codeking
 * @date 2022/4/11 22:49
 */
@RestController
@RequestMapping("Books")
public class BookController {
    //读取yml的内容
    // @Value("${server.port}")
    // private String server1;

    //把所有的配置文件的数据读取封装成对象 properties和yml等等
    @Autowired
    private Environment env;

    @Autowired
    private testdata mydatasouce;

    @GetMapping
    public String getname() {
        // System.out.println("server1----" + server1);
        System.out.println("5: "+ mydatasouce.getName());
        System.out.println("1: "+ mydatasouce.getAge());
        System.out.println("2: "+ mydatasouce.getTel());
        System.out.println("3: "+ Arrays.toString(mydatasouce.getSubject()));
        System.out.println("spring.mvc.hiddenmethod.filter.enabled: "+ env.getProperty("spring.mvc.hiddenmethod.filter.enabled"));
        return "ok";
    }


}
