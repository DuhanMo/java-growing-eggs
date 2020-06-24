package com.kh.breakegg.main.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.breakegg.main.view.A_MainFrameView.ImagePanel;
import com.kh.main.view.MainFrame;

public class C_1Login extends JFrame {
	
	//배경화면 이미지
		class ImagePanel extends JPanel{
			private Image img;
			
			public ImagePanel(Image img) {
				this.img = img;
				setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
				setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
				setLayout(null);
			}
			
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
			
			
		}
		
		public void loginFrame() {
		
		JFrame loginframe = new JFrame();
		loginframe.setTitle("미니프로젝트 - 새로시작하기 회원정보입력"); // 타이틀
		loginframe.setSize(700, 700);// 창크기 
		loginframe.setLocationRelativeTo(null);// 창이 가운데로 나오게
		loginframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 프로그램 종료
		loginframe.setVisible(true);// 창 보임
		
		//배경 이미지
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/back1.png").getImage());		
		
		
		//다음 화면으로 넘어가는 버튼
		ImageIcon normalIcon = new ImageIcon("./image/gn11.png");
		ImageIcon rolloverIcon = new ImageIcon("./image/gn2.png");

		JButton goNextbtn = new JButton("gonext",normalIcon);
		goNextbtn.setRolloverIcon(rolloverIcon);
		goNextbtn.setBounds(399, 365, 148, 163);
		goNextbtn.setBorderPainted(false);
		goNextbtn.setContentAreaFilled(false);
		goNextbtn.setOpaque(false);
		
		goNextbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//게임 튜토리얼 혹은 다음페이지  넣을 곳
				//new 해서 넣으면 됨
				new MainFrame();
				
				loginframe.setVisible(false);
				
			}
		});
		
		loginframe.add(goNextbtn);
		//아이디 입력하는 패널
		loginframe.add(new C_1LoginPanel());
		loginframe.add(panel);
		loginframe.setVisible(true);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.pack();
	}



	public static void main(String[] args) {
		C_1Login c = new C_1Login();
		c.loginFrame();
	}
}
