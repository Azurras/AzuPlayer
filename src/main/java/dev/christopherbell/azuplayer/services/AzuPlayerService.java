package dev.christopherbell.azuplayer.services;

import dev.christopherbell.azuplayer.actions.MainAction;
import dev.christopherbell.azuplayer.gui.HelpGUI;
import dev.christopherbell.azuplayer.gui.SongPathGUI;
import dev.christopherbell.azuplayer.models.MusicCollection;
import dev.christopherbell.azuplayer.models.Song;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class AzuPlayerService {
    public static MusicCollection musicCollection;
    public static Song currentSong;
    public static boolean isSongPlaying = false;

    public AzuPlayerService() {
        musicCollection = new MusicCollection();
        currentSong = new Song();
        new SongPathGUI();
        new HelpGUI();
    }

    public static List<File> getSongFiles() {
        File musicFolder = new File(Objects.requireNonNullElse(musicCollection.getLocation(), ""));
        return Arrays.asList(Objects.requireNonNullElse(musicFolder.listFiles(), new File[1]));
    }
}
