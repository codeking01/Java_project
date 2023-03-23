package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SSMPApplication {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(args));
        //String[] arg = new String[1];
        //arg[0] ="--server.port=8888";
        // 如果去掉args 那就i没法测试传参数 比如端口
        SpringApplication.run(SSMPApplication.class, args);
    }

}
