package com.company.application_layer;

import sun.net.www.http.PosterOutputStream;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Settings {
    private final int FRM_LOC_X = 100;
    private final int FRM_LOC_Y = 100;
    private final int FRM_WIDTH = 400;
    private final int FRM_HEIDTH = 400;

    public Settings(JFrame parentFrame, String[] PortsList){

        JDialog Settings = new JDialog(parentFrame, "Настройки", true);

        Container content = Settings.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JComboBox ComPort1 = new JComboBox(PortsList);
        JComboBox ComPort2 = new JComboBox(PortsList);
        JLabel textCom1 = new JLabel("COM port 1:");
        JLabel textCom2 = new JLabel("COM port 2:");
        JLabel textUserName = new JLabel("Имя пользователя:");
        JTextField UserName = new JTextField();
        JButton ok = new JButton("OK");
        content.add(textCom1);
        content.add(ComPort1);
        content.add(textCom2);
        content.add(ComPort2);
        content.add(textUserName);
        content.add(UserName);
        content.add(ok);

        Settings.setResizable(false);
        Settings.setLocation(FRM_LOC_X, FRM_LOC_Y);
        Settings.pack();
        Settings.setVisible(true);
    }
}
