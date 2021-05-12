package dev.christopherbell.azuplayer.gui;

import dev.christopherbell.azuplayer.actions.SongPathGuiSubmitAction;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SongPathGUI {
    public SongPathGUI() {
        var frame = createMainFrame();
        var requestPathLabel = createNewLabel();
        var musicFolderPathTextField = createNewTextField();
        var submitButton = initializeSubmitButton(musicFolderPathTextField);
        var panel = initializeMainPanel(requestPathLabel, musicFolderPathTextField, submitButton);
        frame.add(panel);
    }

    private JLabel createNewLabel() {
        var label = new JLabel("Please enter music folder path.");
        label.setBounds(25, 0, 200, 50);
        return label;
    }

    private JTextField createNewTextField() {
        var textField = new JTextField();
        textField.setBounds(5, 60, 240, 50);
        return textField;
    }

    private JPanel initializeMainPanel(JLabel requestPathLabel, JTextField musicFolderPathTextField, JButton submitButton) {
        var panel = new JPanel(null);
        panel.add(requestPathLabel);
        panel.add(musicFolderPathTextField);
        panel.add(submitButton);
        panel.setBounds(0, 0, 300, 300);
        return panel;
    }

    private JButton initializeSubmitButton(JTextField musicFolderPathTextField) {
        var submitButton = new JButton("Submit");
        submitButton.setBounds(70, 120, 100, 50);
        submitButton.addActionListener(new SongPathGuiSubmitAction(musicFolderPathTextField));
        return submitButton;
    }

    private JFrame createMainFrame() {
        var frame = new JFrame();
        frame.setTitle("AzuPlayer");
        frame.setSize(250, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane();
        return frame;
    }
}
