package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.services.AzuPlayerService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class StopSongAction extends MainAction implements ActionListener {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (AzuPlayerService.isSongPlaying) {
            AzuPlayerService.stop();
        }
    }
}
