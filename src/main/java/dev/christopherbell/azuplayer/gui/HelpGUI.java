package dev.christopherbell.azuplayer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpGUI {
    public HelpGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Bell Help");
        frame.setBounds(0, 223, 250, 200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane();

        JTextArea helpMessage = new JTextArea(5, 20);
        JPanel panel = new JPanel(null);
        JScrollPane scroller = new JScrollPane(helpMessage);

        frame.add(panel);
        panel.add(scroller);

        panel.setBounds(0, 0, 250, 200);
        scroller.setBounds(2, 2, 240, 170);

        helpMessage.setText("Welcome to Bell Player. This player currently only plays .wav files.");
        helpMessage.setLineWrap(true);
        helpMessage.setWrapStyleWord(true);
    }
}
