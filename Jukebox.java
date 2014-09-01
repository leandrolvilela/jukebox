package com.jukebox;

import java.io.*;
import java.util.*;

public class Jukebox {

	ArrayList<String> songList = new ArrayList<String>();

	public static void main(String[] args) {
		new Jukebox().go();
	}

	public void go() {
		getSongs();
		System.out.println(this.songList);
		Collections.sort(this.songList);
		System.out.println(this.songList);
	}

	void getSongs() {
		try {
			File file = new File("c:\\SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		this.songList.add(tokens[0]);
	}
}
