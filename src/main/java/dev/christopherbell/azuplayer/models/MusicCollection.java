package dev.christopherbell.azuplayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicCollection {
    private String name;
    private String location;
    private List<Song> songs;

    public MusicCollection(String name, String location, ArrayList<Song> songs) {
        this.name = name;
        this.location = location;
        this.songs = songs;
    }
}
