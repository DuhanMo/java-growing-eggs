package com.kh.eat_game.container.view;

import com.kh.eat_game.container.model.vo.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
public class MainFrame extends JFrame {
    GamePanel panel;
    GameThread gThread;
    public MainFrame() {
        setTitle("Get Point!!");

        // 사이즈 설정 이후에 setLocationRelativeTo() 메소드 이용하면 화면 정중앙에 생성
        setSize(700, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new GamePanel();
        add(panel, BorderLayout.CENTER);

        setVisible(true);
        gThread = new GameThread();
        gThread.start(); //run() 메소드 자동실행!!
        addKeyListener(new KeyListener() {

            @Override

            public void keyTyped(KeyEvent e) {

            }

            @Override

            public void keyReleased(KeyEvent e) {

                //눌러진 키가 무엇인지 알아내기

                int keyCode = e.getKeyCode();

                switch (keyCode) {

                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:

                        panel.dx = 0; //원랜 getsetter 만들어야함

                        break;


                }

                //방향키 2개 구분

            }

            @Override

            public void keyPressed(KeyEvent e) {

                //눌러진 키가 무엇인지 알아내기

                int keyCode = e.getKeyCode();

                switch (keyCode) {

                    case KeyEvent.VK_LEFT:

                        panel.dx = -8; //원랜 getsetter 만들어야함

                        break;

                    case KeyEvent.VK_RIGHT:

                        panel.dx = 8;

                        break;



                }

                //방향키 2개 구분

            }

        });
    }
      class GamePanel extends  JPanel {
        Image imgBack, imgPlayer, imgFood;  // 화면 위 이미지 객체 참조변수
        int width, height; // 패널의 사이즈
        int x, y, w, h;   // x,y 플레이어 중심좌표, w,h 이미지 절반 폭
        int dx = 0, dy = 0; // 플레이어 이미지의 이동속도, 이동 방향
        ArrayList<Food> food = new ArrayList<Food>(); // 여러개의 포인트(음식) 객체 참조 변수
        int score = 0; // 점수

        public GamePanel() {
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

            g.drawImage(imgPlayer, x - w, y - h, this);
            g.setFont(new Font(null,Font.BOLD,20));
            g.setColor(Color.white);
            g.drawString("Score : " + score,10,20);
        }

        void move () { // 플레이어 움직이기
            // 음식 떨어지기
            for (int i = food.size() -1; i >0; i--){
                Food f = food.get(i);
                f.move();
                if(f.isDead()) food.remove(i);
            }
            x += dx;
            //플레이어가 화면밖으로 나가지 않게끔
            if(x < w) x = w;
            if(x > width - w) x = width - w;
        }
        void makeFood() { // 음식 생성 메소드
            if (width == 0 || height == 0) return;
            Random rnd = new Random();// 1/50확률로 음식 생성
            int n = rnd.nextInt(50);
            if (n == 0) {
                food.add(new Food(imgFood, width, height));
            }
        }
        void checkCollision() { //플레이어와 음식 충돌
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
    class GameThread extends Thread {
        @Override
        public void run() {
            while (true) {
                //음식 객체 만들어내는 기능 메소드 호출
                panel.makeFood();
                //GamePanel의 플레이어 좌표 변경

                //panel.x += -1;// 객체의 멤버값 변경은

                //panel.y += -5;/// 그 객체가 스스로 하도록 하는것이 OOP이 기본 모티브

                panel.move();

                panel.checkCollision();//충돌 체크 기능 호출

                panel.repaint();//GamePanel의 화면 갱신

                try { //너무 빨리 돌아서 천천히 돌도록

                    sleep(20);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

}






