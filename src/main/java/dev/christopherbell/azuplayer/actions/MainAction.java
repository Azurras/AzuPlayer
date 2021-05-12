package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.models.Song;

import javax.swing.JTable;
import javax.swing.JTextField;

public class MainAction {
    public static boolean isSongPlaying = false;
    public static JTextField musicCollectionLocationTextField;
    public static String musicCollectionLocation;
    public static Song currentSong;
    public static JTable songTable;

    public MainAction() {
    }
}
