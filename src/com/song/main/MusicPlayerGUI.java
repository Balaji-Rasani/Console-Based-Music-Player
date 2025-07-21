package com.song.main;

import com.song.model.Song;
import com.song.service.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicPlayerGUI extends JFrame {

    private MusicPlayer player;

    private JTextField txtId, txtTitle, txtArtist, txtDuration;
    private JTextArea outputArea;

    public MusicPlayerGUI() {
        player = new MusicPlayer();

        setTitle("Music Player");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ========== Input Panel ==========
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Song Details"));

        txtId = new JTextField();
        txtTitle = new JTextField();
        txtArtist = new JTextField();
        txtDuration = new JTextField();

        inputPanel.add(new JLabel("Song ID:"));
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(txtTitle);
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(txtArtist);
        inputPanel.add(new JLabel("Duration (mins):"));
        inputPanel.add(txtDuration);

        JButton addBtn = new JButton("Add Song");
        addBtn.addActionListener(e -> addSong());

        JButton displayBtn = new JButton("Display Songs");
        displayBtn.addActionListener(e -> displaySongs());

        inputPanel.add(addBtn);
        inputPanel.add(displayBtn);

        // ========== Output Area ==========
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addSong() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String title = txtTitle.getText();
            String artist = txtArtist.getText();
            double duration = Double.parseDouble(txtDuration.getText());

            Song song = new Song(id, title, artist, duration);
            player.addSong(song);
            outputArea.append("Added: " + song.getTitle() + "\n");

            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySongs() {
        outputArea.setText("");
        if (player.getAllSongs().isEmpty()) {
            outputArea.setText("No songs available.\n");
        } else {
            for (Song song : player.getAllSongs()) {
                outputArea.append(song.toString() + "\n");
            }
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtTitle.setText("");
        txtArtist.setText("");
        txtDuration.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicPlayerGUI gui = new MusicPlayerGUI();
            gui.setVisible(true);
        });
    }
}
