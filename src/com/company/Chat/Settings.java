package com.company.Chat;

import javax.swing.*;

public class Settings {
    public Settings(JFrame parentFrame){
        JDialog frame = new JDialog(parentFrame, "Настройки", true);
        frame.pack();
        frame.setVisible(true);
    }
}
