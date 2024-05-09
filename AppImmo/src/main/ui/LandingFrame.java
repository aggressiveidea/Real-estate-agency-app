package main.ui;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;

import main.DAO.OracleAcc;
import main.DAO.User;

import javax.swing.JLabel;
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
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.DAO.OracleAcc;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LandingFrame extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_2_1;

	private JLabel textField;
	private JLabel textField_1;
	private JTextField txtType;
    private JTextField txtPrice;
    private JTextField txtOwnerPhoneNumber;
    private JTextField txtOwnerEmail;
    private JTextArea txtDescription;
	private Container panel_2;
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String USER = OracleAcc.USER;
    static final String PASS = OracleAcc.PASS;
	static final String QUERY = "SELECT Typebien, Prixbien, PropriID, Descbien FROM BienImmobilier ORDER BY IDbien DESC FETCH FIRST 1 ROW ONLY";
	/**
	 * Create the frame.
	 */
	public LandingFrame() {
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
				 
				List<User> agents = User.getAgents(); // Appel de la méthode getAgents() depuis la classe LandingFrame
                AgentFrame frame = new AgentFrame(agents); // Passage de la liste d'agents à AgentFrame

				 
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
		panel_2.setBackground(new Color(115,24,154,110));
		panel_2.setBounds(248, 165, 691, 294);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(330, 0, 300, 294);
		panel_3.setBackground(Color.WHITE);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        JLabel lblNewLabel_3 = new JLabel("TYPE :");
        lblNewLabel_3.setBounds(0, 0, 64, 25);
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("PRICE : ");
        lblNewLabel_3_1.setBounds(0, 36, 64, 25);
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_4 = new JLabel("Studio");
        lblNewLabel_4.setBounds(74, 2, 112, 20);
        lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("45000");
        lblNewLabel_4_1.setBounds(74, 38, 112, 20);
        lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4_1);
        
        JButton btnNewButton_2 = new JButton("Search");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setForeground(new Color(115,24,154));
        btnNewButton_2.setBounds(687, 76, 89, 29);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(LandingFrame.class.getResource("assets\\realestate.jpg")));
        lblNewLabel_5.setBounds(0, 0, 300, 291);
        panel_3.add(lblNewLabel_5);
        JLabel lblNewLabel_2 = new JLabel("Description :");
        lblNewLabel_2.setBounds(0, 155, 139, 25);
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Owner's phone number : ");
        lblNewLabel_3_1_1.setBounds(0, 91, 172, 25);
        lblNewLabel_3_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_1_1);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("48375244697");
        lblNewLabel_4_1_1.setBounds(179, 93, 119, 20);
        lblNewLabel_4_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4_1_1);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Owner's email : ");
        lblNewLabel_3_1_1_1.setBounds(0, 124, 162, 25);
        lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_1_1_1);
        
        JLabel lblNewLabel_4_1_2 = new JLabel("albertcamus@gmail.com");
        lblNewLabel_4_1_2.setBounds(114, 124, 184, 20);
        lblNewLabel_4_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4_1_2);
                
                JButton btnNewButton_2_1_1 = new JButton("Remove");
                btnNewButton_2_1_1.setForeground(new Color(115, 24, 154));
                btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
                btnNewButton_2_1_1.setBounds(10, 254, 89, 29);
                panel_2.add(btnNewButton_2_1_1);
                
                JLabel lblNewLabel_3_2 = new JLabel("DA");
                lblNewLabel_3_2.setForeground(Color.WHITE);
                lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
                lblNewLabel_3_2.setBounds(196, 36, 64, 25);
                panel_2.add(lblNewLabel_3_2);
                

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBackground(new Color(115,24,154,100));
                scrollPane.setBounds(0, 179, 306, 56);
               
                panel_2.add(scrollPane);
                
                JLabel lblNewLabel_6 = new JLabel("2 pièces traversant de 55 m² exposé SUD EST situé au 5ᵉ étage sans ascenseur comprenant :\r\n" + //
										"un vaste séjour avec cuisine ouverte, une chambre avec dressing, une salle d'eau avec W.C.\r\n" + //
										"Parfait état. Immeuble ancien, BEL EMPLACEMENT. Copropriété de 90 lots (Pas de procédure\r\n" + //
										"en cours). Charges annuelles : 1640 euros.");
                lblNewLabel_6.setBackground(Color.RED);
                scrollPane.setViewportView(lblNewLabel_6);
                
                JButton btnNewButton_2_1_1_1 = new JButton("Edit");
                btnNewButton_2_1_1_1.setForeground(new Color(115, 24, 154));
                btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
                btnNewButton_2_1_1_1.setBounds(114, 254, 89, 29);
                panel_2.add(btnNewButton_2_1_1_1);
                
                JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Address : ");
                lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
                lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
                lblNewLabel_3_1_1_1_1.setBounds(0, 65, 96, 25);
                panel_2.add(lblNewLabel_3_1_1_1_1);
                
                JLabel lblNewLabel_4_1_3 = new JLabel("SUD EST de france ");
                lblNewLabel_4_1_3.setFont(new Font("Dialog", Font.PLAIN, 15));
                lblNewLabel_4_1_3.setBounds(74, 69, 224, 20);
                panel_2.add(lblNewLabel_4_1_3);

       
        
        
        JButton btnNewButton_2_1 = new JButton("Refresh");
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2_1.setForeground(new Color(115, 24, 154));
        btnNewButton_2_1.setBounds(430, 125, 89, 29);
        contentPane.add(btnNewButton_2_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.setBounds(248, 165, 691, 417);
        contentPane.add(scrollPane_1);
        
	}
	
// similarly for txtPrice, txtOwnerPhoneNumber, txtOwnerEmail, txtDescription

	
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
	if (e.getSource() == btnNewButton_2_1) {
		System.out.println("imchi imchi");
        fetchLatestPropertyDetails();
    }



// Add an ActionListener to the Refresh button



}

  private void fetchLatestPropertyDetails() {
    Connection conn = null;
    java.sql.Statement stmt = null;
    ResultSet rs = null;
    
    try {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(QUERY);

        if (rs.next()) {
            // Fetch data from the result set
            String type = rs.getString("Typebien");
            String price = rs.getString("Prixbien");
            String description = rs.getString("Descbien");
            int propId = rs.getInt("PropriID");
			panel_2.removeAll();
			panel_2.revalidate();
			panel_2.repaint();
            // Fetch owner details
            String ownerPhoneNumber = fetchOwnerPhoneNumber(conn, propId);
            String ownerEmail = fetchOwnerEmail(conn, propId);
             System.out.println("yarabi nkmal lyoum");
            // Create new labels for fetched data
            JLabel typeLabel = new JLabel(type);
            JLabel priceLabel = new JLabel(price);
            JLabel descriptionLabel = new JLabel(description);
            JLabel ownerPhoneNumberLabel = new JLabel(ownerPhoneNumber);
            JLabel ownerEmailLabel = new JLabel(ownerEmail);

            // Position the new labels
            typeLabel.setBounds(74, 2, 112, 20);
            priceLabel.setBounds(74, 38, 112, 20);
            descriptionLabel.setBounds(0, 155, 300, 20);
            ownerPhoneNumberLabel.setBounds(179, 93, 119, 20);
            ownerEmailLabel.setBounds(114, 124, 184, 20);

            // Add the new labels to the panel
            panel_2.add(typeLabel);
            panel_2.add(priceLabel);
            panel_2.add(descriptionLabel);
            panel_2.add(ownerPhoneNumberLabel);
            panel_2.add(ownerEmailLabel);

            // Repaint the panel
            panel_2.revalidate();
            panel_2.repaint();
        }

    } catch (SQLException se) {
        se.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}

private String fetchOwnerPhoneNumber(Connection conn, int propId) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String phoneNumber = "";
    try {
        String query = "SELECT PhoneNumber FROM Proprietaire WHERE IDpropr = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, propId);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            phoneNumber = rs.getString("PhoneNumber");
        }
    } catch (SQLException se) {
        se.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    return phoneNumber;
}

private String fetchOwnerEmail(Connection conn, int propId) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String email = "";
    try {
        String query = "SELECT Email FROM Proprietaire WHERE IDpropr = ?";

        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, propId);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            email = rs.getString("Email");
        }
    } catch (SQLException se) {
        se.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    return email;
}


	public static void main(String[] args) {
	        
	        LandingFrame frame = new LandingFrame();
	        frame.setVisible(true);
	    }
}