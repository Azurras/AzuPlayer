package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.gui.MusicCollectionGui;
import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubmitMusicCollectionAction extends MainAction implements ActionListener {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public SubmitMusicCollectionAction(JTextField musicCollectionPathTextField) {
        musicCollectionLocationTextField = musicCollectionPathTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.nonNull(musicCollectionLocationTextField.getText())) {
            var musicCollectionPath = musicCollectionLocationTextField.getText();
            AzuPlayerService.musicCollection.setLocation(musicCollectionPath);
            LOG.log(Level.INFO, "LOGGER: Music Collection Location: " + musicCollectionPath);
            new MusicCollectionGui();
        } else {
            LOG.log(Level.WARNING, "Error: musicCollectionLocationTextField gave a null result back.");
        }
    }
}
