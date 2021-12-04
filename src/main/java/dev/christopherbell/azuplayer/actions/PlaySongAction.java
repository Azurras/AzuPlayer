package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class PlaySongAction extends MainAction implements ActionListener {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public PlaySongAction(JTable newSongTable) {
        songTable = newSongTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var selectedRowIndex = songTable.getSelectedRow();
        var selectedColumnIndex = songTable.getSelectedColumn();
        var selectedObject = (String) songTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
        AzuPlayerService.currentSong.setName(selectedObject);
        LOG.info(AzuPlayerService.currentSong.getName());
        if (!AzuPlayerService.isSongPlaying) {
            AzuPlayerService.play();
        }
    }
}
