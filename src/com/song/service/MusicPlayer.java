package com.song.service;

import java.util.ArrayList;
import java.util.List;

import com.song.model.Playlist;
import com.song.model.Song;

public class MusicPlayer {

	private List<Song> allSongs;
	private List<Playlist> playlists;

	public MusicPlayer() {
		this.allSongs = new ArrayList<>();
		this.playlists = new ArrayList<>();
	}

	public MusicPlayer(List<Song> allSongs, List<Playlist> playlists) {
		this.allSongs = allSongs != null ? allSongs : new ArrayList<>();
		this.playlists = playlists != null ? playlists : new ArrayList<>();
	}

	// 1. Add New Song
	public void addSong(Song song) {
		allSongs.add(song);
		System.out.println("Song added: " + song.getTitle());
	}

	// 2. Update Existing Song
	public void updateSong(String oldTitle, Song updatedSong) {
		for (int i = 0; i < allSongs.size(); i++) {
			if (allSongs.get(i).getTitle().equalsIgnoreCase(oldTitle)) {
				allSongs.set(i, updatedSong);
				System.out.println("Song updated: " + updatedSong.getTitle());
				return;
			}
		}
		System.out.println("Song not found: " + oldTitle);
	}

	// 3. Delete Song
	public void deleteSong(String title) {
		boolean removed = allSongs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
		if (removed) {
			System.out.println("Deleted song: " + title);
		} else {
			System.out.println("Song not found: " + title);
		}
	}

	// 4. Display All Songs
	public void displayAllSongs() {
		if (allSongs.isEmpty()) {
			System.out.println("No songs available.");
		} else {
			System.out.println("All Songs:");
			for (Song song : allSongs) {
				System.out.println(song);
			}
		}
	}

	// 5. Create New Playlist
	public void createPlaylist(String playlistName) {
		int playlistId = playlists.size() + 1; // auto-increment
		playlists.add(new Playlist(playlistId, playlistName, new ArrayList<>()));
		System.out.println("Playlist created: '" + playlistName + "'");
	}

	// 6. Add Song to Playlist
	public void addSongToPlaylist(String playlistName, String songTitle) {
		Playlist playlist = findPlaylistByName(playlistName);
		Song song = findSongByTitle(songTitle);

		if (playlist != null && song != null) {
			playlist.addSong(song);
		} else {
			if (playlist == null)
				System.out.println("Playlist not found: " + playlistName);
			if (song == null)
				System.out.println("Song not found: " + songTitle);
		}
	}

	// 7. Display All Playlists
	public void displayAllPlaylists() {
		if (playlists.isEmpty()) {
			System.out.println("No playlists available.");
		} else {
			System.out.println("Playlists:");
			for (Playlist playlist : playlists) {
				System.out.println(playlist.getPlaylistName());
			}
		}
	}

	// 8. Display Songs in Playlist
	public void displaySongsInPlaylist(String playlistName) {
		Playlist playlist = findPlaylistByName(playlistName);
		if (playlist != null) {
			playlist.display();
		} else {
			System.out.println("Playlist not found: " + playlistName);
		}
	}

	// 9. Play Song in Playlist
	public void playSongInPlaylist(String playlistName, String songTitle) {
		Playlist playlist = findPlaylistByName(playlistName);
		if (playlist != null) {
			playlist.play(songTitle);
		} else {
			System.out.println("Playlist not found: " + playlistName);
		}
	}

	// 10. Pause Song in Playlist
	public void pauseSongInPlaylist(String playlistName, String songTitle) {
		Playlist playlist = findPlaylistByName(playlistName);
		if (playlist != null) {
			playlist.pause(songTitle);
		} else {
			System.out.println("Playlist not found: " + playlistName);
		}
	}

	// 11. Stop Song in Playlist
	public void stopSongInPlaylist(String playlistName, String songTitle) {
		Playlist playlist = findPlaylistByName(playlistName);
		if (playlist != null) {
			playlist.stop(songTitle);
		} else {
			System.out.println("Playlist not found: " + playlistName);
		}
	}

	// ===== Helper Methods =====

	private Playlist findPlaylistByName(String name) {
		for (Playlist playlist : playlists) {
			if (playlist.getPlaylistName().equalsIgnoreCase(name)) {
				return playlist;
			}
		}
		return null;
	}

	private Song findSongByTitle(String title) {
		for (Song song : allSongs) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				return song;
			}
		}
		return null;
	}

	// ===== Getters =====
	public List<Song> getAllSongs() {
		return allSongs;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}
}
