package com.song.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.song.behavior.Playable;

public class Playlist implements Playable {

	// 1.Variables

	private int playlistId;

	private String playlistName;

	private List<Song> songs;

	// 2.Default Constructor
	public Playlist() {

	}

	// 3.Parameterized Constructor
	//// Full constructor
	public Playlist(int playlistId, String playlistName, List<Song> songs) {
		super();
		this.playlistId = playlistId;
		this.playlistName = playlistName;
		this.songs = songs != null ? songs : new ArrayList<>();
	}

	// Name-only constructor
	public Playlist(String playlistName) {
		this.playlistName = playlistName;
		this.songs = new ArrayList<>();
	}

	// 4.Adding Key Methods
	// Add a song to the playlist
	public void addSong(Song song) {
		songs.add(song);
		System.out.println("song added to playlist: '" + playlistName + "': " + song.getTitle());
	}

	// Remove a song by title
	public void removeSong(String title) {
		// iterate all the songs using iterator
		Iterator<Song> iterator = songs.iterator();// song is an object
		boolean removed = false;
		while (iterator.hasNext()) {
			Song song = iterator.next();
			if (song.getTitle().equalsIgnoreCase(title)) {
				iterator.remove();
				System.out.println("Removed song: " + title);
				removed = true;
				break;
			}
		} // if song not removed song not found
		if (!removed) {
			System.out.println("Song not found: " + title);
		}

	}

	// Remove a song by ID
	public void removeSong(int songId) {
		Iterator<Song> iterator = songs.iterator();
		boolean removed = false;
		while (iterator.hasNext()) {
			Song song = iterator.next();
			if (song.getSongId() == songId) {
				iterator.remove();
				System.out.println("Removed song ID: " + songId);
				removed = true;
				break;
			}
		}
		if (!removed) {
			System.out.println("Song ID not found: " + songId);
		}
	}

	// Display all songs in the playlist
	public void display() {
		System.out.println("Songs in Playlist '" + playlistName + "':");
		if (songs.isEmpty()) {
			System.out.println("No songs in this playlist.");
		} else {
			for (Song song : songs) {
				System.out.println("ID: " + song.getSongId() + ", Title: " + song.getTitle());
			}
		}
	}

	// 5.Overrided Methods/Implementations for play(), pause(), stop()

	// Play a song by title
	@Override
	public void play(String title) {
		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Playing : '" + title + "' from Playlist '" + playlistName + "'...");
				return;
			}
		}
		System.out.println("Song not found: " + title);

	}

	// Play a song by ID
	@Override
	public void play(int songId) {
		for (Song song : songs) {
			if (song.getSongId() == songId) {
				System.out.println("Playing song ID: " + songId);
				return;
			}
		}
		System.out.println("Song ID not found: " + songId);
	}

	// Pause a song Title
	@Override
	public void pause(String title) {
		System.out.println("Paused: " + title);
	}

	// Pause a Song ID
	@Override
	public void pause(int songId) {
		System.out.println("Paused: " + songId);

	}

	// Stop the Song with reference of Title
	@Override
	public void stop(String title) {
		System.out.println("Stopped: " + title);
	}

	// Stop the song with reference of ID
	@Override
	public void stop(int songId) {
		System.out.println("Stopped song ID: " + songId);

	}

	// 6.generate Getters
	public int getPlaylistId() {
		return playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public List<Song> getSongs() {
		return songs;
	}

}
