package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.gui.SongListGUI;
import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SongPathGuiSubmitAction extends MainAction implements ActionListener {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public SongPathGuiSubmitAction(JTextField mclTextField) {
        musicCollectionLocationTextField = mclTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        musicCollectionLocation = musicCollectionLocationTextField.getText();
        AzuPlayerService.musicCollection.setLocation(musicCollectionLocation);
        LOG.log(Level.INFO, "LOGGER: Music Collection Location: " + musicCollectionLocation);
        System.out.println("Music Collection Location: " + musicCollectionLocation);
        new SongListGUI(musicCollectionLocation);
    }
}
