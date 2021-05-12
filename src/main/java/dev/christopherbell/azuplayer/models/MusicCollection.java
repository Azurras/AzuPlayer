package dev.christopherbell.azuplayer.models;

import java.util.ArrayList;
import java.util.List;

public class MusicCollection {
    private final String name;
    private final String location;
    private final List<Song> songs;

    public MusicCollection(String name, String location, ArrayList<Song> songs) {
        this.name = name;
        this.location = location;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
