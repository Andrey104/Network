package com.company.Chat;

import javax.swing.*;
import java.awt.*;

public class Chat {
    private JTextArea taMain;
    private JTextField tfMsg;
    private JMenu mainMenu;

    private final int FRM_LOC_X = 100;
    private final int FRM_LOC_Y = 100;
    private final int FRM_WIDTH = 400;
    private final int FRM_HEIDTH = 400;

    public static void main(String[] args) {
        new Chat();
    }

    public Chat() {

        JFrame Chat = new JFrame ("COMport Chat");

        mainMenu = new JMenu("Меню");
        JMenuItem settings = new JMenuItem("Настройки");
        settings.addActionListener(e -> {
            new Settings(Chat);
        });
        mainMenu.add(settings);
        tfMsg = new JTextField();
        taMain = new JTextArea(FRM_HEIDTH/19, 50);
        JScrollPane spMain = new JScrollPane(taMain);
        spMain.setLocation(0,0);
        taMain.setLineWrap(true);
        taMain.setEditable(false);

        JMenuBar menuBar = new JMenuBar();
        JButton btnSend = new JButton();
        btnSend.setText("Send");
        btnSend.addActionListener(e -> {
            taMain.append("test");
        });

        menuBar.add(mainMenu);

        Chat.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE); //Закрываем приложение после закрытия всех окон
        Chat.setJMenuBar(menuBar);
        Chat.setLocation(FRM_LOC_X, FRM_LOC_Y);
        Chat.setSize(FRM_WIDTH,FRM_HEIDTH);
        Chat.setResizable(false);
        Chat.getContentPane().add(BorderLayout.NORTH, spMain);
        Chat.getContentPane().add(BorderLayout.CENTER, tfMsg);
        Chat.getContentPane().add(BorderLayout.EAST, btnSend);
        Chat.pack();
        Chat.setVisible(true);
    }
}