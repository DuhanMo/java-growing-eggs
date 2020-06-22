package com.kh.main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    JFrame frame = new JFrame();
    Image imgFarm;
    MyPanel panel = new MyPanel();


    public MainFrame() {



        frame.setTitle("알 키우기");
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);



        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MyPanel extends JPanel {

         public MyPanel() {
             JButton gameBtn1 = new JButton("미니게임 1");
             JButton gameBtn2 = new JButton("미니게임 2");
             JButton gameBtn3 = new JButton("미니게임 3");

             gameBtn1.setBounds(50,100,125,50);
             gameBtn2.setBounds(50,200,125,50);
             gameBtn3.setBounds(50,300,125,50);
             this.setLayout(null);

             this.add(gameBtn1);
             this.add(gameBtn2);
             this.add(gameBtn3);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            imgFarm = toolkit.getImage("images/farm.jpg");
            imgFarm = imgFarm.getScaledInstance(700, 700, Image.SCALE_SMOOTH);


            gameBtn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new com.kh.eat_game.container.view.StartFrame();
                }
            });

        }
        @Override
        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
            g.drawImage(imgFarm, 0, 0, this);
        }

    }


}
