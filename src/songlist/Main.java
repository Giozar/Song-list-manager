/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package songlist;
import songlist.model.adapters.file.FileSongRepository;
import songlist.model.entities.Song;
import songlist.controller.SongController;
import songlist.model.usecases.AddSongUseCase;
import songlist.model.usecases.ListSongsUseCase;
import songlist.model.usecases.RemoveSongUseCase;
import songlist.view.SongView;

import javax.swing.*;
/**
 *
 * @author giova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(() -> {
            FileSongRepository repository = new FileSongRepository("src/resources/songs.txt");
            AddSongUseCase addSongUseCase = new AddSongUseCase(repository);
            ListSongsUseCase listSongsUseCase = new ListSongsUseCase(repository);
            RemoveSongUseCase removeSongUseCase = new RemoveSongUseCase(repository);
            SongView view = new SongView();
            new SongController(view, addSongUseCase, removeSongUseCase, listSongsUseCase);
            view.setVisible(true);
        });
    }
    
}
