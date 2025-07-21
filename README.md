# Console-Based-Music-Player
Projects

# 🎮 Console-Based Music Player in Java 🎧

Welcome to the **Console-Based Music Player**, a 🎮 gaming-style menu-driven application built in **Java** using Object-Oriented Programming concepts. This project lets users add, organize, and simulate playback of songs and playlists right from the terminal!

---

## 🎯 Objective

The goal is to:

- 🎼 Simulate a basic music player in the console
- 📁 Allow users to manage a music library and playlists
- 🛠️ Showcase OOP principles like **Encapsulation**, **Abstraction**, **Inheritance**, and **Polymorphism**

---

## 🧠 OOP Concepts Demonstrated

| 🔑 Concept       | 💡 How It's Used                                                      |
|------------------|------------------------------------------------------------------------|
| **Encapsulation** | `Song` class uses private fields with public getters/setters           |
| **Abstraction**   | `Playable` interface defines generic playback actions                  |
| **Inheritance**   | `Playlist` class implements `Playable`                                 |
| **Polymorphism**  | `play()`, `pause()`, and `stop()` are overridden in `Playlist`         |
| **Collections**   | `ArrayList` manages dynamic lists of songs and playlists               |

---

## 🧱 Class Breakdown

### 🎵 `Song` Class

Represents a music track.

- **Fields:** `songId`, `title`, `artist`, `duration`
- **Purpose:** Holds song data
- **Methods:** Constructor, Getters/Setters, `toString()`

---

### 🧩 `Playable` Interface

Abstracts playback features.

- **Methods:**
  - `play(String title)`
  - `play(int songId)`
  - `pause(String title)`
  - `pause(int songId)`
  - `stop(String title)`
  - `stop(int songId)`

---

### 📻 `Playlist` Class *(implements Playable)*

Manages a group of songs.

- **Fields:** `playlistId`, `playlistName`, `List<Song>`
- **Methods:**
  - `addSong(Song)`
  - `removeSong(String/int)`
  - `displaySongs()`
  - Implements `play()`, `pause()`, `stop()`

---

### 🎛️ `MusicPlayer` Class

Controls the entire system.

- **Fields:** `List<Song> allSongs`, `List<Playlist> playlists`
- **Methods:**
  - `addSong(Song)`
  - `updateSong(String, Song)`
  - `deleteSong(String)`
  - `displayAllSongs()`
  - `createPlaylist(String)`
  - `addSongToPlaylist(String, Song)`
  - `deletePlaylist(String)`
  - `playPlaylist(String)`
  - `getPlaylist(String)`
  - `displayAllPlaylists()`

---

## 🖥️ Menu System

========= 🎶 MUSIC PLAYER MENU 🎶 =========

➕ Add New Song

✏️ Update Existing Song

❌ Delete Song

📃 Display All Songs

🆕 Create New Playlist

📥 Add Song to Playlist

📂 Display All Playlists

🎵 Display Songs in Playlist

▶️ Play Song in Playlist

⏸️ Pause Song in Playlist

⏹️ Stop Song in Playlist

🚪 Exit
Enter your choice:


## 📁 Project Structure

ConsoleMusicPlayer/
├── Song.java
├── Playable.java
├── Playlist.java
├── MusicPlayer.java
├── Main.java
└── README.md



## ⚙️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ConsoleMusicPlayer.git
   cd ConsoleMusicPlayer


#Compile the Java files

javac *.java

#Run the application
java Main

🚀 Future Enhancements
🔁 Shuffle and repeat mode

💾 Save/load functionality with file I/O

🔊 Real audio playback using JLayer or JavaFX Media

🖼️ GUI version with JavaFX or Swing


🤝 Contributing
Found a bug or want to suggest a new feature? Feel free to fork the repo and create a pull request!
####################################################################################################

👤 Author
Your Name: Balaji-Rasani

GitHub: https://github.com/Balaji-Rasani

Email: rasanibalaji74@gmail.com










