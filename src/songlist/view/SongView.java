/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songlist.view;

import songlist.model.entities.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author giova
 */
public class SongView extends JFrame {
    private DefaultListModel<Song> songListModel;
    private JList<Song> songList;
    private JTextField songNameField;
    private JButton addSongButton;
    private JButton removeSelectedButton;

    public SongView() {
        setTitle("Lista de Canciones Favoritas");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        songListModel = new DefaultListModel<>();
        songList = new JList<>(songListModel);
        songList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        songNameField = new JTextField(20);
        addSongButton = new JButton("Agregar Canción");
        removeSelectedButton = new JButton("Eliminar Seleccionada");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(songList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nombre de la Canción:"));
        inputPanel.add(songNameField);
        inputPanel.add(addSongButton);
        inputPanel.add(removeSelectedButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public String getSongName() {
        return songNameField.getText();
    }

    public void addAddSongListener(ActionListener listener) {
        addSongButton.addActionListener(listener);
    }

    public void addRemoveSelectedListener(ActionListener listener) {
        removeSelectedButton.addActionListener(listener);
    }

    public void displaySongs(List<Song> songs) {
        songListModel.clear();
        for (Song song : songs) {
            songListModel.addElement(song);
        }
    }

    public Song getSelectedSong() {
        return songList.getSelectedValue();
    }

    public void addSongToList(Song song) {
        songListModel.addElement(song);
    }

    public void removeSongFromList(Song song) {
        songListModel.removeElement(song);
    }
}