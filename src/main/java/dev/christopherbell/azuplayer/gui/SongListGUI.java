package dev.christopherbell.azuplayer.gui;

import dev.christopherbell.azuplayer.actions.MainAction;
import dev.christopherbell.azuplayer.actions.SongListPlaySongAction;
import dev.christopherbell.azuplayer.actions.SongListStopSongAction;
import dev.christopherbell.azuplayer.configs.Constants;
import dev.christopherbell.azuplayer.services.AzuPlayerService;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Objects;

public class SongListGUI {
    private final DefaultTableModel mTableSong;
    private final JTable tableSong;

    public SongListGUI(String pathOfMusicFolder) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        var mainFrame = initMainFrame();

        mTableSong = new DefaultTableModel();
        tableSong = new JTable(mTableSong);

        var sTableSong = new JScrollPane(tableSong);
        sTableSong.setBounds(1, 0, 600, 423);

        var play = new JButton("Play");
        play.setBounds(10, 20, 130, 70);
        play.setEnabled(true);
        play.addActionListener(new SongListPlaySongAction(tableSong));

        var pause = new JButton("Pause");
        pause.setBounds(10, 100, 130, 70);
        pause.setEnabled(true);
        pause.addActionListener(new SongListStopSongAction());

        var panelButtonArea = new JPanel(null);
        panelButtonArea.setBounds(600, 0, 250, 600);
        panelButtonArea.add(play);
        panelButtonArea.add(pause);

        var panelSong = new JPanel(null);
        panelSong.setBounds(0, 0, 600, 450);
        panelSong.add(sTableSong);

        var pane = mainFrame.getContentPane();
        pane.setLayout(null);
        pane.add(panelSong);
        pane.add(panelButtonArea);

        setUpTable();
        populateTable();
    }

    public JFrame initMainFrame() {
        var mainFrame = new JFrame(Constants.APP_TITLE);
        mainFrame.setBounds(250, 0, 750, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        return mainFrame;
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
        mTableSong.setRowCount(25);
    }

    public void populateTable() {
        var i = 0;
        var songList = AzuPlayerService.getSongFiles();
        for (File song : songList) {
            if (Objects.nonNull(song) && song.isFile()) {
                var songFile = Objects.requireNonNullElse(song.getName(), "");
                System.out.println(songFile);
                mTableSong.setValueAt(songFile, i, 0);
                i++;
            }
        }
    }
}
