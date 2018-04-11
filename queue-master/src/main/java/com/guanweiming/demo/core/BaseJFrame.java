package com.guanweiming.demo.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author chezhu.xin
 */
public abstract class BaseJFrame extends JFrame implements MouseListener {
    /**
     * 屏幕宽度
     */
    protected int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    /**
     * 屏幕高度
     */
    protected int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
