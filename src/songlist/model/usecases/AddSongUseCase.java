/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.model.usecases;
import songlist.model.entities.Song;
import songlist.model.interfaces.SongRepository;
/**
 *
 * @author giova
 */
public class AddSongUseCase {
    private final SongRepository repository;

    public AddSongUseCase(SongRepository repository) {
        this.repository = repository;
    }

    public void execute(Song song) {
        repository.addSong(song);
    }
}
