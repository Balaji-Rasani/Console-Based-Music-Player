package com.song.behavior;

public interface Playable {
	// Interface only having Method declaration not body

	void play(String title);

	void play(int songId);

	void pause(String title);

	void pause(int songId);

	void stop(String title);

	void stop(int songId);

}
