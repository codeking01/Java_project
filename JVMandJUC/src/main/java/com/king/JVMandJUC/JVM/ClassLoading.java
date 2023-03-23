package com.king.JVMandJUC.JVM;

public class ClassLoading {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        new Thread().start();
        // 打印hashcode
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        System.out.println("****************");
        // 查看 class和ClassLoader
        System.out.println(car1.getClass());
        System.out.println(car2.getClass());
        System.out.println(car3.getClass());
        // 查看类加载器 同一个类的都一样
        System.out.println("***************");
        System.out.println(car1.getClass().getClassLoader());
        System.out.println(car2.getClass().getClassLoader());
        System.out.println(car3.getClass().getClassLoader());
        // 双亲委派机制，向上委派，向下加载 bootstrap--> extClassLoader-->AppClassLoader
    }
    // 带上
    private native void start0();
}

class Car {
    public Car() {
    }

}