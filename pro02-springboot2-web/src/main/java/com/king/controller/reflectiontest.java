package com.king.controller;

import com.king.bean.Pet;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author codeking
 * @date 2022/4/12 15:34
 */
public class reflectiontest {
    //正常方式
    public static void test01() {
        Pet car1 = new Pet();
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            car1.getName();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("时间："+(endtime-starttime)+"ms");
    }
    //利用反射
    @SneakyThrows
    public static void test02() {
        Pet car1 = new Pet();
        Class c1 = car1.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(car1,null);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("时间："+(endtime-starttime)+"ms");
    }

    //利用反射 并且关闭检测
    @SneakyThrows
    public static void test03() {
        Pet car1 = new Pet();
        Class c1 = car1.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        //关闭检测
        getName.setAccessible(true);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(car1,null);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("时间："+(endtime-starttime)+"ms");
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }
}
