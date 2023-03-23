package com.king.JVMandJUC.JVM;

/**
 * @Author：codeking
 * @name：Memory
 * @Date：2023/3/22 20:08
 */
public class Memory {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory(); // 字节单位 1MB=1024KB 1KB=1024Byte 1Byte=8bit
        System.out.println("maxMemory = " + (double)(maxMemory>>20));
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + (double)(totalMemory>>20));
    }
}
