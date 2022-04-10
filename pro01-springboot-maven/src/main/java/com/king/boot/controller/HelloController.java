package com.king.boot.controller;

import com.king.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
// @ResponseBody
// @Controller
@RestController
public class HelloController {
    @Autowired
    Car car;
    @RequestMapping("/car")
    public  Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){
        log.info("Hello,这个是日志");
        return "Hello SpringBoot";
    }
}
