package com.king.controller;

import lombok.*;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author codeking
 * @date 2022/4/12 16:12
 */
public class ORMtest {
    @SneakyThrows
    public static void main(String[] args) {
        Class<?> c1 = Class.forName("com.king.controller.student2");
        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 获取注解的value的值
        TableKing tableKing = (TableKing) c1.getAnnotation(TableKing.class);
        String value = tableKing.value();
        System.out.println(value);

        // 获取指定注解  获取name下的注解里面的内容
        Field f = c1.getDeclaredField("name");
        Filedking annotation = f.getAnnotation(Filedking.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}


@TableKing(value = "db_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class student2 {
    @Filedking(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Filedking(columnName = "db_age", type = "int", length = 10)
    private int age;
    @Filedking(columnName = "db_name", type = "varchar", length = 5)
    private String name;
}

//创建自定义注解 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)  //运行时级别
@interface TableKing {
    String value();
}

//表的属性的注解 只在属性上生效
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)  //运行时级别
@interface Filedking {
    String columnName();

    String type();

    int length();
}
