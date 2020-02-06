package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Window extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textFieldEdit;
    private JTextField textField_1Edit;
    private JTextField textField_2Edit;
    private JTextField textField_3Edit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        DataHandler.read();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window frame = new Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Window() {
        setTitle("SaveData v1.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        // Game Tab
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Games", null, panel, null);
        panel.setLayout(new BorderLayout(0, 0));
        
        GameTable gameTable = new GameTable();
        table = new JTable(gameTable);
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        
        // Series Tab
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Series", null, panel_1, null);
        panel_1.setLayout(new BorderLayout(0, 0));

        SeriesTable seriesTable = new SeriesTable();
        table_1 = new JTable(seriesTable);
        
        JScrollPane scrollPane_1 = new JScrollPane(table_1);
        panel_1.add(scrollPane_1);
        
        // Movies Tab
        
        JPanel panel_5 = new JPanel();
        tabbedPane.addTab("Movies", null, panel_5, null);
        panel_5.setLayout(new BorderLayout(0, 0));
        
        MovieTable movieTable = new MovieTable();
        JTable tableMovie = new JTable(movieTable);
        
        JScrollPane scrollPaneMovie = new JScrollPane(tableMovie);
        panel_5.add(scrollPaneMovie, BorderLayout.CENTER);
        
        JPanel panel_5Sub = new JPanel();
        panel_5.add(panel_5Sub, BorderLayout.NORTH);
        
        JLabel lblMoviesSuggested = new JLabel(DataHandler.getMovieSuggestions());
        lblMoviesSuggested.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_5Sub.add(lblMoviesSuggested);
        
        // Edit Entry Tab
        
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Edit Entry", null, panel_2, null);
        
        GridBagLayout gbl_panelEdit = new GridBagLayout();
        gbl_panelEdit.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panelEdit.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelEdit.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panelEdit.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panelEdit);
        
        JLabel labelEdit = new JLabel("  ");
        labelEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_labelEdit = new GridBagConstraints();
        gbc_labelEdit.insets = new Insets(0, 0, 5, 0);
        gbc_labelEdit.gridx = 2;
        gbc_labelEdit.gridy = 1;
        panel_2.add(labelEdit, gbc_labelEdit);
        
        JLabel lblTypeEdit = new JLabel("Type");
        lblTypeEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblEdit = new GridBagConstraints();
        gbc_lblEdit.anchor = GridBagConstraints.WEST;
        gbc_lblEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblEdit.gridx = 0;
        gbc_lblEdit.gridy = 2;
        panel_2.add(lblTypeEdit, gbc_lblEdit);
        
        JComboBox<String> comboBoxEdit = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxGrid = new GridBagConstraints();
        gbc_comboBoxGrid.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxGrid.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxGrid.gridx = 2;
        gbc_comboBoxGrid.gridy = 2;
        panel_2.add(comboBoxEdit, gbc_comboBoxGrid);
        comboBoxEdit.addItem("Series");
        comboBoxEdit.addItem("Game");
        comboBoxEdit.addItem("Movie");
        
        JLabel lblNameEdit = new JLabel("Name");
        lblNameEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblNameEdit = new GridBagConstraints();
        gbc_lblNameEdit.anchor = GridBagConstraints.WEST;
        gbc_lblNameEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblNameEdit.gridx = 0;
        gbc_lblNameEdit.gridy = 3;
        panel_2.add(lblNameEdit, gbc_lblNameEdit);
        
        textFieldEdit = new JTextField();
        GridBagConstraints gbc_textFieldEdit = new GridBagConstraints();
        gbc_textFieldEdit.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldEdit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldEdit.gridx = 2;
        gbc_textFieldEdit.gridy = 3;
        panel_2.add(textFieldEdit, gbc_textFieldEdit);
        textFieldEdit.setColumns(10);
        
        JLabel lblPlatformEdit = new JLabel("Platform");
        lblPlatformEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblPlatformEdit = new GridBagConstraints();
        gbc_lblPlatformEdit.anchor = GridBagConstraints.WEST;
        gbc_lblPlatformEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlatformEdit.gridx = 0;
        gbc_lblPlatformEdit.gridy = 4;
        panel_2.add(lblPlatformEdit, gbc_lblPlatformEdit);
        
        textField_1Edit = new JTextField();
        GridBagConstraints gbc_textField_1Edit = new GridBagConstraints();
        gbc_textField_1Edit.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1Edit.gridx = 2;
        gbc_textField_1Edit.gridy = 4;
        panel_2.add(textField_1Edit, gbc_textField_1Edit);
        textField_1Edit.setColumns(10);
        
        JLabel lblSeasonEdit = new JLabel("Season");
        lblSeasonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSeasonEdit = new GridBagConstraints();
        gbc_lblSeasonEdit.anchor = GridBagConstraints.WEST;
        gbc_lblSeasonEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeasonEdit.gridx = 0;
        gbc_lblSeasonEdit.gridy = 5;
        panel_2.add(lblSeasonEdit, gbc_lblSeasonEdit);
        
        textField_2Edit = new JTextField();
        GridBagConstraints gbc_textField_2Edit = new GridBagConstraints();
        gbc_textField_2Edit.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2Edit.gridx = 2;
        gbc_textField_2Edit.gridy = 5;
        panel_2.add(textField_2Edit, gbc_textField_2Edit);
        textField_2Edit.setColumns(10);
        
        JLabel lblStatusEdit = new JLabel("Status");
        lblStatusEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblStatusEdit = new GridBagConstraints();
        gbc_lblStatusEdit.anchor = GridBagConstraints.WEST;
        gbc_lblStatusEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatusEdit.gridx = 0;
        gbc_lblStatusEdit.gridy = 6;
        panel_2.add(lblStatusEdit, gbc_lblStatusEdit);
        
        textField_3Edit = new JTextField();
        GridBagConstraints gbc_textField_3Edit = new GridBagConstraints();
        gbc_textField_3Edit.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3Edit.gridx = 2;
        gbc_textField_3Edit.gridy = 6;
        panel_2.add(textField_3Edit, gbc_textField_3Edit);
        textField_3Edit.setColumns(10);
        
        JComboBox<String> comboBox_1Edit = new JComboBox<String>();
        GridBagConstraints gbc_comboBox_1Edit = new GridBagConstraints();
        gbc_comboBox_1Edit.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox_1Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1Edit.gridx = 2;
        gbc_comboBox_1Edit.gridy = 7;
        panel_2.add(comboBox_1Edit, gbc_comboBox_1Edit);
        comboBox_1Edit.addItem("Edit");
        comboBox_1Edit.addItem("Delete");
        
        JButton btnEdit = new JButton("Edit");
        GridBagConstraints gbc_btnEdit = new GridBagConstraints();
        gbc_btnEdit.gridx = 2;
        gbc_btnEdit.gridy = 8;
        panel_2.add(btnEdit, gbc_btnEdit);
        
        JButton btnLoad = new JButton("Load Data");
        GridBagConstraints gbc_btnLoad = new GridBagConstraints();
        gbc_btnLoad.gridx = 0;
        gbc_btnLoad.gridy = 7;
        panel_2.add(btnLoad, gbc_btnLoad);
        
        // Add Entry Tab
        
        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("Add Entry", null, panel_3, null);
        
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel);
        
        JLabel label = new JLabel("  ");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 1;
        panel_3.add(label, gbc_label);
        
        JLabel lblType = new JLabel("Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblType = new GridBagConstraints();
        gbc_lblType.anchor = GridBagConstraints.WEST;
        gbc_lblType.insets = new Insets(0, 0, 5, 5);
        gbc_lblType.gridx = 0;
        gbc_lblType.gridy = 2;
        panel_3.add(lblType, gbc_lblType);
        
        JComboBox<String> comboBox = new JComboBox<String>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 2;
        panel_3.add(comboBox, gbc_comboBox);
        comboBox.addItem("Series");
        comboBox.addItem("Game");
        comboBox.addItem("Movie");
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 3;
        panel_3.add(lblName, gbc_lblName);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 3;
        panel_3.add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblPlatform = new JLabel("Platform");
        lblPlatform.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblPlatform = new GridBagConstraints();
        gbc_lblPlatform.anchor = GridBagConstraints.WEST;
        gbc_lblPlatform.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlatform.gridx = 0;
        gbc_lblPlatform.gridy = 4;
        panel_3.add(lblPlatform, gbc_lblPlatform);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 4;
        panel_3.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        JLabel lblSeason = new JLabel("Season");
        lblSeason.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSeason = new GridBagConstraints();
        gbc_lblSeason.anchor = GridBagConstraints.WEST;
        gbc_lblSeason.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeason.gridx = 0;
        gbc_lblSeason.gridy = 5;
        panel_3.add(lblSeason, gbc_lblSeason);
        
        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 5;
        panel_3.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.anchor = GridBagConstraints.WEST;
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 0;
        gbc_lblStatus.gridy = 6;
        panel_3.add(lblStatus, gbc_lblStatus);
        
        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 6;
        panel_3.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        GridBagConstraints gbc_btnAdd = new GridBagConstraints();
        gbc_btnAdd.gridx = 2;
        gbc_btnAdd.gridy = 7;
        panel_3.add(btnAdd, gbc_btnAdd);
        
        // Settings Tab
        
        JPanel panel_4 = new JPanel();
        tabbedPane.addTab("Settings", null, panel_4, null);
        GridBagLayout gbl_panelSett = new GridBagLayout();
        gbl_panelSett.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panelSett.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelSett.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panelSett.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_4.setLayout(gbl_panelSett);
        
        JLabel labelSett = new JLabel("    ");
        GridBagConstraints gbc_labelSett = new GridBagConstraints();
        gbc_labelSett.insets = new Insets(0, 0, 5, 5);
        gbc_labelSett.gridx = 0;
        gbc_labelSett.gridy = 0;
        panel_4.add(labelSett, gbc_labelSett);
        
        JLabel lblShowEntries = new JLabel("Show Entries");
        lblShowEntries.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblShowEntries = new GridBagConstraints();
        gbc_lblShowEntries.anchor = GridBagConstraints.WEST;
        gbc_lblShowEntries.insets = new Insets(0, 0, 5, 5);
        gbc_lblShowEntries.gridx = 0;
        gbc_lblShowEntries.gridy = 1;
        panel_4.add(lblShowEntries, gbc_lblShowEntries);
        
        JComboBox<String> comboBoxSett = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxSett = new GridBagConstraints();
        gbc_comboBoxSett.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxSett.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxSett.gridx = 2;
        gbc_comboBoxSett.gridy = 1;
        panel_4.add(comboBoxSett, gbc_comboBoxSett);
        comboBoxSett.addItem("all");
        comboBoxSett.addItem("pending");
        comboBoxSett.addItem("finished");
        
        // ActionListeners
        
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Game")) {
                    textField_2.setText("");
                    textField_2.setEnabled(false);
                    lblPlatform.setText("Platform");
                } else if(comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Movie")) {
                    textField_2.setText("");
                    textField_2.setEnabled(false);
                    lblPlatform.setText("Suggested");
                } else if (comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Series")) {
                    textField_2.setEnabled(true);
                    lblPlatform.setText("Platform");
                }
            }
        });
        
        comboBoxEdit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Game")) {
                    textField_2Edit.setEnabled(false);
                    lblPlatformEdit.setText("Platform");
                } else if(comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Movie")) {
                    textField_2Edit.setEnabled(false);
                    lblPlatformEdit.setText("Suggested");
                } else if (comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Series") 
                        && comboBox_1Edit.getItemAt(comboBox_1Edit.getSelectedIndex()).contentEquals("Edit")) {
                    textField_2Edit.setEnabled(true);
                    lblPlatformEdit.setText("Platform");
                } else if (comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Series")) {
                    lblPlatformEdit.setText("Platform");
                }
            }
        });
        
        comboBox_1Edit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(comboBox_1Edit.getItemAt(comboBox_1Edit.getSelectedIndex()).contentEquals("Delete")) {
                    textField_1Edit.setEnabled(false);
                    textField_2Edit.setEnabled(false);
                    textField_3Edit.setEnabled(false);
                    textField_1Edit.setText("");
                    textField_2Edit.setText("");
                    textField_3Edit.setText("");
                    btnEdit.setText("Delete");
                    btnLoad.setVisible(false);
                } else if (comboBox_1Edit.getItemAt(comboBox_1Edit.getSelectedIndex()).contentEquals("Edit")) {
                    textField_1Edit.setEnabled(true);
                    if(comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Series")) {
                        textField_2Edit.setEnabled(true);
                    }
                    textField_3Edit.setEnabled(true);
                    btnEdit.setText("Edit");
                    btnLoad.setVisible(true);
                }
            }
        });
        
        comboBoxSett.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (comboBoxSett.getSelectedItem().equals("all")) {
                   gameTable.setFilter(Filter.ALL);
                   seriesTable.setFilter(Filter.ALL);
                   movieTable.setFilter(Filter.ALL);
                } else if (comboBoxSett.getSelectedItem().equals("pending")) {
                    gameTable.setFilter(Filter.PENDING);
                    seriesTable.setFilter(Filter.PENDING);
                    movieTable.setFilter(Filter.PENDING);
                } else if (comboBoxSett.getSelectedItem().equals("finished")) {
                    gameTable.setFilter(Filter.FINISHED);
                    seriesTable.setFilter(Filter.FINISHED);
                    movieTable.setFilter(Filter.FINISHED);
                }
                gameTable.fireTableDataChanged();
                seriesTable.fireTableDataChanged();
                movieTable.fireTableDataChanged();
            }
        });
        
        btnAdd.addActionListener(e -> {
            String type = (String) comboBox.getSelectedItem();
            String name = textField.getText();
            String platform = textField_1.getText();
            String seasons;
            String status = textField_3.getText();
            String[] existingNames;
            boolean exists = false;
            if(type.equals("Game")) {
                existingNames = DataHandler.getElements("GName");
            } else if(type.equals("Movie")) {
                existingNames = DataHandler.getElements("MName");
            } else if (type.equals("Series")) {
                existingNames = DataHandler.getElements("SName");
            } else {
                throw new RuntimeException("Exception while adding an entry");
            }
            for(String n : existingNames) {
                if(name.equals(n)){
                    exists = true;
                }
            }
            if (exists) {
                label.setText("Entry already exists!");
            } else {
                label.setText("    ");
                if (type.equals("Series")) {
                    seasons = textField_2.getText();
                    DataHandler.addSeries(name, platform, seasons, status);
                    DataHandler.saveData();
                } else if (type.equals("Game")) {
                    DataHandler.addGame(name, platform, status);
                    DataHandler.saveData();
                } else if (type.equals("Movie")) {
                    DataHandler.addMovie(name, platform, status);
                    DataHandler.saveData();
                }
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                gameTable.fireTableDataChanged();
                seriesTable.fireTableDataChanged();
                movieTable.fireTableDataChanged();
                lblMoviesSuggested.setText(DataHandler.getMovieSuggestions());
            }
        });
        
        btnEdit.addActionListener(e -> {
            boolean exists = false;
            if(comboBox_1Edit.getSelectedItem().equals("Edit")) {
                if(comboBoxEdit.getSelectedItem().equals("Game")) {
                    for( String n : DataHandler.getElements("GName")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.editGame(textFieldEdit.getText(), textField_1Edit.getText(), textField_3Edit.getText());
                            DataHandler.saveData();
                            exists = true;
                        } 
                    }
                } else if(comboBoxEdit.getSelectedItem().equals("Movie")) {
                    for( String n : DataHandler.getElements("MName")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.editMovie(textFieldEdit.getText(), textField_1Edit.getText(), textField_3Edit.getText());
                            DataHandler.saveData();
                            exists = true;
                        } 
                    }
                } else if(comboBoxEdit.getSelectedItem().equals("Series")) {
                    for( String n : DataHandler.getElements("SName")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.editSeries(textFieldEdit.getText(), textField_1Edit.getText(), textField_2Edit.getText(), textField_3Edit.getText());
                            DataHandler.saveData();
                            exists = true;
                        } 
                    }
                }
            } else if (comboBox_1Edit.getSelectedItem().equals("Delete")) {
                if(comboBoxEdit.getSelectedItem().equals("Game")) {
                    for( String n : DataHandler.getElements("GName")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.deleteEntry(textFieldEdit.getText(), "Game");
                            DataHandler.saveData();
                            exists = true;
                        } 
                    }
                } else if(comboBoxEdit.getSelectedItem().equals("Movie")) {
                    for( String n : DataHandler.getElements("MName")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.deleteEntry(textFieldEdit.getText(), "Movie");
                            DataHandler.saveData();
                            exists = true;
                        } 
                    }
                } else if(comboBoxEdit.getSelectedItem().equals("Series")) {
                    for( String n : DataHandler.getElements("SName")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.deleteEntry(textFieldEdit.getText(), "Series");
                            DataHandler.saveData();
                            exists = true;
                        } 
                    }
                }
            }
            if(exists) {
                labelEdit.setText("    ");
                textFieldEdit.setText("");
                textField_1Edit.setText("");
                textField_2Edit.setText("");
                textField_3Edit.setText("");
                gameTable.fireTableDataChanged();
                seriesTable.fireTableDataChanged();
                movieTable.fireTableDataChanged();
                lblMoviesSuggested.setText(DataHandler.getMovieSuggestions());
            } else {
                labelEdit.setText("Entry does not exist!");
            }
        });
        
        btnLoad.addActionListener(e -> {
            boolean exists = false;
            if(comboBoxEdit.getSelectedItem().equals("Game")) {
                String[] name = DataHandler.getElements("GName");
                for( int i = 0; i < name.length; i++) {
                    if ( name[i].equals(textFieldEdit.getText())) {
                        String[] platform = DataHandler.getElements("GPlatform");
                        textField_1Edit.setText(platform[i]);
                        String[] status = DataHandler.getElements("GStatus");
                        textField_3Edit.setText(status[i]);
                        exists = true;
                    } 
                }
            } else if(comboBoxEdit.getSelectedItem().equals("Movie")) {
                String[] name = DataHandler.getElements("MName");
                for( int i = 0; i < name.length; i++) {
                    if ( name[i].equals(textFieldEdit.getText())) {
                        String[] platform = DataHandler.getElements("Suggested");
                        textField_1Edit.setText(platform[i]);
                        String[] status = DataHandler.getElements("MStatus");
                        textField_3Edit.setText(status[i]);
                        exists = true;
                    } 
                }
            } else if(comboBoxEdit.getSelectedItem().equals("Series")) {
                String[] name = DataHandler.getElements("SName");
                for( int i = 0; i < name.length; i++) {
                    if ( name[i].equals(textFieldEdit.getText())) {
                        String[] platform = DataHandler.getElements("SPlatform");
                        textField_1Edit.setText(platform[i]);
                        String[] seasons = DataHandler.getElements("Seasons");
                        textField_2Edit.setText(seasons[i]);
                        String[] status = DataHandler.getElements("SStatus");
                        textField_3Edit.setText(status[i]);
                        exists = true;
                    } 
                }
            }
            if(exists) {
                labelEdit.setText("    ");
            } else {
                labelEdit.setText("Entry does not exist!");
            }
        });
        
        // KeyListeners
        
        KeyListener keyAdd = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnAdd.doClick();
                }
            }
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
        };
        KeyListener keyEdit = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnEdit.doClick();
                }
            }
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
        };
        textField.addKeyListener(keyAdd);
        textField_1.addKeyListener(keyAdd);
        textField_2.addKeyListener(keyAdd);
        textField_3.addKeyListener(keyAdd);
        textFieldEdit.addKeyListener(keyEdit);
        textField_1Edit.addKeyListener(keyEdit);
        textField_2Edit.addKeyListener(keyEdit);
        textField_3Edit.addKeyListener(keyEdit);
    }

}
