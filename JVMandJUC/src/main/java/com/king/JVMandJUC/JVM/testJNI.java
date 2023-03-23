package com.king.JVMandJUC.JVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testJNI {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cmd = "python C:\\Users\\king\\Desktop\\test.py";
        Process exec = Runtime.getRuntime().exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        String result = null;
        String line;
        while ((line = in.readLine()) != null) {
            result = line;
            System.out.println("creating: " + result);
        }

        in.close();
        exec.waitFor();
    }
}
