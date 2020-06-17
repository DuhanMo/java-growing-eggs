package com.kh.eat_game.container.view;

import com.kh.eat_game.container.model.vo.Food;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartFrame {

    JFrame startFrame;

    public StartFrame() {

        startFrame = new JFrame("Get Point!!");

        startFrame.setSize(700, 700);

        startFrame.setLocationRelativeTo(null);

        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setLayout(null);


        JButton sBtn = new JButton("제한시간 20초!!  START");
        sBtn.setBounds(200, 300, 300, 100);

        class ImagePanel extends JComponent {
            private Image image;


            public ImagePanel(Image image) {
                this.image = image.getScaledInstance(700,700,Image.SCALE_SMOOTH);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        }
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("images/wall.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startFrame.setContentPane(new ImagePanel(myImage));


        startFrame.add(sBtn);
        startFrame.setVisible(true);

        sBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                startFrame.setVisible(false);
            }
        });


    }

    public static void main(String[] args) {
        new StartFrame();
    }

}
