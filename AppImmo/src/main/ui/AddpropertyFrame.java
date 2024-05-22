package main.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.DAO.OracleAcc;
import main.DAO.User;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class AddpropertyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton retour;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextArea textArea;
    private JLabel imageLabel;
    private JButton btnBrowse;
    private JTextField textField_2;
    private LandingFrame landingFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddpropertyFrame frame = new AddpropertyFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddpropertyFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(AddpropertyFrame.class.getResource("assets\\logo.png")));
        setTitle("IMMO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 621);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 741, 40);
        contentPane.add(panel);
        panel.setBackground(new Color(115, 24, 154));
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(49, 544, 692, 40);
        contentPane.add(panel_1);
        panel_1.setBackground(new Color(115, 24, 154));

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(740, 0, 43, 584);
        contentPane.add(panel_2);
        panel_2.setBackground(new Color(115, 24, 154));

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBounds(0, 0, 49, 584);
        panel_2_1.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_2_1);
        panel_2_1.setLayout(null);

        retour = new JButton("<");
        retour.setBounds(10, 11, 41, 23);
        panel.add(retour);

        JLabel lblNewLabel = new JLabel("Add property");
        lblNewLabel.setForeground(new Color(115,24,154));
        lblNewLabel.setBounds(291, 51, 197, 40);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Address");
        lblNewLabel_1.setForeground(new Color(115,24,154));
        lblNewLabel_1.setBounds(93, 133, 71, 20);
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Type ");
        lblNewLabel_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1.setBounds(93, 164, 71, 20);
        lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Price");
        lblNewLabel_1_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1.setBounds(93, 195, 71, 20);
        lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Description");
        lblNewLabel_1_1_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1_1.setBounds(93, 399, 89, 20);
        lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Size");
        lblNewLabel_1_1_1_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1_1_1.setBounds(93, 226, 89, 20);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1_1_1_1_1);

        textField = new JTextField();
        textField.setBounds(194, 134, 165, 20);
        textField.setFont(new Font("Dialog", Font.PLAIN, 11));
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(194, 196, 165, 20);
        textField_1.setFont(new Font("Dialog", Font.PLAIN, 11));
        textField_1.setColumns(10);
        contentPane.add(textField_1);

        textField_3 = new JTextField();
        textField_3.setBounds(194, 227, 165, 20);
        textField_3.setFont(new Font("Dialog", Font.PLAIN, 11));
        textField_3.setColumns(10);
        contentPane.add(textField_3);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(96, 430, 328, 64);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setWrapStyleWord(true);
        textArea.setDoubleBuffered(true);
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textArea.setDragEnabled(true);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Dialog", Font.PLAIN, 13));

        JButton btnNewButton = new JButton("ADD");
        btnNewButton.setBackground(Color.BLUE);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(323, 510, 165, 23);
        btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(btnNewButton);

        imageLabel = new JLabel();
        imageLabel.setBounds(423, 119, 225, 187);
        contentPane.add(imageLabel);

        btnBrowse = new JButton("Browse");
        btnBrowse.setBounds(485, 317, 100, 30);
        btnBrowse.setForeground(new Color(115,24,154));
        btnBrowse.setFont(new Font("Dialog", Font.PLAIN, 15));
        contentPane.add(btnBrowse);

        JComboBox comboBox = new JComboBox();
        comboBox.setForeground(new Color(115,24,154));
        comboBox.setBounds(192, 165, 167, 22);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"STUDIO", "F1", "F2 ", "F3", "F4", "F5", "DUPLEXE", "VILLA", "CARCASS", "COMMERCIAL", "BUILDING", "LAND"}));
        contentPane.add(comboBox);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("Price_Min");
        lblNewLabel_1_1_1_2.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_1_1_1_2.setBounds(93, 262, 71, 20);
        contentPane.add(lblNewLabel_1_1_1_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Dialog", Font.PLAIN, 11));
        textField_2.setColumns(10);
        textField_2.setBounds(194, 258, 165, 20);
        contentPane.add(textField_2);

        JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Papers");
        lblNewLabel_1_1_1_2_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_1_1_1_2_1.setBounds(93, 293, 71, 20);
        contentPane.add(lblNewLabel_1_1_1_2_1);

        JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Specifications");
        lblNewLabel_1_1_1_2_2.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_1_1_1_2_2.setBounds(93, 327, 100, 20);
        contentPane.add(lblNewLabel_1_1_1_2_2);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setForeground(new Color(115,24,154));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"NOTARIAL_ACT", "REAL_ESTATE_PROMOTION ", "DECISION", "REAL_ESTATE_BOOKLET", "STAMBED_PAPERS", "INDIVISION_ACT"}));
        comboBox_1.setBounds(194, 289, 165, 22);
        contentPane.add(comboBox_1);

        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setForeground(new Color(115,24,154));
        comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"WATER", "GAS", "ELECTRICITY", "GARAGE", "GARDEN", "FURNISHED"}));
        comboBox_1_1.setBounds(194, 325, 165, 22);
        contentPane.add(comboBox_1_1);

        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    imageLabel.setIcon(scaledIcon);
                }
            }
        });

        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LandingFrame landingFrame = new LandingFrame();
                landingFrame.setVisible(true);
                dispose();
            }
        });

        // Action Listener for ADD button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields and combo boxes
                String address = textField.getText();
                String type = (String) comboBox.getSelectedItem();
                double price = Double.parseDouble(textField_1.getText());
                double size = Double.parseDouble(textField_3.getText());
                String description = textArea.getText();
                double minPrice = Double.parseDouble(textField_2.getText());
                String papers = (String) comboBox_1.getSelectedItem();
                String specifications = (String) comboBox_1_1.getSelectedItem();
                 int proprietaireID = User.idall;

                // Database connection parameters
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String user = OracleAcc.USER;
                String password = OracleAcc.PASS;
            
                // SQL to insert property
                String sql = "INSERT INTO BienImmobilier (IDbien, Typebien, Taillebien, Prixbien, Descbien, AgentID, PropriID, property_papers, p_specifications, Localbien) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";


                int PropriID = 0;
                int AgentID = 0;
            
                try (Connection conn = DriverManager.getConnection(url, user, password);
                     Statement stmt = conn.createStatement()) {
            
                    /* get PropriID
                    ResultSet rs = stmt.executeQuery("SELECT IDPROPR FROM Proprietaire");
                    /*Get PropriID
                    ResultSet rs = stmt.executeQuery("SELECT IDPROPR FROM Proprietaire ");
                    if (rs.next()) {
                        PropriID = rs.getInt(1);
                    } else {
                        throw new SQLException("No PropriID found");
                    }
                    
                    */

                    // Get AgentID
                    ResultSet rs = stmt.executeQuery("SELECT IDAGENT FROM AgentImm ORDER BY DBMS_RANDOM.RANDOM");
                    if (rs.next()) {
                        AgentID = rs.getInt(1);
                    } else {
                        throw new SQLException("No AgentID found");
                    }
            
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error fetching IDs: " + ex.getMessage());
                    return; // Exit the method if there's an error
                }
            
                // Now you can use PropriID and AgentID in your PreparedStatement
                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
                    pstmt.setInt(1, getNextID()); // Assuming this generates a valid ID
                    pstmt.setString(2, type);
                    pstmt.setDouble(3, size);
                    pstmt.setDouble(4, price);
                    pstmt.setString(5, description);
                    pstmt.setInt(6, AgentID); // Set the AgentID
                    pstmt.setInt(7, proprietaireID);  // Set the PropriID
                    pstmt.setString(8, papers);
                    pstmt.setString(9, specifications);
                    pstmt.setString(10,address );

                    // Execute the SQL statement
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Property added successfully!");

                    // Pass the values to the LandingFrame
                    

                    // Navigate to the landing page
                    LandingFrame landingFrame = new LandingFrame();
                    landingFrame.setVisible(true);
                    dispose(); // Close the current frame
            
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error adding property: " + ex.getMessage());
                }
            }
        });
    }

    // Method to generate the next ID for IDbien
    private int getNextID() {
        int minID = 1000000; // le min 
        int maxID = 9999999; // le max
    
        //instance de la class randome so n9drou we generate a random id
        Random random = new Random();
    
        // ^^
        int id = random.nextInt(maxID - minID + 1) + minID;
    
        return id;
    }
}






