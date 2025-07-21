package com.song.model;

public class Song {
	// 1.Variables

	private int songId;

	private String title;

	private String artist;

	private double duration;

	// 2.Default Constructor
	public Song() {

	}

	// 3.Parameterized Constructor
	public Song(int songId, String title, String artist, double duration) {
		this.songId = songId;
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}

	// 4.Getters & Setters
	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	// 5.toString()
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", title=" + title + ", artist=" + artist + ", duration=" + duration + "]";
	}

}
