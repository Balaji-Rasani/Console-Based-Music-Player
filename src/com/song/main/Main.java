package com.song.main;

import java.util.Scanner;

import com.song.model.Song;
import com.song.service.MusicPlayer;

public class Main {
	public static void main(String[] args) {
		MusicPlayer player = new MusicPlayer();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n============== MUSIC PLAYER MENU =================");
			System.out.println("1. Add New Song");
			System.out.println("2. Update Existing Song");
			System.out.println("3. Delete Song");
			System.out.println("4. Display All Songs");
			System.out.println("5. Create New Playlist");
			System.out.println("6. Add Song to Playlist");
			System.out.println("7. Display All Playlists");
			System.out.println("8. Display Songs in Playlist");
			System.out.println("9. Play Song in Playlist");
			System.out.println("10. Pause Song in Playlist");
			System.out.println("11. Stop Song in Playlist");
			System.out.println("12. Exit");
			System.out.println("===================================================");
			System.out.print("Enter your choice: ");
		
			int choice = scanner.nextInt();
			
			scanner.nextLine();// consume new line
			
			switch (choice) {

			// 1.Add new Song to music player
			case 1:
				System.out.print("Enter Song ID: ");
				int id = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				System.out.print("Enter Song Title: ");
				String title = scanner.nextLine();

				System.out.print("Enter Artist Name: ");
				String artist = scanner.nextLine();

				System.out.print("Enter Duration (in minutes): ");
				double duration = scanner.nextDouble();
				scanner.nextLine(); // Consume newline

				player.addSong(new Song(id, title, artist, duration));
				break;

			// 2.Update an existing song based on its title
			case 2:
				System.out.println("Enter Existing Song Title to update:");
				String oldTitle = scanner.nextLine();
				System.out.println("Enter new Song ID: ");
				int newId = scanner.nextInt();
				scanner.nextLine();// consume newline

				System.out.println("Enter new Song Title: ");
				String newTitle = scanner.nextLine();

				System.out.println("Enter new Artist Name: ");
				String newArtist = scanner.nextLine();

				System.out.println("Enter new Duration: ");
				double newDuration = scanner.nextDouble();
				scanner.nextLine();

				player.updateSong(oldTitle, new Song(newId, newTitle, newArtist, newDuration));
				break;

			// 3.Delete a song by title
			case 3:
				System.out.println("Enter Song Title to delete: ");
				String deleteTitle = scanner.nextLine();

				player.deleteSong(deleteTitle);
				break;

			// 4.Display all available songs
			case 4:
				player.displayAllSongs();
				break;

			// 5.Create a new playlist by name
			case 5:
				System.out.println("Enter Playlist Name: ");
				String playlistName = scanner.nextLine();

				player.createPlaylist(playlistName);
				break;

			// 6.Add a song (by title) to specific playlist
			case 6:
				System.out.println("Enter a PlaylistName: ");
				String plName = scanner.nextLine();
				System.out.println("Enter Song Title to add: ");
				String songToAdd = scanner.nextLine();

				player.addSongToPlaylist(plName, songToAdd);
				break;

			// 7.Display all available playlists
			case 7:
				player.displayAllPlaylists();
				break;

			// 8.Display all songs in a specific playlists
			case 8:
				System.out.println("Enter playlist Name: ");
				String plToDisplay = scanner.nextLine();

				player.displaySongsInPlaylist(plToDisplay);
				break;

			// 9.Play a song from a playlist
			case 9:
				System.out.println("Enter a Playlist Name: ");
				String plToPlay = scanner.nextLine();

				System.out.println("Enter Song Title to play: ");
				String songToPlay = scanner.nextLine();

				player.playSongInPlaylist(plToPlay, songToPlay);
				break;

			// 10.Pause a song in a playlist
			case 10:
				System.out.println("Enter Playlist Name: ");
				String plToPause = scanner.nextLine();
				System.out.println("Enter Song Tilte to pause: ");
				String songToPause = scanner.nextLine();

				player.pauseSongInPlaylist(plToPause, songToPause);
				break;

			// 11.Stop a song in a playlist
			case 11:
				System.out.println("Enter Playlist Name: ");
				String plToStop = scanner.nextLine();
				System.out.println("Enter Song Title to stop: ");
				String songToStop = scanner.nextLine();

				player.stopSongInPlaylist(plToStop, songToStop);
				break;

			// 12.Exit the application
			case 12:
				System.out.println("Thanks for using Music Player. Have a great day!");
				scanner.close();
				System.exit(0);// Stops JVM forcefully
				break;

			// 13.Deafult: handle invalid menu choice
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

		}
	}

}
