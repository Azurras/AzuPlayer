package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.gui.MusicCollectionGui;
import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubmitMusicCollectionAction extends MainAction implements ActionListener {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public SubmitMusicCollectionAction(JTextField musicCollectionPathTextField) {
        LOG.info("SubmitMusicCollectionAction started.");
        musicCollectionLocationTextField = musicCollectionPathTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var musicCollectionPath = musicCollectionLocationTextField.getText();
        AzuPlayerService.musicCollection.setLocation(musicCollectionPath);
        LOG.log(Level.INFO, "LOGGER: Music Collection Location: " + musicCollectionPath);
        new MusicCollectionGui();
    }
}
