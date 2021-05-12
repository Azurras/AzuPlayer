package dev.christopherbell.azuplayer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SongPathGUI {
	private final JTextField musicFolderPathTextField;

	public SongPathGUI() {
		var frame = createMainFrame();
		var requestPathLabel = createNewLabel("Please enter music folder path.", 25, 0, 200, 50);
		this.musicFolderPathTextField = new JTextField();
		musicFolderPathTextField.setBounds(5, 60, 240, 50);

		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(70, 120, 100, 50);
		submitButton.addActionListener(new submitButtonListener());

		var panel = new JPanel(null);
		panel.add(requestPathLabel);
		panel.add(musicFolderPathTextField);
		panel.add(submitButton);
		panel.setBounds(0, 0, 300, 300);
		frame.add(panel);
	}

	public JLabel createNewLabel(String text, int xCor, int yCor, int width, int height) {
		var label = new JLabel(text);
		label.setBounds(xCor, yCor, width, height);
		return label;
	}

	private JFrame createMainFrame() {
		var frame = new JFrame();
		frame.setTitle("Bell Player");
		frame.setSize(250, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane();
		return frame;
	}
	
	class submitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String musicFolderPath = musicFolderPathTextField.getText();
			System.out.println("Text Received! " + musicFolderPath);
			new SongListGUI(musicFolderPath);
		}
	}
}
