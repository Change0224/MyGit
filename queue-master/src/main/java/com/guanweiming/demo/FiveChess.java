package com.guanweiming.demo;

import com.guanweiming.demo.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class FiveChess extends BaseJFrame {
    private final BaseCore first = new FirstCore();
    private final BaseCore second = new SecondCore();
    private final BaseCore third = new ThirdCore();
    /**
     * 棋子数组
     */



    private int[][] allChess = new int[30][6];
    private int[][] allChess2 = new int[30][6];
    private int[][] allChess3 = new int[30][6];

    private static final int  mwidth=25;

    private FiveChess() {
        this.setTitle("计算");
        this.setSize(1000, 600);
        this.setLocation((width - 1000) / 2, (height - 600) / 2);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.repaint();
        this.addMouseListener(this);
    }

    private void drawTable(final Graphics g2,int x,int y,int startX,int startY){
        int length=mwidth*x;
        int height= mwidth*y;
        //绘制横线
        for (int i = 0; i <= y; i++) {
            g2.setColor(Color.black);
            g2.drawLine(startX, i * mwidth + startY, length + startX, startY + i * mwidth);
        }
        //绘制竖线
        for (int i = 0; i <= x; i++) {
            g2.setColor(Color.black);
            g2.drawLine(i * mwidth + startX, startY, startX + i * mwidth, height + startY);
        }
    }

    private void drawCircle(final Graphics g2,int x,int y,int startX,int startY,int[][] allChess){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // 黑子
                //红子
                if (allChess[i][j] == 1) {
                    int tempX = i * mwidth + 55;
                    int tempY = j * mwidth + startY+12;
                    g2.setColor(Color.red);
                    g2.fillOval(tempX - 8, tempY - 8, 16, 16);
                }
                // 白子
                //蓝子
                else if (allChess[i][j] == 2) {
                    int tempX = i * mwidth + 55;
                    int tempY = j * mwidth + startY+12;
                    g2.setColor(Color.blue);
                    g2.fillOval(tempX - 8, tempY - 8, 16, 16);

                }

            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // 双缓冲
        BufferedImage bi = new BufferedImage(1000, 600,
                BufferedImage.TYPE_INT_RGB);

        Graphics g2 = bi.createGraphics();
        g2.setColor(new Color(199, 237, 204));
        g2.fillRect(0, 0, 1000, 600);

        drawTable(g2,30,6,43,60);
        drawTable(g2,30,6,43,270);
        drawTable(g2,30,3,43,480);

        drawCircle(g2,30,6,43,60,allChess);
        drawCircle(g2,30,6,43,270,allChess2);
        drawCircle(g2,30,3,43,480,allChess3);



        g2.setColor(Color.red);
        g2.fillOval(850, 70, 100, 100);
        g2.setColor(Color.yellow);
        g2.fillOval(850, 220, 100, 100);
        g2.setColor(Color.blue);
        g2.fillOval(850, 370, 100, 100);
        g.drawImage(bi, 0, 0, this);

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getY() >= 70 && e.getY() <= 170 && e.getX() >= 850 && e.getX() <= 950) {
            System.out.println("紅色按鈕");
            first.red();
            second.red();
            third.red();

        }
        if (e.getY() >= 220 && e.getY() <= 320 && e.getX() >= 850 && e.getX() <= 950) {
            System.out.println("黃色按鈕");
            first.undo();
            second.undo();
            third.undo();
        }
        if (e.getY() >= 370 && e.getY() <= 470 && e.getX() >= 850 && e.getX() <= 950) {
            System.out.println("藍色按鈕");
            first.blue();
            second.blue();
            third.blue();
        }
        ICore.StatusEnum[][] firstResult = first.getStatusEnum();
        ICore.StatusEnum[][] secondResult = second.getStatusEnum();
        ICore.StatusEnum[][] thirdResult = third.getStatusEnum();
        for (int i = 0; i < firstResult.length; i++) {
            for (int i1 = 0; i1 < firstResult[i].length; i1++) {
                allChess[i1][i] = firstResult[i][i1] == null ? 0 : firstResult[i][i1].getCode();
            }
        }
        for (int i = 0; i < secondResult.length; i++) {
            for (int i1 = 0; i1 < secondResult[i].length; i1++) {
                allChess2[i1][i] = secondResult[i][i1] == null ? 0 : secondResult[i][i1].getCode();
            }
        }
        for (int i = 0; i < thirdResult.length; i++) {
            for (int i1 = 0; i1 < thirdResult[i].length; i1++) {
                allChess3[i1][i] = thirdResult[i][i1] == null ? 0 : thirdResult[i][i1].getCode();
            }
        }
        this.repaint();
    }
    public static void main(String[] args) {
        new FiveChess();
    }
}
