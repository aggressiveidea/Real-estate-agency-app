package main.ui;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LandingFrame extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_1_1;
	
	private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_4_1; // Initialize this label

	private JLabel textField;
	private JLabel textField_1;
	private static JTextArea txtrrg;
    private static JLabel lblType;
    private static JLabel lblPrice;
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "aldjia123";
	/**
	 * Create the frame.
	 */
	public LandingFrame() {
		lblNewLabel_4_1 = new JLabel("");
		setTitle("IMMO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LandingFrame.class.getResource("assets\\logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(963, 630);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(115,24,154));
		panel.setBounds(0, 0, 222, 662);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 102, 204));
		panel_1.setBounds(0, -27, 222, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LandingFrame.class.getResource("assets\\FullLogoblack_Transparent_firstpage.png")));
		lblNewLabel.setBounds(10, 31, 165, 129);
		panel_1.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 284, 175, 2);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(41, 356, 175, 2);
		panel.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(41, 219, 175, 2);
		panel.add(separator_1_2);
		
		JButton btnNewButton_1 = new JButton("Agent ");
		btnNewButton_1.setBounds(41, 168, 144, 40);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(115,24,154));
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				AgentFrame frame = new AgentFrame();
				 
				 frame.setVisible(true);
				 
				dispose();
				
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Transaction");
		btnNewButton_1_1.addActionListener(this);
		btnNewButton_1_1.setBounds(24, 232, 175, 40);
		btnNewButton_1_1.setBackground(new Color(115,24,154));
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1.setBorderPainted(false); 
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 Transactionframe transactionframe = new Transactionframe();
				 
				 transactionframe.setVisible(true);
				 
				dispose();
				
			}
		});

		
		btnNewButton_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		
		btnNewButton_1_1_1_1 = new JButton("Log out");
          btnNewButton_1_1_1_1.setForeground(Color.WHITE);
         btnNewButton_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
        btnNewButton_1_1_1_1.setBackground(new Color(115, 24, 154));
		btnNewButton_1_1_1_1.setBounds(41, 539, 144, 40);
       panel.add( btnNewButton_1_1_1_1);
       btnNewButton_1_1_1_1.setContentAreaFilled(false); 
       btnNewButton_1_1_1_1.setBorderPainted(false); 

       
       
       btnNewButton_1_1_1 = new JButton("Profile"); 
       btnNewButton_1_1_1.setBounds(41, 297, 144, 40);
       panel.add(btnNewButton_1_1_1);
       btnNewButton_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
       btnNewButton_1_1_1.setBackground(new Color(115,24,154,130));
       btnNewButton_1_1_1.setForeground(Color.WHITE);
       btnNewButton_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
       btnNewButton_1_1_1.setContentAreaFilled(false); 
       btnNewButton_1_1_1.setBorderPainted(false);

       btnNewButton_1_1_1.addActionListener(this); 
           btnNewButton_1_1_1_1.addActionListener(this);

		txtSearch = new JTextField();
		txtSearch.setForeground(new Color(115, 24, 154));
		txtSearch.setText("Search by price or type or papers...");
		txtSearch.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtSearch.setBounds(360, 76, 305, 30);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Add property ");
		btnNewButton.setForeground(new Color(115, 24, 154));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton.setBounds(271, 124, 132, 30);
		btnNewButton.setBackground(new Color(240,240,240));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 AddpropertyFrame AddpropertyFrame = new AddpropertyFrame();
				AddpropertyFrame.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Home is Where Your Story Begins.");
		lblNewLabel_1.setForeground(new Color(115, 24, 154));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(297, 11, 446, 47);
		contentPane.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(271, 185, 682, 177);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(239, 0, 444, 177);
        panel_2.add(panel_3);
        JLabel lblNewLabel_2 = new JLabel("DESCRIPTION : ");
        lblNewLabel_2.setForeground(new Color(115,24,154));
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(0, 56, 139, 25);
        panel_2.add(lblNewLabel_2);
        
        txtrrg = new JTextArea();
        txtrrg.setForeground(new Color(0, 0, 0));
        txtrrg.setBounds(1, 185, 229, 0);
        txtrrg.setBackground(Color.WHITE);
        panel_2.add(txtrrg);
        txtrrg.setWrapStyleWord(true);
        txtrrg.setDoubleBuffered(true);
        txtrrg.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        txtrrg.setDragEnabled(true);
        txtrrg.setLineWrap(true);
        txtrrg.setFont(new Font("Dialog", Font.PLAIN, 13));
        
        // Adding JScrollPane to the JTextArea
        JScrollPane scrollPane = new JScrollPane(txtrrg);
        scrollPane.setBounds(0, 81, 231, 96);
        panel_2.add(scrollPane);
        
        JLabel lblNewLabel_3 = new JLabel("TYPE :");
        lblNewLabel_3.setForeground(new Color(115,24,154));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(0, 0, 64, 25);
        panel_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("PRICE : ");
        lblNewLabel_3_1.setForeground(new Color(115,24,154));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3_1.setBounds(0, 25, 64, 25);
        panel_2.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(73, 5, 112, 20);
        panel_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("");
        lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1.setBounds(73, 25, 112, 20);
        panel_2.add(lblNewLabel_4_1);
        
        JButton btnNewButton_2 = new JButton("Search");
        btnNewButton_2.setForeground(new Color(115,24,154));
        btnNewButton_2.setBounds(687, 76, 89, 29);
        contentPane.add(btnNewButton_2);
        
	}
	@Override
public void actionPerformed(ActionEvent e) {
    System.out.println("Action Performed in mainpage class");
    if (e.getSource() == btnNewButton_1_1_1_1) {
        
        LoginFrame loginFrame = new LoginFrame();
        
        loginFrame.setVisible(true);
        
        this.dispose();
    }
    
	if (e.getSource() == btnNewButton_1_1_1) {
        
        ProfileFrame profile = new ProfileFrame();
        
        profile.setVisible(true);
        
        this.dispose();
    }
}
/**
 * @param type
 * @param description
 * @param price
 */

public void loadPropertyDetails() {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "aldjia123";
        String sql = "SELECT Typebien, Prixbien, Descbien FROM BienImmobilier";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Parcourir les résultats de la requête
            while (rs.next()) {
                String type = rs.getString("Typebien");
                double price = rs.getDouble("Prixbien");
                String description = rs.getString("Descbien");

                // Insérer les valeurs dans les champs correspondants
                setPropertyDetails(type, description, price);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des détails: " + ex.getMessage());
        }
    }

    public void setPropertyDetails(String type, String description, double price) {
        lblNewLabel_4.setText(type);
        txtrrg.setText(description);
        lblNewLabel_4_1.setText(String.valueOf(price));
    }
	 public static void main(String[] args) {
	        
	        LandingFrame frame = new LandingFrame();
	        frame.setVisible(true);
	    }
		public void setValues(String type, String description, double price) {
			lblNewLabel_4.setText(type);
			txtrrg.setText(description);
			lblNewLabel_4_1.setText(String.valueOf(price));
		}
		
}