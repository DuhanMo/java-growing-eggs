package com.kh.breakegg.main.view;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyBoard extends JFrame {

	public KeyBoard() {		
		JFrame f = new JFrame();
		f.setTitle("키보드로 알바꾸기");
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		
		JPanel pan1 = new JPanel();
		Image myImg = new ImageIcon("./image/b_egg.png").getImage().getScaledInstance(150, 150, 0);				
		JLabel lb = new JLabel(new ImageIcon(myImg));
		pan1.add(lb);
		
		
		//3.컨테이너에 컴포넌트 요소를 추가
		f.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_RIGHT) {
					System.out.println("키값 들어옴");
					pan1.remove(lb);
					System.out.println("패널에 라벨-그림 지움");
					Image myImg2 = new ImageIcon("./image/b_begg.png").getImage().getScaledInstance(150, 150, 0);
					System.out.println("그림 이미지 만듬");
					JLabel lb2 = new JLabel(new ImageIcon(myImg2));
					System.out.println("새로넣을 그림 라벨화함");
					pan1.add(lb2);
					System.out.println("패널에 라벨 넣음");
					f.add(pan1,"Center");
					System.out.println("프레임에 패널 넣음");
					f.repaint();
					System.out.println("리페인트함");
					f.setVisible(true);
				}else {
					f.setVisible(false);
				}	
				
			}
		});

		f.add(pan1,"Center");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 프로그램 종료
		f.setVisible(true);// 창 보임	
		
		
	}
	//실행용 메소드
	public static void main(String[] args) {
		KeyBoard k = new KeyBoard();
	}

}
