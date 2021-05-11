package dev.christopherbell.azuplayer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SongPathGUI {
	JFrame frame;
	JPanel panel;
	JLabel requestPathLabel;
	JTextField musicFolderPathTextField;
	JButton submitButton;
	
	String musicFolderPath;
	int numberOfSongs;
	
	public SongPathGUI() {
		frame = new JFrame();
		
		frame.setTitle("Bell Player");
		frame.setSize(250, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane();
		
		panel = new JPanel(null);
		requestPathLabel = new JLabel("Please enter music folder path.");
		musicFolderPathTextField = new JTextField();
		submitButton = new JButton("Submit");
		
		frame.add(panel);
		panel.add(requestPathLabel);
		panel.add(musicFolderPathTextField);
		panel.add(submitButton);
		
		panel.setBounds(0, 0, 300, 300);
		requestPathLabel.setBounds(25, 0, 200, 50);
		musicFolderPathTextField.setBounds(5, 60, 240, 50);
		submitButton.setBounds(70, 120, 100, 50);
		
		submitButton.addActionListener(new submitButtonListener());
	}
	

	
	class submitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			musicFolderPath = musicFolderPathTextField.getText();
			System.out.println("Text Received! " + musicFolderPath );
			GUI gui = new GUI(musicFolderPath);
		}
	}
}
