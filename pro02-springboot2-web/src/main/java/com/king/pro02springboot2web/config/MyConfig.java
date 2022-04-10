package com.king.pro02springboot2web.config;

import com.king.pro02springboot2web.bean.Car;
import com.king.pro02springboot2web.bean.Pet;
import com.king.pro02springboot2web.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *  4.@Import({User.class, DBHelper.class})
 *     给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 */
@Import({User.class})
//true 默认是单实例
@Configuration(proxyBeanMethods = true)
//这个注解随便在哪个配置类上写就行
// @ImportResource("classpath:beans.xml")
// @ConditionalOnBean(name="tom")
@EnableConfigurationProperties(Car.class)
//开启Car的属性配置功能 EnableConfigurationProperties
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
public class MyConfig {
    /**
     * true 模式下默认是获取单实例对象
     * @return
     */

    //注解的顺序很重要，先写的会先执行
    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

    //满足条件才注册下面的这个user01组件
    @ConditionalOnBean(name="tom")
    @Bean
    //用户名就是组件的id
    public User user01(){
        User  zhangsan=new User("zhangsan",18);
        //user组件依赖pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }


}
