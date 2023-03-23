package com.king.JVMandJUC.JVM;

import java.util.Random;

/**
 * @Author：codeking
 * @name：OOMtest
 * @Date：2023/3/22 20:36
 */
public class OOMtest {
    public static void main(String[] args) {
        String a="22";
        String codeking = "codeking";
        while (true) {
            codeking += codeking + new Random().nextInt(88_888_888) + new Random().nextInt(999999999);
        }
    }
}
