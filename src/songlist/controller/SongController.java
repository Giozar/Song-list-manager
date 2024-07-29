/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.controller;


import songlist.model.entities.Song;

import songlist.model.usecases.AddSongUseCase;
import songlist.model.usecases.ListSongsUseCase;
import songlist.model.usecases.RemoveSongUseCase;

import songlist.view.SongView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author giova
 */
public class SongController {
    private SongView view;
    private AddSongUseCase addSongUseCase;
    private RemoveSongUseCase removeSongUseCase;
    private ListSongsUseCase listSongsUseCase;

    public SongController(SongView view, AddSongUseCase addSongUseCase, RemoveSongUseCase removeSongUseCase, ListSongsUseCase listSongsUseCase) {
        this.view = view;
        this.addSongUseCase = addSongUseCase;
        this.removeSongUseCase = removeSongUseCase;
        this.listSongsUseCase = listSongsUseCase;

        this.view.addAddSongListener(new AddSongListener());
        this.view.addRemoveSelectedListener(new RemoveSelectedListener());
        loadSongs();
    }

    private void loadSongs() {
        List<Song> songs = listSongsUseCase.execute();
        view.displaySongs(songs);
    }

    class AddSongListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String songName = view.getSongName();
            if (!songName.isEmpty()) {
                String id = UUID.randomUUID().toString();
                Song song = new Song(id, songName);
                addSongUseCase.execute(song);
                view.addSongToList(song);
            } else {
                JOptionPane.showMessageDialog(view, "El nombre de la canción no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class RemoveSelectedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Song selectedSong = view.getSelectedSong();
            if (selectedSong != null) {
                removeSongUseCase.execute(selectedSong.getId());
                view.removeSongFromList(selectedSong);
            } else {
                JOptionPane.showMessageDialog(view, "Seleccione una canción para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}