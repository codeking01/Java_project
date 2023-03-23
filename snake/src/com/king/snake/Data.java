package com.king.snake;

import javax.swing.*;
import java.net.URL;

/**
 * @author codeking
 * @date 2022/4/24 17:25
 */
//存放外部数据
public class Data {
    //获取头部资源   url:定位图片地址
    public static URL headerurl = Data.class.getResource("/statics/header.png");
    public static ImageIcon header = new ImageIcon(headerurl);
    //头部：上下左右
    public static URL upUrl = Data.class.getResource("/statics/up.png");
    public static URL downUrl = Data.class.getResource("/statics/down.png");
    public static URL leftUrl = Data.class.getResource("/statics/left.png");
    public static URL rightUrl = Data.class.getResource("/statics/right.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    //身体
    public static URL bodyUrl = Data.class.getResource("/statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);
    //食物
    public static URL foodUrl = Data.class.getResource("/statics/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);
}
