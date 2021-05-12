package dev.christopherbell.azuplayer.gui;

import dev.christopherbell.azuplayer.models.Song;
import javax.media.NoPlayerException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SongListGUI {
    private final DefaultTableModel mTableSong;
    private final JTable tableSong;
    private final Song song;
    private boolean isSongPlaying;

    public SongListGUI(String pathOfMusicFolder) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame("BellPlayer");
        mainFrame.setBounds(250, 0, 750, 450);
        Container pane = mainFrame.getContentPane();
        pane.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mTableSong = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        tableSong = new JTable(mTableSong);
        JScrollPane sTableSong = new JScrollPane(tableSong);
        JPanel panelSong = new JPanel(null);
        JPanel panelButtonArea = new JPanel(null);
        JButton play = new JButton("Play");
        JButton pause = new JButton("Pause");


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
        File folder = new File(song.getMusicFolderPath());
        int i = 0;
        var filesList = Objects.requireNonNullElse(folder.listFiles(), new File[1]);
        for (File item: filesList) {
            if (Objects.nonNull(item) && item.isFile()) {
                var songFile = Objects.requireNonNullElse(item.getName(), "");
                System.out.println(songFile);
                mTableSong.setValueAt(songFile, i, 0);
                i++;
            }
        }
    }

    class buttonPlay implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRowIndex = tableSong.getSelectedRow();
            int selectedColumnIndex = tableSong.getSelectedColumn();
            String selectedObject = (String) tableSong.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
            song.setCurrentSongPath(selectedObject);

            try {
                System.out.println(song.getCurrentSongPath());
                if (!isSongPlaying) {
                    song.play();
                    isSongPlaying = true;
                }
            } catch (NoPlayerException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class buttonStop implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (isSongPlaying) {
                song.stop();
                isSongPlaying = false;
            }
            System.out.println(song.getCurrentSongPath());
        }
    }
}
