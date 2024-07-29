/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package songlist.model.interfaces;
import java.util.List;
import songlist.model.entities.Song;

/**
 *
 * @author giova
 */
public interface SongRepository {
    void addSong(Song song);
    void removeSong(String id);
    List<Song> getAllSongs();
}