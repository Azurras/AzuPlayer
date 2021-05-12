package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.gui.SongListGUI;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongPathGuiSubmitAction extends MainAction implements ActionListener {
    public SongPathGuiSubmitAction(JTextField mclTextField) {
        musicCollectionLocationTextField = mclTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Change this to output to a logger
        musicCollectionLocation = musicCollectionLocationTextField.getText();
        System.out.println("Music Collection Location: " + musicCollectionLocation);
        new SongListGUI(musicCollectionLocation);
    }
}
