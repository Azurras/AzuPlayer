package dev.christopherbell.azuplayer.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongListStopSongAction extends MainAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isSongPlaying) {
            currentSong.stop();
            isSongPlaying = false;
        }
        System.out.println(currentSong.getCurrentSongPath());
    }
}
