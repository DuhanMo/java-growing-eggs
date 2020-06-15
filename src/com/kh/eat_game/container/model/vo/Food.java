package com.kh.eat_game.container.model.vo;

import java.awt.Image;

import java.util.Random;



public class Food {

     Image img; //이미지 참조변수
     int x, y; //이미지 중심 좌표
     int w, h; //이미지 절반폭, 절반높이
     int dy; //적군의 변화량
     int width, height; //화면(panel)의 사이즈
    //본인 객체가 음식을 먹거나 음식이 화면밖에 나가거나의 여부
     boolean isDead = false;

    public Food(Image imgFood, int width, int height) {
        this.width = width;
        this.height = height;

        //멤버변수 값 초기화
        img = imgFood.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        w = 32; //이미지 절반넓이
        h = 32;
        Random rnd = new Random();
        // 음식들이 화면 너비 골고루 젠이됨
        x = rnd.nextInt(width - w * 2) + w; //w ~ width - w
        // 화면 밖에서부터 떨어지는것처럼 보이게끔
        y = -h;
        dy = rnd.nextInt(15) + 1;//떨어지는 속도 랜덤설정
    }

    public void move() { // Food의 움직이는 기능 메소드
        y += dy;
        //만약 화면 밑으로 나가버리거나 먹히면 객체 없애기
        if( y > height + h ) { //ArrayList에서 제거
            isDead = true; //죽음 표식!

        }

    }

    public Image getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getDy() {
        return dy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}