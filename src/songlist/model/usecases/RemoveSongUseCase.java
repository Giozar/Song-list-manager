/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.model.usecases;
import songlist.model.interfaces.SongRepository;
/**
 *
 * @author giova
 */
public class RemoveSongUseCase {
    private final SongRepository repository;

    public RemoveSongUseCase(SongRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        repository.removeSong(id);
    }
}
