package com.kh.eat_game.container.view;

import com.kh.eat_game.container.model.vo.Food;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MainFrame extends JFrame {
    GamePanel panel;
    GameThread thread;

    public MainFrame() {
        setTitle("Get Point!!");

        // 사이즈 설정 이후에 setLocationRelativeTo() 메소드 이용하면 화면 정중앙에 생성
        setSize(700, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new GamePanel();
        this.add(panel, BorderLayout.CENTER);

    }

}




