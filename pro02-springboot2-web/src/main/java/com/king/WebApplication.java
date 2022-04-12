package com.king;

import com.king.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(WebApplication.class, args);
        IndexController bean = ctx.getBean(IndexController.class);
        // System.out.println("IndexController--------->"+bean);
    }

}
