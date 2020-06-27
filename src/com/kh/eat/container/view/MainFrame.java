package com.kh.eat.container.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    GamePanel panel;
    GameThread gThread;
    ExitThread exitThread;
    Dialog dl = new Dialog(this,"게임 종료");
    JButton btn = new JButton("확인");

    public MainFrame() {
        dl.setLayout(new FlowLayout());
        dl.setSize(210,80);
        dl.setLocationRelativeTo(null);

        this.setTitle("Get Point!!");

        // 사이즈 설정 이후에 setLocationRelativeTo() 메소드 이용하면 화면 정중앙에 생성
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new GamePanel();
        this.add(panel, BorderLayout.CENTER);

        this.setVisible(true);
        gThread = new GameThread();
        gThread.start(); //run() 메소드 자동실행

        exitThread = new ExitThread();
        // 타이머 쓰레드 객체로 가져와서 그 안에 타이머변수 가져오고 스케쥴메소드 이용(인자값으로 타이머태스크 변수와 딜레이값 적용)
        // 딜레이 후에 수행내용 시작
        exitThread.getExitTimer().schedule(exitThread.getExitTask(), 20000);

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
                        panel.dx = 0;
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
                        panel.dx = -12;
                        break;
                    case KeyEvent.VK_RIGHT:
                        panel.dx = 12;
                        break;
                }
                //방향키 2개 구분
            }
        });
    }

    class GameThread extends Thread {
        @Override
        public void run() {
            while (true) {
                //음식 객체 만들어내는 기능 메소드 호출
                panel.makeFood();

                panel.move();

                panel.checkCollision();//충돌 체크 기능 호출

                panel.repaint();//GamePanel의 화면 갱신

                try { //적당한 속도로 화면 갱신

                    sleep(20);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    class ExitThread {
        Timer exitTimer = new Timer(); // 타이머가 수행되는 변수
        TimerTask exitTask = new TimerTask() { // 타이머가 수행할 내용을 작성해주는 객체
            // timertask
            @Override
            public void run() {
                System.out.println("게임을 종료합니다. ");
                System.out.println(panel.score);
                remove(panel);

                dl.add(new JLabel("게임이 종료되었습니다. " + panel.score + "점입니다."));
                dl.add(btn);
                dl.setVisible(true);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
            }
        };

        public Timer getExitTimer() {
            return exitTimer;
        }

        public TimerTask getExitTask() {
            return exitTask;
        }
    }

}






