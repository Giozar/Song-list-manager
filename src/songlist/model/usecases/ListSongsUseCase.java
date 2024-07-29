/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.model.usecases;
import songlist.model.entities.Song;
import songlist.model.interfaces.SongRepository;

import java.util.List;
/**
 *
 * @author giova
 */
public class ListSongsUseCase {
     private final SongRepository repository;

    public ListSongsUseCase(SongRepository repository) {
        this.repository = repository;
    }

    public List<Song> execute() {
        return repository.getAllSongs();
    }
}
