package com.king.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author codeking
 * @date 2022/4/24 17:17
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int length;//蛇的长度
    int[] snakeX = new int[600];//蛇的X坐标
    int[] snakeY = new int[500];//蛇的Y坐标
    String direction;
    //游戏是否开始
    boolean isStart = false;

    //控制时间的执行帧
    Timer timer = new Timer(300,this);//定时器

    //1.定义一个食物
    int foodx;
    int foody;
    Random random=new Random();

    //死亡判断
    boolean isFail=false;
    
    //积分系统
    int score;


    //构造器
    public GamePanel() {
        init();
        //获取键盘的监听事件
        //获取键盘的焦点
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();//让时间动起来
    }

    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;//头部坐标
        snakeX[1] = 75;
        snakeY[1] = 100;//第一个身体坐标
        snakeX[2] = 50;
        snakeY[2] = 100;//第二个身体坐标
        direction = "R";

        //随机产生一个食物 需要在边界内
        foodx=25+25*random.nextInt(34);
        foody=75+25*random.nextInt(24);

        score=0;
    }

    //画板
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.white);//设置背景颜色
        //绘制头部的广告栏
        Data.header.paintIcon(this, g, 25, 3);
        //绘制游戏区域
        g.fillRect(18, 75, 850, 600);

        //画一条静态的蛇
        if (direction.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        //画积分
        g.setColor(Color.white);//设置画笔颜色
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度:"+length, 750, 35);
        g.drawString("分数:"+score, 750, 55);

        //画食物
        Data.food.paintIcon(this,g,foodx,foody);

        //Data.body.paintIcon(this,g,snakeX[1], snakeY[1]);
        //Data.body.paintIcon(this,g,snakeX[2], snakeY[2]);
        //画身体
        for (int i = 1; i < length; i++) {
                Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        //失败提醒
        if(isFail){
            //画一个文字
            g.setColor(Color.red);//设置画笔颜色
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏失败，按下空格重新开始！", 200, 300);
        }

        //提示游戏是否开始
        if (isStart == false) {
            //  给出提示
            g.setColor(Color.white);//设置画笔颜色
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //    键盘按下，弹起敲击
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //    键盘按下，未释放
        //获取按下的键盘是哪个键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if(isFail){
                isFail=false;
                init();
            }
            else{
                //按下空格 改变游戏状态
                isStart = !isStart;
            }
            //刷新界面
            repaint();
        }
        //键盘控制走向
        if(keyCode==KeyEvent.VK_LEFT){
            direction="L";
        }else if(keyCode==KeyEvent.VK_RIGHT){
            direction="R";
        }else if(keyCode==KeyEvent.VK_DOWN){
            direction="D";
        }else if(keyCode==KeyEvent.VK_UP){
            direction="U";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //释放某个键位
    }

    //执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始阶段,并且游戏没有失败
        if(isStart && isFail==false){
            //右移
            for (int i = length-1; i >0; i--) {//除了脑袋，身体都往前移动
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //通过控制方向让头部移动
            if(direction.equals("R")){
                snakeX[0]=snakeX[0]+25;//头部移动
                //判断边界
                if (snakeX[0]>850){
                    snakeX[0]=25;
                }
            }else if(direction.equals("L")){
                snakeX[0]=snakeX[0]-25;//头部移动
                //判断边界
                if (snakeX[0]<25){
                    snakeX[0]=850;
                }
            }else if(direction.equals("U")){
                snakeY[0]=snakeY[0]-25;//头部移动
                //判断边界
                if (snakeY[0]<75){
                    snakeY[0]=650;
                }
            }else if(direction.equals("D")){
                snakeY[0]=snakeY[0]+25;//头部移动
                //判断边界
                if (snakeY[0]>650){
                    snakeY[0]=75;
                }
            }
            //如果脑袋和食物重合了，那么增加长度
            if(snakeX[0]==foodx && snakeY[0]==foody){
                length++;
                // 修改（0,0）坐标的闪动BUG
                snakeX[length-1] =snakeX[length-2] ;
                snakeY[length-1] = snakeY[length-2];

                score+=5;

                //重新生成食物
                foodx=25+25*random.nextInt(34);
                foody=75+25*random.nextInt(24);
            }
            //结束判断
            for (int i = 1; i < length; i++) {
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    //isFail=false;  //外挂模式
                    isFail=true;//游戏失败
                }
            }
            //刷新界面
            repaint();
        }
        timer.start();//让时间动起来
    }
}
