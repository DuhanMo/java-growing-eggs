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
		this.setSize(700, 700);
		this.setLocation(0, 315);
		this.setOpaque(false);
		
		//글을 입력할 수 있는 텍스트 상자
		JTextField id = new JTextField(10);
		this.add(new JLabel("ID:"));
		this.add(id);
		id1 = id.getText();
		
		//로그인시 중복아이디를 확인하고 회원 이름 저장
		JButton btn = new JButton("아이디 확인");
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
							JOptionPane.showMessageDialog(null, "중복아이디 입니다. 다시 입력해주세요ㅎㅅㅎ");
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
								JOptionPane.showMessageDialog(null, id.getText()+"님의 아이디가 저장 되었습니다! \n 집안로 들어가주세요6v6");
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

			}
		});
			
		
	}
	
}
