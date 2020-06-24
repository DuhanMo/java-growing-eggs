package com.kh.breakegg.main.view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class A_MainFrameView extends JFrame implements ActionListener{
	
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

		//프레임 기본세팅 
		public A_MainFrameView() {
			JFrame mainFrame = new JFrame();
			mainFrame.setTitle("미니프로젝트 - 알 키우기 게임"); // 타이틀
			mainFrame.setSize(700, 700);// 창크기 
			mainFrame.setLocationRelativeTo(null);// 창이 가운데로 나오게
			mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 프로그램 종료
			mainFrame.setVisible(true);// 창 보임			
			
			//배경 이미지
			ImagePanel panel = new ImagePanel(new ImageIcon("./image/back1.png").getImage());
					
			//시작 버튼 
			JButton sbtn = new JButton(new ImageIcon("./image/egg1.png"));
			sbtn.setBounds(500, 400, 150, 150);
			sbtn.setBorderPainted(false);
			sbtn.setContentAreaFilled(false);
			sbtn.setOpaque(false);
			
			sbtn.addMouseListener(new MouseAdapter() {
				int mouseClickcount = 0;
				@Override
				public void mouseClicked(MouseEvent e) {
					mouseClickcount++;
					
					switch(mouseClickcount) {
					case 1 :
						Image myImg = new ImageIcon("./image/eggl.png").getImage().getScaledInstance(150, 150, 0);
						sbtn.setIcon(new ImageIcon(myImg));	
						break;
						
					case 2 :
						Image myImg2 = new ImageIcon("./image/eggr.png").getImage().getScaledInstance(150, 150, 0);
						sbtn.setIcon(new ImageIcon(myImg2));
						break;
					case 3 :
						//새로 시작하기 게임 불러오기 창 생성 
						new B_StartFrameView();
		
						//현재창 닫음
						mainFrame.setVisible(false);	
						break;
					}
					
				}
				
			});
			
			//끝내기 버튼
			JButton ebtn = new JButton(new ImageIcon("./image/etnbt.png"));
			ebtn.setBounds(485, 160, 100, 50);
			ebtn.setOpaque(false);
			ebtn.setBorderPainted(false);
			ebtn.setContentAreaFilled(false);
			ebtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			
			JLabel l = new JLabel("알을 눌러보세요");
			l.setBounds(530, 530, 100, 40);
			
			panel.add(l);
			panel.add(sbtn);
			panel.add(ebtn);
			mainFrame.add(panel);
			mainFrame.pack();
			
		}
		

//		public static void main(String[] args) {
//			new A_MainFrameView();
//
//		}



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}


}
