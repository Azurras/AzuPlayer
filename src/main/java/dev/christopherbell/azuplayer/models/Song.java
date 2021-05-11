package dev.christopherbell.azuplayer.models;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import java.io.File;

public class Song {
	String musicFolderPath;
	String songPath;
	int numberOfSongs;
	File songToPlay;
	File[] listOfFiles;
	Player p;
	
	public Song(String pathOfMusicFolder){
		musicFolderPath = pathOfMusicFolder;
		numberOfSongs = findNumberOfSongs();
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

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".wav") || files.endsWith(".WAV")) {
					System.out.println(files);
				}
			}
		}
	}
	
	public int findNumberOfSongs() {
		File folder = new File(musicFolderPath);
		File []listOfFiles = folder.listFiles();
		numberOfSongs = listOfFiles.length;
		return numberOfSongs;
	}
	
	public void play() throws NoPlayerException, IOException{
		MediaLocator ml = new MediaLocator(songToPlay.toURL());
		p = Manager.createPlayer(ml);
		p.start();
	}
	
	public void stop() {
		p.stop();
	}
}
