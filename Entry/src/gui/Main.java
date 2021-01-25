package gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Runnable run = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MainGUI();
        };

        SwingUtilities.invokeLater(run);
    }
}