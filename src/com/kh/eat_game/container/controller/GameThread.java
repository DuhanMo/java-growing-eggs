//package com.kh.eat_game.container.controller;
//
//import com.kh.eat_game.container.view.GamePanel;
//import com.kh.eat_game.container.view.MainFrame;
//
//public class GameThread extends Thread {
//    @Override
//
//    public void run() {
//        while (true) {
//
//            //적군 객체 만들어내는 기능 메소드 호출
//
//            panel.makeEnemy();
//
//            //GamePanel의 플레이어 좌표 변경
//
//            //panel.x += -1;// 객체의 멤버값 변경은
//
//            //panel.y += -5;/// 그 객체가 스스로 하도록 하는것이 OOP이 기본 모티브
//
//            panel.move();
//
//            panel.checkCollision();//충돌 체크 기능 호출
//
//            panel.repaint();//GamePanel의 화면 갱신
//
//            try { //너무 빨리 돌아서 천천히 돌도록
//
//                sleep(20);
//
//            } catch (InterruptedException e) {
//            }
//
//        }
//
//    }
//
//}
