package com.kh.eat_game.container.view;

import com.kh.eat_game.container.model.vo.Food;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {// 게임화면 그려낼 Panel
    Image imgBack, imgPlayer, imgFood;  // 화면 위 이미지 객체 참조변수
    int width, height; // 패널의 사이즈
    int x, y, w, h;   // x,y 플레이어 중심좌표, w,h 이미지 절반 폭
    int dx = 0, dy = 0; // 플레이어 이미지의 이동속도, 이동 방향
    ArrayList<Food> food = new ArrayList<Food>(); // 여러개의 포인트(음식) 객체 참조 변수
    int score = 0; // 점수

    public GamePanel(){
        // 이미지를 로드하기 위한 클래스, 객체를 생성하는게 아니라 정적메소드를 제공
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgBack = toolkit.getImage("images.wall");
        imgPlayer = toolkit.getImage("images/dog");
        imgFood = toolkit.getImage("image/meat");
    }
    @Override
    public void paintComponent(Graphics g) {

    }
}
