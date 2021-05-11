package dev.christopherbell.azuplayer.gui;

import dev.christopherbell.azuplayer.models.Song;

import javax.media.NoPlayerException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI {
    JFrame mainFrame;
    Container pane;
    DefaultTableModel mTableSong;
    JScrollPane sTableSong;
    JPanel panelSong;
    JPanel panelButtonArea;
    JTable tableSong;
    JButton play;
    JButton pause;

    Song song;
    String musicFolderPath;
    boolean isSongPlaying;


    public GUI(String pathOfMusicFolder) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        mainFrame = new JFrame("BellPlayer");
        mainFrame.setBounds(250, 0, 750, 450);
        pane = mainFrame.getContentPane();
        pane.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mTableSong = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        tableSong = new JTable(mTableSong);
        sTableSong = new JScrollPane(tableSong);
        panelSong = new JPanel(null);
        panelButtonArea = new JPanel(null);
        play = new JButton("Play");
        pause = new JButton("Pause");


        pane.add(panelButtonArea);
        panelButtonArea.add(play);
        panelButtonArea.add(pause);

        pane.add(panelSong);
        panelSong.add(sTableSong);

        panelSong.setBounds(0, 0, 600, 450);
        sTableSong.setBounds(1, 0, 600, 423);
        panelButtonArea.setBounds(600, 0, 250, 600);
        play.setBounds(10, 20, 130, 70);
        pause.setBounds(10, 100, 130, 70);

        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        play.setEnabled(true);
        pause.setEnabled(true);

        song = new Song(pathOfMusicFolder);

        isSongPlaying = false;


        setUpTable();
        populateTable();


        play.addActionListener(new buttonPlay());
        pause.addActionListener(new buttonStop());

    }

    public void setUpTable() {
        String[] colTitles = {"Songs"};
        for (int i = 0; i < 1; i++) {
            mTableSong.addColumn(colTitles[i]);
        }

        tableSong.getTableHeader().setResizingAllowed(false);
        tableSong.getTableHeader().setReorderingAllowed(false);
        tableSong.setColumnSelectionAllowed(true);
        tableSong.setRowSelectionAllowed(true);
        tableSong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableSong.setRowHeight(25);
        mTableSong.setColumnCount(1);
        mTableSong.setRowCount(song.getNumberOfSongs());
    }

    public void populateTable() {

        String path = song.getMusicFolderPath();
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (files.endsWith(".wav") || files.endsWith(".WAV")) {
                    System.out.println(files);
                    //String[] songs = files.split(".");
                    if (files != null) {
                        mTableSong.setValueAt(files, i, 0);
                    }
                }
            }
        }
    }

    class buttonPlay implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRowIndex = tableSong.getSelectedRow();
            int selectedColumnIndex = tableSong.getSelectedColumn();
            String selectedObject = (String) tableSong.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
            song.setSongPath(selectedObject);

            try {
                System.out.println(song.songPath);
                if (isSongPlaying == false) {
                    song.play();
                    isSongPlaying = true;
                }
            } catch (NoPlayerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class buttonStop implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (isSongPlaying) {
                song.stop();
                isSongPlaying = false;
            }
            System.out.println(song.getSongPath());
        }
    }
}
