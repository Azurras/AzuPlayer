package dev.christopherbell.azuplayer.services;

import dev.christopherbell.azuplayer.gui.HelpGUI;
import dev.christopherbell.azuplayer.gui.SelectMusicCollectionGui;
import dev.christopherbell.azuplayer.models.MusicCollection;
import dev.christopherbell.azuplayer.models.Song;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class AzuPlayerService {
    public static MusicCollection musicCollection = new MusicCollection();
    public static Song currentSong = new Song();
    public static boolean isSongPlaying = false;
    public static Player player;

    public AzuPlayerService() {
    }

    public static void init() {
        new SelectMusicCollectionGui();
        new HelpGUI();
    }

    public static List<File> getSongFiles() {
        File musicFolder = new File(Objects.requireNonNullElse(musicCollection.getLocation(), ""));
        return Arrays.asList(Objects.requireNonNullElse(musicFolder.listFiles(), new File[1]));
    }

    public static void play() {
        var songPath = musicCollection.getLocation() + "\\" + currentSong.getName();
        var mediaLocator = new MediaLocator(songPath);
        try {
            player = Manager.createRealizedPlayer(mediaLocator);
            player.start();
            AzuPlayerService.isSongPlaying = true;
        } catch (IOException | NoPlayerException | CannotRealizeException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        player.stop();
        AzuPlayerService.isSongPlaying = false;
    }
}
