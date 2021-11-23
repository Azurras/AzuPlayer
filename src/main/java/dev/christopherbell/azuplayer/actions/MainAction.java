package dev.christopherbell.azuplayer.actions;

import dev.christopherbell.azuplayer.models.Song;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.logging.Logger;

public class MainAction {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static boolean isSongPlaying = false;
    public static JTextField musicCollectionLocationTextField;
    public static String musicCollectionLocation;
    public static Song currentSong;
    public static JTable songTable;

    public MainAction() {
    }
}
