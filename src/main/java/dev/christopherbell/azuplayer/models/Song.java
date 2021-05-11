package dev.christopherbell.azuplayer.models;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Song {
	private final String musicFolderPath;
	private String songPath;
	private int numberOfSongs;
	private File songToPlay;
	private File[] listOfFiles;
	private Player player;
	
	public Song(String pathOfMusicFolder){
		this.musicFolderPath = pathOfMusicFolder;
		this.numberOfSongs = findNumberOfSongs();
	}
	
	public int getNumberOfSongs() {
		return numberOfSongs;
	}
	
	public String getMusicFolderPath() {
		return musicFolderPath;
	}
	
	public String getSongPath() {
		return songPath;
	}
	
	public void setSongPath(String newSongPath) {
		songPath = musicFolderPath;
		songPath = songPath + "/" + newSongPath;
		songToPlay = new File(songPath);
	}
	
	public void listAllFiles(){
		String path = songPath;
		String files;

		File folder = new File(path);
		
		File []listOfFiles = folder.listFiles();

		for (File listOfFile : Objects.requireNonNull(listOfFiles)) {
			if (listOfFile.isFile()) {
				files = listOfFile.getName();
				if (files.endsWith(".wav") || files.endsWith(".WAV")) {
					System.out.println(files);
				}
			}
		}
	}
	
	public int findNumberOfSongs() {
		var folder = new File(this.musicFolderPath);
		var listOfFiles = folder.listFiles();
		this.numberOfSongs = listOfFiles.length;
		return this.numberOfSongs;
	}
	
	public void play() throws NoPlayerException, IOException {
		var ml = new MediaLocator(songToPlay.toURL());
		this.player = Manager.createPlayer(ml);
		this.player.start();
	}
	
	public void stop() {
		player.stop();
	}
}
