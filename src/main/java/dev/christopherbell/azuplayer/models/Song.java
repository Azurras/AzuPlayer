package dev.christopherbell.azuplayer.models;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Song {
	private final String musicFolderPath;
	private String currentSongPath;
	private int numberOfSongs;
	private File songToPlay;
	private List<File> files;
	private Player player;
	
	public Song(String pathOfMusicFolder){
		this.musicFolderPath = pathOfMusicFolder;
		this.numberOfSongs = getTotalSongCount();
		this.songToPlay = new File("");
		this.files = new ArrayList<>();
	}

	public File getSongToPlay() {
		return songToPlay;
	}

	public List<File> getFiles() {
		return files;
	}

	public int getNumberOfSongs() {
		return numberOfSongs;
	}
	
	public String getMusicFolderPath() {
		return musicFolderPath;
	}
	
	public String getCurrentSongPath() {
		return currentSongPath;
	}
	
	public void setCurrentSongPath(String newSongPath) {
		currentSongPath = musicFolderPath;
		currentSongPath = currentSongPath + "/" + newSongPath;
		songToPlay = new File(currentSongPath);
	}
	
	public void listAllFiles(){
		String path = currentSongPath;
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

	public int getTotalSongCount() {
		var folder = new File(this.musicFolderPath);
		var songList = Arrays.asList(folder.listFiles());
		this.numberOfSongs = songList.size();
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
