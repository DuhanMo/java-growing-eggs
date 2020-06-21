package com.kh.breakegg.main.view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.breakegg.main.view.A_MainFrameView.ImagePanel;

public class B_StartFrameView extends Frame implements ActionListener {
	
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
	
	
	//프레임 기본
	public B_StartFrameView() {
		JFrame stFrame = new JFrame();
		stFrame.setTitle("미니프로젝트 - 시작 불러오기 화면"); // 타이틀
		stFrame.setSize(600, 388);// 창크기 
		stFrame.setLocationRelativeTo(null);// 창이 가운데로 나오게
		stFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 프로그램 종료
		stFrame.setVisible(true);// 창 보임
		
		//배경 이미지
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/bg.jpg").getImage());

		
	
		//새로 시작버튼
		JButton nbtn = new JButton("새로시작");
		nbtn.setSize(100, 40);
		nbtn.setLocation(250,170);
		nbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == 1) { //마우스 왼쪽버튼 
					//로그인 하는 창 생성
					C_1Login c = new C_1Login();
					c.loginFrame();
					//현재 창 닫음
					stFrame.setVisible(false);
				}
			}
			
		});
		
		//불러오기 버튼
		JButton lbtn = new JButton("불러오기");
		lbtn.setSize(100, 40);
		lbtn.setLocation(250,230);


		
		stFrame.add(nbtn);
		stFrame.add(lbtn);
		
		stFrame.add(panel);
		stFrame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
//	public static void main(String[] args) {
//		new B_StartFrameView();
//	} 구현 확인용
}
