package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
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
import javax.swing.UIManager;

public class Window extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JTable tableActiv;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textFieldEdit;
    private JTextField textField_1Edit;
    private JTextField textField_2Edit;
    private JTextField textField_3Edit;
    private JTextField textFieldName1;
    private JTextField textFieldName2;
    private int textSize = Integer.parseInt(DataHandler.getElements("TextSize")[0]);
    private int x = Integer.parseInt(DataHandler.getElements("SizeX")[0]);
    private int y = Integer.parseInt(DataHandler.getElements("SizeY")[0]);;
    
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
        setTitle("SaveData v1.2a");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(-7, 0, x, y);
        contentPane = new JPanel();
        contentPane.setBackground(Color.darkGray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        UIManager.put("TabbedPane.selected", Color.decode("#C8DCF0"));
        JTabbedPane overTabPane = new JTabbedPane(JTabbedPane.TOP);
        overTabPane.setBackground(Color.GRAY);
        overTabPane.setFont(new Font("Tahoma", Font.BOLD, textSize));
        contentPane.add(overTabPane, BorderLayout.CENTER);
        JPanel dataPanel = new JPanel();
        dataPanel.setBackground(Color.decode("#C8DCF0"));
        JPanel maniPanel = new JPanel();
        maniPanel.setBackground(Color.decode("#C8DCF0"));
        overTabPane.addTab("Show Data", null, dataPanel, null);
        overTabPane.addTab("Manipulate Data", null, maniPanel, null);
        dataPanel.setLayout(new BorderLayout(0, 0));
        maniPanel.setLayout(new BorderLayout(0, 0));
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(Color.GRAY);
        tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        dataPanel.add(tabbedPane);
        JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane2.setBackground(Color.GRAY);
        tabbedPane2.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        maniPanel.add(tabbedPane2);
        
        // Game Tab
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Games", null, panel, null);
        panel.setLayout(new BorderLayout(0, 0));
        
        GameTable gameTable = new GameTable();
        table = new JTable(gameTable);
        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        table.setBackground(Color.decode("#C8DCF0"));
        table.setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        table.getTableHeader().setBackground(Color.DARK_GRAY);
        table.getTableHeader().setForeground(Color.decode("#C8DCF0"));
        table.setRowHeight(textSize + (int)(textSize * 0.2));
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        
        // Series Tab
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Series", null, panel_1, null);
        panel_1.setLayout(new BorderLayout(0, 0));

        SeriesTable seriesTable = new SeriesTable();
        table_1 = new JTable(seriesTable);
        table_1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        table_1.getTableHeader().setBackground(Color.DARK_GRAY);
        table_1.getTableHeader().setForeground(Color.decode("#C8DCF0"));
        table_1.setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        table_1.setBackground(Color.decode("#C8DCF0"));
        table_1.setRowHeight(textSize + (int)(textSize * 0.2));
        
        JScrollPane scrollPane_1 = new JScrollPane(table_1);
        panel_1.add(scrollPane_1);
        
        // Movies Tab
        
        JPanel panel_5 = new JPanel();
        tabbedPane.addTab("Movies", null, panel_5, null);
        panel_5.setLayout(new BorderLayout(0, 0));
        
        MovieTable movieTable = new MovieTable();
        JTable tableMovie = new JTable(movieTable);
        tableMovie.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        tableMovie.getTableHeader().setBackground(Color.DARK_GRAY);
        tableMovie.getTableHeader().setForeground(Color.decode("#C8DCF0"));
        tableMovie.setBackground(Color.decode("#C8DCF0"));
        tableMovie.setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        tableMovie.setRowHeight(textSize + (int)(textSize * 0.2));
        
        JScrollPane scrollPaneMovie = new JScrollPane(tableMovie);
        panel_5.add(scrollPaneMovie, BorderLayout.CENTER);
        
        JPanel panel_5Sub = new JPanel();
        panel_5Sub.setBackground(Color.decode("#C8DCF0"));
        panel_5.add(panel_5Sub, BorderLayout.NORTH);
        
        JLabel lblMoviesSuggested = new JLabel(DataHandler.getMovieSuggestions());
        lblMoviesSuggested.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        panel_5Sub.add(lblMoviesSuggested);
        
        // Activities Tab
        
        JPanel panelActiv = new JPanel();
        tabbedPane.addTab("Activities", null, panelActiv, null);
        panelActiv.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2Activ = new JPanel();
        panelActiv.add(panel_2Activ, BorderLayout.NORTH);
        panel_2Activ.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel panel_1Activ = new JPanel();
        panel_2Activ.add(panel_1Activ);
        panel_1Activ.setLayout(new GridLayout(0, 4, 0, 0));
        
        JComboBox<String> comboBoxActiv = new JComboBox<String>();
        comboBoxActiv.setBackground(Color.DARK_GRAY);
        comboBoxActiv.setForeground(Color.decode("#C8DCF0"));
        comboBoxActiv.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        panel_1Activ.add(comboBoxActiv);
        comboBoxActiv.addItem("All");
        comboBoxActiv.addItem("Pending");
        
        JComboBox<String> comboBox_1Activ = new JComboBox<String>();
        comboBox_1Activ.setBackground(Color.DARK_GRAY);
        comboBox_1Activ.setForeground(Color.decode("#C8DCF0"));
        comboBox_1Activ.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        panel_1Activ.add(comboBox_1Activ);
        comboBox_1Activ.addItem("All");
        comboBox_1Activ.addItem("Home");
        comboBox_1Activ.addItem("Outside");
        comboBox_1Activ.addItem("Outdoor");
        
        JComboBox<String> comboBox_2Activ = new JComboBox<String>();
        comboBox_2Activ.setBackground(Color.DARK_GRAY);
        comboBox_2Activ.setForeground(Color.decode("#C8DCF0"));
        comboBox_2Activ.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        panel_1Activ.add(comboBox_2Activ);
        comboBox_2Activ.addItem("All");
        comboBox_2Activ.addItem("Eating");
        comboBox_2Activ.addItem("Sport");
        comboBox_2Activ.addItem("Trip");
        comboBox_2Activ.addItem("Relaxing");
        comboBox_2Activ.addItem("Other");
        
        JButton btnGetRandom = new JButton("Random");
        btnGetRandom.setBackground(Color.DARK_GRAY);
        btnGetRandom.setForeground(Color.decode("#C8DCF0"));
        btnGetRandom.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        panel_1Activ.add(btnGetRandom);
        
        JPanel panel_3Activ = new JPanel();
        panel_2Activ.add(panel_3Activ);
        panel_3Activ.setBackground(Color.decode("#C8DCF0"));
        
        JLabel lblRandomactivity = new JLabel("RandomActivity");
        lblRandomactivity.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        panel_3Activ.add(lblRandomactivity);
        
        ActivityTable activityTable = new ActivityTable();
        tableActiv = new JTable(activityTable);
        tableActiv.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        tableActiv.getTableHeader().setBackground(Color.DARK_GRAY);
        tableActiv.getTableHeader().setForeground(Color.decode("#C8DCF0"));
        tableActiv.setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize * 0.2)));
        tableActiv.setBackground(Color.decode("#C8DCF0"));
        tableActiv.setRowHeight(textSize + (int)(textSize * 0.2));
        
        JScrollPane scrollPaneActiv = new JScrollPane(tableActiv);
        panelActiv.add(scrollPaneActiv, BorderLayout.CENTER);
        
        // Edit Entry Tab
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.decode("#C8DCF0"));
        tabbedPane2.addTab("Edit Entry", null, panel_2, null);
        
        GridBagLayout gbl_panelEdit = new GridBagLayout();
        gbl_panelEdit.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panelEdit.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelEdit.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panelEdit.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panelEdit);
        
        JLabel labelEdit = new JLabel("  ");
        labelEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_labelEdit = new GridBagConstraints();
        gbc_labelEdit.insets = new Insets(0, 0, 5, 0);
        gbc_labelEdit.gridx = 2;
        gbc_labelEdit.gridy = 1;
        panel_2.add(labelEdit, gbc_labelEdit);
        
        JLabel lblTypeEdit = new JLabel("Type");
        lblTypeEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblEdit = new GridBagConstraints();
        gbc_lblEdit.anchor = GridBagConstraints.WEST;
        gbc_lblEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblEdit.gridx = 0;
        gbc_lblEdit.gridy = 2;
        panel_2.add(lblTypeEdit, gbc_lblEdit);
        
        JComboBox<String> comboBoxEdit = new JComboBox<String>();
        comboBoxEdit.setForeground(Color.decode("#C8DCF0"));
        comboBoxEdit.setBackground(Color.DARK_GRAY);
        comboBoxEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_comboBoxGrid = new GridBagConstraints();
        gbc_comboBoxGrid.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxGrid.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxGrid.gridx = 2;
        gbc_comboBoxGrid.gridy = 2;
        panel_2.add(comboBoxEdit, gbc_comboBoxGrid);
        comboBoxEdit.addItem("Series");
        comboBoxEdit.addItem("Game");
        comboBoxEdit.addItem("Movie");
        comboBoxEdit.addItem("Activity");
        
        JLabel lblNameEdit = new JLabel("Name");
        lblNameEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblNameEdit = new GridBagConstraints();
        gbc_lblNameEdit.anchor = GridBagConstraints.WEST;
        gbc_lblNameEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblNameEdit.gridx = 0;
        gbc_lblNameEdit.gridy = 3;
        panel_2.add(lblNameEdit, gbc_lblNameEdit);
        
        textFieldEdit = new JTextField();
        textFieldEdit.setForeground(Color.decode("#C8DCF0"));
        textFieldEdit.setBackground(Color.DARK_GRAY);
        textFieldEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textFieldEdit = new GridBagConstraints();
        gbc_textFieldEdit.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldEdit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldEdit.gridx = 2;
        gbc_textFieldEdit.gridy = 3;
        panel_2.add(textFieldEdit, gbc_textFieldEdit);
        textFieldEdit.setColumns(10);
        
        JLabel lblPlatformEdit = new JLabel("Platform");
        lblPlatformEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblPlatformEdit = new GridBagConstraints();
        gbc_lblPlatformEdit.anchor = GridBagConstraints.WEST;
        gbc_lblPlatformEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlatformEdit.gridx = 0;
        gbc_lblPlatformEdit.gridy = 4;
        panel_2.add(lblPlatformEdit, gbc_lblPlatformEdit);
        
        textField_1Edit = new JTextField();
        textField_1Edit.setForeground(Color.decode("#C8DCF0"));
        textField_1Edit.setBackground(Color.DARK_GRAY);
        textField_1Edit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField_1Edit = new GridBagConstraints();
        gbc_textField_1Edit.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1Edit.gridx = 2;
        gbc_textField_1Edit.gridy = 4;
        panel_2.add(textField_1Edit, gbc_textField_1Edit);
        textField_1Edit.setColumns(10);
        
        JLabel lblSeasonEdit = new JLabel("Season");
        lblSeasonEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblSeasonEdit = new GridBagConstraints();
        gbc_lblSeasonEdit.anchor = GridBagConstraints.WEST;
        gbc_lblSeasonEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeasonEdit.gridx = 0;
        gbc_lblSeasonEdit.gridy = 5;
        panel_2.add(lblSeasonEdit, gbc_lblSeasonEdit);
        
        textField_2Edit = new JTextField();
        textField_2Edit.setForeground(Color.decode("#C8DCF0"));
        textField_2Edit.setBackground(Color.DARK_GRAY);
        textField_2Edit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField_2Edit = new GridBagConstraints();
        gbc_textField_2Edit.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2Edit.gridx = 2;
        gbc_textField_2Edit.gridy = 5;
        panel_2.add(textField_2Edit, gbc_textField_2Edit);
        textField_2Edit.setColumns(10);
        
        JLabel lblStatusEdit = new JLabel("Status");
        lblStatusEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblStatusEdit = new GridBagConstraints();
        gbc_lblStatusEdit.anchor = GridBagConstraints.WEST;
        gbc_lblStatusEdit.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatusEdit.gridx = 0;
        gbc_lblStatusEdit.gridy = 6;
        panel_2.add(lblStatusEdit, gbc_lblStatusEdit);
        
        textField_3Edit = new JTextField();
        textField_3Edit.setForeground(Color.decode("#C8DCF0"));
        textField_3Edit.setBackground(Color.DARK_GRAY);
        textField_3Edit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField_3Edit = new GridBagConstraints();
        gbc_textField_3Edit.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3Edit.gridx = 2;
        gbc_textField_3Edit.gridy = 6;
        panel_2.add(textField_3Edit, gbc_textField_3Edit);
        textField_3Edit.setColumns(10);
        
        JComboBox<String> comboBox_1Edit = new JComboBox<String>();
        comboBox_1Edit.setForeground(Color.decode("#C8DCF0"));
        comboBox_1Edit.setBackground(Color.DARK_GRAY);
        comboBox_1Edit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_comboBox_1Edit = new GridBagConstraints();
        gbc_comboBox_1Edit.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox_1Edit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1Edit.gridx = 2;
        gbc_comboBox_1Edit.gridy = 7;
        panel_2.add(comboBox_1Edit, gbc_comboBox_1Edit);
        comboBox_1Edit.addItem("Edit");
        comboBox_1Edit.addItem("Delete");
        
        JButton btnEdit = new JButton("Edit");
        btnEdit.setForeground(Color.decode("#C8DCF0"));
        btnEdit.setBackground(Color.DARK_GRAY);
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_btnEdit = new GridBagConstraints();
        gbc_btnEdit.anchor = GridBagConstraints.NORTH;
        gbc_btnEdit.gridx = 2;
        gbc_btnEdit.gridy = 8;
        panel_2.add(btnEdit, gbc_btnEdit);
        
        JButton btnLoad = new JButton("Load Data");
        btnLoad.setForeground(Color.decode("#C8DCF0"));
        btnLoad.setBackground(Color.DARK_GRAY);
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_btnLoad = new GridBagConstraints();
        gbc_btnLoad.gridx = 0;
        gbc_btnLoad.gridy = 7;
        panel_2.add(btnLoad, gbc_btnLoad);
        
        // Add Entry Tab
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.decode("#C8DCF0"));
        tabbedPane2.addTab("Add Entry", null, panel_3, null);
        
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel);
        
        JLabel label = new JLabel("  ");
        label.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 1;
        panel_3.add(label, gbc_label);
        
        JLabel lblType = new JLabel("Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblType = new GridBagConstraints();
        gbc_lblType.anchor = GridBagConstraints.WEST;
        gbc_lblType.insets = new Insets(0, 0, 5, 5);
        gbc_lblType.gridx = 0;
        gbc_lblType.gridy = 2;
        panel_3.add(lblType, gbc_lblType);
        
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setForeground(Color.decode("#C8DCF0"));
        comboBox.setBackground(Color.DARK_GRAY);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 2;
        panel_3.add(comboBox, gbc_comboBox);
        comboBox.addItem("Series");
        comboBox.addItem("Game");
        comboBox.addItem("Movie");
        comboBox.addItem("Activity");
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 3;
        panel_3.add(lblName, gbc_lblName);
        
        textField = new JTextField();
        textField.setForeground(Color.decode("#C8DCF0"));
        textField.setBackground(Color.DARK_GRAY);
        textField.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 3;
        panel_3.add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblPlatform = new JLabel("Platform");
        lblPlatform.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblPlatform = new GridBagConstraints();
        gbc_lblPlatform.anchor = GridBagConstraints.WEST;
        gbc_lblPlatform.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlatform.gridx = 0;
        gbc_lblPlatform.gridy = 4;
        panel_3.add(lblPlatform, gbc_lblPlatform);
        
        textField_1 = new JTextField();
        textField_1.setForeground(Color.decode("#C8DCF0"));
        textField_1.setBackground(Color.DARK_GRAY);
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 4;
        panel_3.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        JLabel lblSeason = new JLabel("Season");
        lblSeason.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblSeason = new GridBagConstraints();
        gbc_lblSeason.anchor = GridBagConstraints.WEST;
        gbc_lblSeason.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeason.gridx = 0;
        gbc_lblSeason.gridy = 5;
        panel_3.add(lblSeason, gbc_lblSeason);
        
        textField_2 = new JTextField();
        textField_2.setForeground(Color.decode("#C8DCF0"));
        textField_2.setBackground(Color.DARK_GRAY);
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 5;
        panel_3.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.anchor = GridBagConstraints.WEST;
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 0;
        gbc_lblStatus.gridy = 6;
        panel_3.add(lblStatus, gbc_lblStatus);
        
        textField_3 = new JTextField();
        textField_3.setForeground(Color.decode("#C8DCF0"));
        textField_3.setBackground(Color.DARK_GRAY);
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 6;
        panel_3.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(Color.decode("#C8DCF0"));
        btnAdd.setBackground(Color.DARK_GRAY);
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_btnAdd = new GridBagConstraints();
        gbc_btnAdd.gridx = 2;
        gbc_btnAdd.gridy = 7;
        panel_3.add(btnAdd, gbc_btnAdd);
        
        // Filter Tab
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.decode("#C8DCF0"));
        tabbedPane.addTab("Filter", null, panel_4, null);
        GridBagLayout gbl_panelFilter = new GridBagLayout();
        gbl_panelFilter.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panelFilter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelFilter.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panelFilter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_4.setLayout(gbl_panelFilter);
        
        JLabel labelFilter = new JLabel("    ");
        labelFilter.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_labelFilter = new GridBagConstraints();
        gbc_labelFilter.insets = new Insets(0, 0, 5, 5);
        gbc_labelFilter.gridx = 0;
        gbc_labelFilter.gridy = 0;
        panel_4.add(labelFilter, gbc_labelFilter);
        
        JLabel lblShowEntries = new JLabel("Show Entries");
        lblShowEntries.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblShowEntries = new GridBagConstraints();
        gbc_lblShowEntries.anchor = GridBagConstraints.WEST;
        gbc_lblShowEntries.insets = new Insets(0, 0, 5, 5);
        gbc_lblShowEntries.gridx = 0;
        gbc_lblShowEntries.gridy = 1;
        panel_4.add(lblShowEntries, gbc_lblShowEntries);
        
        JLabel lblEmpty = new JLabel("   ");
        lblEmpty.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblEmpty = new GridBagConstraints();
        gbc_lblEmpty.anchor = GridBagConstraints.WEST;
        gbc_lblEmpty.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpty.gridx = 0;
        gbc_lblEmpty.gridy = 2;
        panel_4.add(lblEmpty, gbc_lblEmpty);
        
        JLabel lblOnly = new JLabel("Only Activities:");
        lblOnly.setFont(new Font("Tahoma", Font.BOLD, textSize));
        GridBagConstraints gbc_lblOnly = new GridBagConstraints();
        gbc_lblOnly.anchor = GridBagConstraints.WEST;
        gbc_lblOnly.insets = new Insets(0, 0, 5, 5);
        gbc_lblOnly.gridx = 0;
        gbc_lblOnly.gridy = 3;
        panel_4.add(lblOnly, gbc_lblOnly);
        
        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblLocation = new GridBagConstraints();
        gbc_lblLocation.anchor = GridBagConstraints.WEST;
        gbc_lblLocation.insets = new Insets(0, 0, 5, 5);
        gbc_lblLocation.gridx = 0;
        gbc_lblLocation.gridy = 4;
        panel_4.add(lblLocation, gbc_lblLocation);
        
        JLabel lblCategory = new JLabel("Category");
        lblCategory.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblCategory = new GridBagConstraints();
        gbc_lblCategory.anchor = GridBagConstraints.WEST;
        gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategory.gridx = 0;
        gbc_lblCategory.gridy = 5;
        panel_4.add(lblCategory, gbc_lblCategory);
        
        JComboBox<String> comboBoxFilter = new JComboBox<String>();
        comboBoxFilter.setBackground(Color.DARK_GRAY);
        comboBoxFilter.setForeground(Color.decode("#C8DCF0"));
        comboBoxFilter.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_comboBoxFilter = new GridBagConstraints();
        gbc_comboBoxFilter.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxFilter.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxFilter.gridx = 2;
        gbc_comboBoxFilter.gridy = 1;
        panel_4.add(comboBoxFilter, gbc_comboBoxFilter);
        comboBoxFilter.addItem("All");
        comboBoxFilter.addItem("Pending");
        comboBoxFilter.addItem("Finished");
        
        JComboBox<String> comboBox_1Filter = new JComboBox<String>();
        comboBox_1Filter.setBackground(Color.DARK_GRAY);
        comboBox_1Filter.setForeground(Color.decode("#C8DCF0"));
        comboBox_1Filter.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_comboBox_1Filter = new GridBagConstraints();
        gbc_comboBox_1Filter.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1Filter.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1Filter.gridx = 2;
        gbc_comboBox_1Filter.gridy = 4;
        panel_4.add(comboBox_1Filter, gbc_comboBox_1Filter);
        comboBox_1Filter.addItem("All");
        comboBox_1Filter.addItem("Home");
        comboBox_1Filter.addItem("Outside");
        comboBox_1Filter.addItem("Outdoor");
        
        JComboBox<String> comboBox_2Filter = new JComboBox<String>();
        comboBox_2Filter.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        comboBox_2Filter.setBackground(Color.DARK_GRAY);
        comboBox_2Filter.setForeground(Color.decode("#C8DCF0"));
        GridBagConstraints gbc_comboBox_2Filter = new GridBagConstraints();
        gbc_comboBox_2Filter.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_2Filter.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_2Filter.gridx = 2;
        gbc_comboBox_2Filter.gridy = 5;
        panel_4.add(comboBox_2Filter, gbc_comboBox_2Filter);
        comboBox_2Filter.addItem("All");
        comboBox_2Filter.addItem("Eating");
        comboBox_2Filter.addItem("Sport");
        comboBox_2Filter.addItem("Trip");
        comboBox_2Filter.addItem("Relaxing");
        comboBox_2Filter.addItem("Other");
        
        // Settings Tab
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(Color.decode("#C8DCF0"));
        tabbedPane2.addTab("Settings", null, panel_6, null);
        GridBagLayout gbl_panelSett = new GridBagLayout();
        gbl_panelSett.columnWidths = new int[] {0, 0, 0, 0};
        gbl_panelSett.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelSett.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panelSett.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_6.setLayout(gbl_panelSett);
        
        JLabel labelSett = new JLabel("    ");
        labelSett.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_labelSett = new GridBagConstraints();
        gbc_labelSett.insets = new Insets(0, 0, 5, 5);
        gbc_labelSett.gridx = 0;
        gbc_labelSett.gridy = 0;
        panel_6.add(labelSett, gbc_labelSett);
        
        JLabel lblName1 = new JLabel("Name 1");
        lblName1.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblName1 = new GridBagConstraints();
        gbc_lblName1.anchor = GridBagConstraints.WEST;
        gbc_lblName1.insets = new Insets(0, 0, 5, 5);
        gbc_lblName1.gridx = 0;
        gbc_lblName1.gridy = 1;
        panel_6.add(lblName1, gbc_lblName1);
        
        JLabel lblName2 = new JLabel("Name 2");
        lblName2.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblName2 = new GridBagConstraints();
        gbc_lblName2.anchor = GridBagConstraints.WEST;
        gbc_lblName2.insets = new Insets(0, 0, 5, 5);
        gbc_lblName2.gridx = 0;
        gbc_lblName2.gridy = 2;
        panel_6.add(lblName2, gbc_lblName2);
        
        textFieldName1 = new JTextField();
        textFieldName1.setForeground(Color.decode("#C8DCF0"));
        textFieldName1.setBackground(Color.DARK_GRAY);
        textFieldName1.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textFieldName1 = new GridBagConstraints();
        gbc_textFieldName1.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldName1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldName1.gridx = 2;
        gbc_textFieldName1.gridy = 1;
        panel_6.add(textFieldName1, gbc_textFieldName1);
        textFieldName1.setColumns(10);
        
        textFieldName2 = new JTextField();
        textFieldName2.setForeground(Color.decode("#C8DCF0"));
        textFieldName2.setBackground(Color.DARK_GRAY);
        textFieldName2.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_textFieldName2 = new GridBagConstraints();
        gbc_textFieldName2.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldName2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldName2.gridx = 2;
        gbc_textFieldName2.gridy = 2;
        panel_6.add(textFieldName2, gbc_textFieldName2);
        textFieldName2.setColumns(10);
        
        JButton btnNames = new JButton("Change Names");
        btnNames.setForeground(Color.decode("#C8DCF0"));
        btnNames.setBackground(Color.DARK_GRAY);
        btnNames.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_btnNames = new GridBagConstraints();
        gbc_btnNames.gridx = 2;
        gbc_btnNames.gridy = 3;
        panel_6.add(btnNames, gbc_btnNames);
        
        JLabel lbltextEmpty = new JLabel("   ");
        lbltextEmpty.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lbltextEmpty = new GridBagConstraints();
        gbc_lbltextEmpty.anchor = GridBagConstraints.WEST;
        gbc_lbltextEmpty.insets = new Insets(0, 0, 5, 5);
        gbc_lbltextEmpty.gridx = 2;
        gbc_lbltextEmpty.gridy = 4;
        panel_6.add(lbltextEmpty, gbc_lbltextEmpty);
        
        JLabel lbltextSize = new JLabel("Text Size");
        lbltextSize.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lbltextSize = new GridBagConstraints();
        gbc_lbltextSize.anchor = GridBagConstraints.WEST;
        gbc_lbltextSize.insets = new Insets(0, 0, 5, 5);
        gbc_lbltextSize.gridx = 0;
        gbc_lbltextSize.gridy = 5;
        panel_6.add(lbltextSize, gbc_lbltextSize);
        
        JLabel lblwindowSize = new JLabel("Window Size");
        lblwindowSize.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_lblwindowSize = new GridBagConstraints();
        gbc_lblwindowSize.anchor = GridBagConstraints.WEST;
        gbc_lblwindowSize.insets = new Insets(0, 0, 5, 5);
        gbc_lblwindowSize.gridx = 0;
        gbc_lblwindowSize.gridy = 6;
        panel_6.add(lblwindowSize, gbc_lblwindowSize);
        
        JButton btnSize = new JButton("Save current Windowsize");
        btnSize.setForeground(Color.decode("#C8DCF0"));
        btnSize.setBackground(Color.DARK_GRAY);
        btnSize.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_btnSize = new GridBagConstraints();
        gbc_btnSize.gridx = 2;
        gbc_btnSize.gridy = 6;
        panel_6.add(btnSize, gbc_btnSize);
        
        JComboBox<String> comboBoxText = new JComboBox<String>();
        comboBoxText.setForeground(Color.decode("#C8DCF0"));
        comboBoxText.setBackground(Color.DARK_GRAY);
        comboBoxText.setFont(new Font("Tahoma", Font.PLAIN, textSize));
        GridBagConstraints gbc_comboBoxText = new GridBagConstraints();
        gbc_comboBoxText.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxText.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxText.gridx = 2;
        gbc_comboBoxText.gridy = 5;
        panel_6.add(comboBoxText, gbc_comboBoxText);
        comboBoxText.addItem("Set Textsize");
        comboBoxText.addItem("Small");
        comboBoxText.addItem("Medium");
        comboBoxText.addItem("Large");
        
        JLabel lbltextEmpty2 = new JLabel("   ");
        lbltextEmpty2.setFont(new Font("Tahoma", Font.PLAIN, textSize - (int)(textSize*0.25)));
        GridBagConstraints gbc_lbltextEmpty2 = new GridBagConstraints();
        gbc_lbltextEmpty2.anchor = GridBagConstraints.CENTER;
        gbc_lbltextEmpty2.insets = new Insets(0, 0, 5, 5);
        gbc_lbltextEmpty2.gridx = 2;
        gbc_lbltextEmpty2.gridy = 7;
        panel_6.add(lbltextEmpty2, gbc_lbltextEmpty2);
        
        // ActionListeners
        
        comboBoxText.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(comboBoxText.getSelectedItem().equals("Small")) {
                    textSize = 14;
                    DataHandler.setTextSize(14);
                } else if(comboBoxText.getSelectedItem().equals("Medium")) {
                    textSize = 18;
                    DataHandler.setTextSize(18);
                } else if(comboBoxText.getSelectedItem().equals("Large")) {
                    textSize = 22;
                    DataHandler.setTextSize(22);
                }
                lbltextEmpty2.setText("Restart to apply changes");
            }
        });
        
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Game")) {
                    textField_2.setText("");
                    textField_2.setEnabled(false);
                    lblName.setText("Name");
                    lblPlatform.setText("Platform");
                    lblSeason.setText("Season");
                } else if(comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Movie")) {
                    textField_2.setText("");
                    textField_2.setEnabled(false);
                    lblName.setText("Name");
                    lblPlatform.setText("Suggested");
                    lblSeason.setText("Season");
                } else if (comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Series")) {
                    textField_2.setEnabled(true);
                    lblName.setText("Name");
                    lblPlatform.setText("Platform");
                    lblSeason.setText("Season");
                } else if (comboBox.getItemAt(comboBox.getSelectedIndex()).contentEquals("Activity")) {
                    textField_2.setEnabled(true);
                    lblName.setText("Description");
                    lblPlatform.setText("Location");
                    lblSeason.setText("Category");
                }
            }
        });
        
        comboBoxEdit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Game")) {
                    textField_2Edit.setEnabled(false);
                    lblNameEdit.setText("Name");
                    lblPlatformEdit.setText("Platform");
                    lblSeasonEdit.setText("Season");
                } else if(comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Movie")) {
                    textField_2Edit.setEnabled(false);
                    lblNameEdit.setText("Name");
                    lblPlatformEdit.setText("Suggested");
                    lblSeasonEdit.setText("Season");
                } else if (comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Series")) {
                    if (comboBox_1Edit.getItemAt(comboBox_1Edit.getSelectedIndex()).contentEquals("Edit")) {
                        textField_2Edit.setEnabled(true);
                    }
                    lblNameEdit.setText("Name");
                    lblPlatformEdit.setText("Platform");
                    lblSeasonEdit.setText("Season");
                } else if (comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Activity")) {
                    if (comboBox_1Edit.getItemAt(comboBox_1Edit.getSelectedIndex()).contentEquals("Edit")) {
                        textField_2Edit.setEnabled(true);
                    }
                    lblNameEdit.setText("Description");
                    lblPlatformEdit.setText("Location");
                    lblSeasonEdit.setText("Category");
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
                    if(comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Series") || 
                            comboBoxEdit.getItemAt(comboBoxEdit.getSelectedIndex()).contentEquals("Activity")) {
                        textField_2Edit.setEnabled(true);
                    }
                    textField_3Edit.setEnabled(true);
                    btnEdit.setText("Edit");
                    btnLoad.setVisible(true);
                }
            }
        });
        
        comboBoxFilter.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (comboBoxFilter.getSelectedItem().equals("All")) {
                   gameTable.setFilter(Filter.ALL);
                   seriesTable.setFilter(Filter.ALL);
                   movieTable.setFilter(Filter.ALL);
                   activityTable.setFilter(Filter.ALL);
                } else if (comboBoxFilter.getSelectedItem().equals("Pending")) {
                    gameTable.setFilter(Filter.PENDING);
                    seriesTable.setFilter(Filter.PENDING);
                    movieTable.setFilter(Filter.PENDING);
                    activityTable.setFilter(Filter.PENDING);
                } else if (comboBoxFilter.getSelectedItem().equals("Finished")) {
                    gameTable.setFilter(Filter.FINISHED);
                    seriesTable.setFilter(Filter.FINISHED);
                    movieTable.setFilter(Filter.FINISHED);
                    activityTable.setFilter(Filter.FINISHED);
                }
                gameTable.fireTableDataChanged();
                seriesTable.fireTableDataChanged();
                movieTable.fireTableDataChanged();
                activityTable.fireTableDataChanged();
            }
        });
        
        comboBox_1Filter.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                activityTable.setLocation((String) comboBox_1Filter.getSelectedItem());
                activityTable.fireTableDataChanged();
            }
        });
        
        comboBox_2Filter.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                activityTable.setCategory((String) comboBox_2Filter.getSelectedItem());
                activityTable.fireTableDataChanged();
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
            } else if (type.equals("Activity")) {
                existingNames = DataHandler.getElements("Description");
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
                } else if (type.equals("Activity")) {
                    seasons = textField_2.getText();
                    DataHandler.addActivity(name, platform, seasons, status);
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
                activityTable.fireTableDataChanged();
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
                } else if(comboBoxEdit.getSelectedItem().equals("Activity")) {
                    for( String n : DataHandler.getElements("Description")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.editActivity(textFieldEdit.getText(), textField_1Edit.getText(), textField_2Edit.getText(), textField_3Edit.getText());
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
                } else if(comboBoxEdit.getSelectedItem().equals("Activity")) {
                    for( String n : DataHandler.getElements("Description")) {
                        if ( n.equals(textFieldEdit.getText())) {
                            DataHandler.deleteEntry(textFieldEdit.getText(), "Activity");
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
                activityTable.fireTableDataChanged();
                lblMoviesSuggested.setText(DataHandler.getMovieSuggestions());
            } else {
                labelEdit.setText("Entry does not exist!");
            }
        });
        
        btnSize.addActionListener(e -> {
            Rectangle r = this.getBounds();
            DataHandler.setWindowSize(r.width, r.height);
            lbltextEmpty2.setText("Size saved: X: " + r.width + " , Y: " + r.height);
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
            } else if(comboBoxEdit.getSelectedItem().equals("Activity")) {
                String[] name = DataHandler.getElements("Description");
                for( int i = 0; i < name.length; i++) {
                    if ( name[i].equals(textFieldEdit.getText())) {
                        String[] platform = DataHandler.getElements("Location");
                        textField_1Edit.setText(platform[i]);
                        String[] seasons = DataHandler.getElements("Category");
                        textField_2Edit.setText(seasons[i]);
                        String[] status = DataHandler.getElements("AStatus");
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
        
        btnNames.addActionListener(e -> {
            DataHandler.setNames(textFieldName1.getText(), textFieldName2.getText());
            textFieldName1.setText("");
            textFieldName2.setText("");
            lblMoviesSuggested.setText(DataHandler.getMovieSuggestions());
        });
        
        btnGetRandom.addActionListener(e -> {
            lblRandomactivity.setText(DataHandler.getRandomActivity((String) comboBoxActiv.getSelectedItem(),
                    (String) comboBox_1Activ.getSelectedItem(), (String) comboBox_2Activ.getSelectedItem()));
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
        KeyListener keyNames = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnNames.doClick();
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
        textFieldName1.addKeyListener(keyNames);
        textFieldName2.addKeyListener(keyNames);
    }
}
