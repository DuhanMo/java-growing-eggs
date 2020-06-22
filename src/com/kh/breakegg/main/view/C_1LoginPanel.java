package com.kh.breakegg.main.view;

import com.kh.main.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//로그인용 판넬
public class C_1LoginPanel extends JPanel{
	public String id1;
	public C_1LoginPanel() {
		this.setSize(450, 40);
		this.setLocation(90, 130);
		this.setOpaque(false);
		
		//글을 입력할 수 있는 텍스트 상자
		JTextField id = new JTextField(10);
		this.add(new JLabel("ID:"));
		this.add(id);
		
		
		id1 = id.getText();
		
		Properties prop = new Properties();
		prop.getProperty("savedId", null);
		
		//로그인시 중복아이디를 확인하고 게임의 진짜 메인으로 들어가는 버튼
		JButton btn = new JButton("다음으로");
		btn.setLocation(150, 200);
		btn.setBounds(250, 200, 100, 40);
		this.add(btn);
		
		
		
		//클릭이 되면 아이디와 저장된 아이디를 비교
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				try (BufferedReader br = new BufferedReader(new FileReader("userList.txt"));){
//					한 파일에 저장
					String result;
					String tmp="";
					
					while((result = br.readLine()) != null) {
						tmp +=result;
					}
					
					String[] strArr = tmp.split(",");
					for (int i = 0; i < strArr.length; i++) {
						if(strArr[i].equals(id.getText())) {
							JOptionPane.showMessageDialog(null, "중복아이디 입니다. 다시 입력해주세요");
							System.out.println(strArr[i]);
							System.out.println("확인용1");
						} else {

							BufferedWriter bw =null;
							BufferedWriter bw1 =null;
							BufferedWriter bw2 =null;
							BufferedWriter bw3 =null;
							
							try {
								bw = new BufferedWriter(new FileWriter("userList.txt",true));
								bw.write(id.getText()+",");
								bw1 = new BufferedWriter(new FileWriter("growUpList.txt",true));
								bw1.write("0,");
								bw2 = new BufferedWriter(new FileWriter("tirednessList.txt",true));
								bw2.write("50,");
								bw3 = new BufferedWriter(new FileWriter("hungryList",true));
								bw3.write("50,");
								
								bw.flush();

								bw1.flush();
								bw2.flush();
								bw3.flush();

								//다음페이지로 넘어가는 기능
								new MainFrame();
								break;

							} catch (IOException e1) {
								e1.printStackTrace();
							}finally {
								try {
									bw.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							
						}
					}
				
					
				}catch(IOException e1) {
					e1.printStackTrace();
				}
				
//				System.out.println("확인용0");
				//저장된 아이디와 입력하려는 아이디비교
//				if(id.getText().equals("hell"))/*(prop.getProperty("savedID"))*/ {
//					JOptionPane.showMessageDialog(null, "중복아이디 입니다. 다시 입력해주세요");
//					System.out.println("확인용1");
//					
//				}else {
//					BufferedWriter bw =null;
//					try {
//						bw = new BufferedWriter(new FileWriter("userList.txt",true));
//						bw.write(id.getText()+",");
////						prop.store(new FileOutputStream(id.getText()+".txt"),"jbdc user");
////						prop.setProperty("savedID", id1);
//						System.out.println("하이3");
//						bw.flush();
//						//다음페이지로 넘어가는 기능
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}finally {
//						try {
//							bw.close();
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//					}
//					
//				}


			}
		});
			
		
	}
	
}
