package com.king.boot.config;

import com.king.boot.bean.Pet;
import com.king.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//true 默认是单实例
@Configuration(proxyBeanMethods = true)
public class MyConfig {
    /**
     * true 模式下默认是获取单实例对象
     * @return
     */
    @Bean("codeking")
    public User User01(){
        return new User("zhangsan",18);
    }
    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
