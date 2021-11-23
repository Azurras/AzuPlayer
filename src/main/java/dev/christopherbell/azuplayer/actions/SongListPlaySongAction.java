package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SongListPlaySongAction extends MainAction implements ActionListener {
    public SongListPlaySongAction(JTable newSongTable) {
        songTable = newSongTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var selectedRowIndex = songTable.getSelectedRow();
        var selectedColumnIndex = songTable.getSelectedColumn();
        var selectedObject = (String) songTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
        AzuPlayerService.currentSong.setCurrentSongPath(selectedObject);
        try {
            System.out.println(AzuPlayerService.currentSong.getCurrentSongPath());
            if (!AzuPlayerService.isSongPlaying) {
                AzuPlayerService.currentSong.play();
                AzuPlayerService.isSongPlaying = true;
            }
        } catch (NoPlayerException | IOException | CannotRealizeException ex) {
            ex.printStackTrace();
        }
    }
}
