package com.kh.eat_game.container.view;

import com.kh.eat_game.container.model.vo.Food;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
//    JButton sBtn;

    Image imgBack, imgPlayer, imgFood;  // 화면 위 이미지 객체 참조변수
    int width, height; // 패널의 사이즈
    int x, y, w, h;   // x,y 플레이어 중심좌표, w,h 이미지 절반 폭
    int dx = 0; // 플레이어 이미지의 이동속도, 이동 방향
    ArrayList<Food> food = new ArrayList<Food>(); // 여러개의 포인트(음식) 객체 참조 변수
    int score = 0; // 점수

    public GamePanel() {
//        sBtn = new JButton("S T A R T");
//        sBtn.setPreferredSize(new Dimension(300, 100));
//        this.add(sBtn);

        // 이미지를 로드하기 위한 클래스, 객체를 생성하는게 아니라 정적메소드를 제공
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgBack = toolkit.getImage("images/wall.jpg");
        imgPlayer = toolkit.getImage("images/dog.png");
        imgFood = toolkit.getImage("images/meat.png");

    }

    @Override
    protected void paintComponent(Graphics g) { // 스윙 컴포넌트가 자신을 그리는 메소드
        if (width == 0 || height == 0) {
            width = getWidth();
            height = getHeight();
            // 리사이징
            imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imgPlayer = imgPlayer.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
            //플레이어 좌표 계산
            x = width / 2;
            y = height - 100;
            w = 64;
            h = 64;
        }
        g.drawImage(imgBack, 0, 0, this);

        for (Food f : food) {
            g.drawImage(f.getImg(), f.getX() - f.getW(), f.getY() - f.getH(), this);
        }

        g.drawImage(imgPlayer,x - w, y - h, this);
        g.setFont(new Font(null, Font.BOLD, 20));
        g.setColor(Color.white);
        g.drawString("Score : " + score, 10, 20);
    }

    public void move() { // 플레이어 움직이기
        // 음식 떨어지기
        for (int i = food.size() - 1; i > 0; i--) {
            Food f = food.get(i);
            f.move();
            if (f.isDead()) food.remove(i);
        }
        x += dx;
        //플레이어가 화면밖으로 나가지 않게끔
        if (x < w) x = w;
        if (x > width - w) x = width - w;
    }

    public void makeFood() { // 음식 생성 메소드
        if (width == 0 || height == 0) return;
        Random rnd = new Random();// 1/50확률로 음식 생성
        int n = rnd.nextInt(50);
        if (n == 0) {
            food.add(new Food(imgFood, width, height));
        }
    }

   public void checkCollision() { //플레이어와 음식 충돌
        // 음식의 크기를 이용해서 충돌 바운더리를 정해줌
        for (Food f : food) {
            int left = f.getX() - f.getW();

            int right = f.getX() + f.getW();

            int top = f.getY() - f.getH();

            int bottom = f.getY() + f.getH();

            // 플레이어의 중심좌표가 바운더리안에 들어오면 충돌, 음식은 사라지고 점수 획득
            if (x > left && x < right && y > top && y < bottom) {

                f.setDead(true); //충돌했음

                score += 5;

            }

        }
    }

}
