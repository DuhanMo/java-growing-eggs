package com.kh.eat_game.container.view;

import javax.swing.*;

public class StartPanel extends JPanel {
    public StartPanel(){
    JPanel startPanel = new JPanel(null);
    JButton sBtn = new JButton("START");
    sBtn.setBounds(300,300,300,150);
    startPanel.add(sBtn);
    }

}
