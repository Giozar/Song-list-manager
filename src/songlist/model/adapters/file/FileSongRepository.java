/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.model.adapters.file;

import songlist.model.entities.Song;
import songlist.model.interfaces.SongRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class FileSongRepository implements SongRepository {
    private final String filePath;

    public FileSongRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void addSong(Song song) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(song.getId() + "," + song.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeSong(String id) {
        List<Song> songs = getAllSongs();
        songs.removeIf(song -> song.getId().equals(id));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Song song : songs) {
                writer.write(song.getId() + "," + song.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    songs.add(new Song(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
