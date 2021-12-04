package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.logging.Logger;

public class PlaySongAction extends MainAction implements ActionListener {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public PlaySongAction(JTable newSongTable) {
        songTable = newSongTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var rowIndex = songTable.getSelectedRow();
        var columnIndex = songTable.getSelectedColumn();
        if (Objects.nonNull(songTable.getModel())) {
            var songName = songTable.getModel().getValueAt(rowIndex, columnIndex).toString();
            AzuPlayerService.currentSong.setName(Objects.requireNonNullElse(songName, ""));
            LOG.info("Attempting to play: " + AzuPlayerService.currentSong.getName());
            if (!AzuPlayerService.isSongPlaying) {
                AzuPlayerService.play();
            }
        }
    }
}
