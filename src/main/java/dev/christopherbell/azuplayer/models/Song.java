package dev.christopherbell.azuplayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private String artist;
    private String duration;
    private String location;
    private String name;
    private int plays;
}
