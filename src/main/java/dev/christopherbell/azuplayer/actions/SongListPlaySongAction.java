package dev.christopherbell.azuplayer.actions;

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
        currentSong.setCurrentSongPath(selectedObject);
        try {
            System.out.println(currentSong.getCurrentSongPath());
            if (!isSongPlaying) {
                currentSong.play();
                isSongPlaying = true;
            }
        } catch (NoPlayerException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
