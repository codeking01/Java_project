package com.king.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 */

// @SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class MainApplication {
    public static void main(String[] args) {
        // SpringApplication.run(MainApplication.class, args);
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3、从容器中获取组件
        // Pet tom01 = run.getBean("tom", Pet.class);
        // Pet tom02 = run.getBean("tom", Pet.class);
        // System.out.println("组件：" + (tom01 == tom02));
        //
        // User user01 = run.getBean("user01", User.class);
        // Pet tom=run.getBean("tom", Pet.class);
        // System.out.println("用户宠物："+(user01.getPet()==tom));
        //
        // String[] beanNamesForType = run.getBeanNamesForType(User.class);
        // System.out.println("==========");
        // for (String s : beanNamesForType) {
        //     System.out.println(s);
        // }
        // DBHelper bean1 = run.getBean(DBHelper.class);
        // System.out.println(bean1);

    //    @Conditional 的使用
        boolean tom = run.containsBean("tom");
        boolean user01 = run.containsBean("user01");
        System.out.println("容器的tom组件为："+tom);
        System.out.println("容器的user01："+user01);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha："+haha);//true
        System.out.println("hehe："+hehe);//true
    }
}
