/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.model.adapters.inmemory;
import songlist.model.entities.Song;
import songlist.model.interfaces.SongRepository;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author giova
 */
public class InMemorySongRepository implements SongRepository  {
    private List<Song> songs = new ArrayList<>();

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public void removeSong(String id) {
        songs.removeIf(song -> song.getId().equals(id));
    }

    @Override
    public List<Song> getAllSongs() {
        return new ArrayList<>(songs);
    }
}
