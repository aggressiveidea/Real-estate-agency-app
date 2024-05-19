package main.ui;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import main.DAO.OracleAcc;
import main.DAO.Property;
import main.DAO.Real_estate_agent;
import main.DAO.User;
import main.DAO.Owner;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LandingFrame extends JFrame implements ActionListener{
 
    public Connection connection;
    public Statement statement;

	
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_2_1;
    private JButton btnNewButton_remove;

	private Container panel_2;
    private JPanel scrollPanel;
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
		separator_1.setBounds(24, 283, 175, 2);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(24, 348, 175, 2);
		panel.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(24, 219, 175, 2);
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
       
       JButton btnNewButton_1_1_1_2 = new JButton("Users ");
       btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
            List<User> users = User.getUsersByType(); 
            for (User user : users) {
                System.out.println(user);
            }
       		AllusersFrame frame = new AllusersFrame(users);

            frame.setVisible(true);
            dispose();
       	}
       });
       btnNewButton_1_1_1_2.setForeground(Color.WHITE);
       btnNewButton_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 25));
       btnNewButton_1_1_1_2.setContentAreaFilled(false);
       btnNewButton_1_1_1_2.setBorderPainted(false);
       btnNewButton_1_1_1_2.setBackground(new Color(115, 24, 154, 130));
       btnNewButton_1_1_1_2.setBounds(41, 369, 144, 40);
       panel.add(btnNewButton_1_1_1_2);
       
       JButton btnNewButton_1_1_1_3 = new JButton("Appointments ");
       btnNewButton_1_1_1_3.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		TableFrame frame = new TableFrame();
       		frame.setVisible(true);
       		dispose();
       		
       	}
       });
       btnNewButton_1_1_1_3.setForeground(Color.WHITE);
       btnNewButton_1_1_1_3.setFont(new Font("Dialog", Font.PLAIN, 25));
       btnNewButton_1_1_1_3.setContentAreaFilled(false);
       btnNewButton_1_1_1_3.setBorderPainted(false);
       btnNewButton_1_1_1_3.setBackground(new Color(115, 24, 154, 130));
       btnNewButton_1_1_1_3.setBounds(10, 443, 212, 40);
       panel.add(btnNewButton_1_1_1_3);
       
       JSeparator separator_1_3 = new JSeparator();
       separator_1_3.setBounds(24, 420, 175, 2);
       panel.add(separator_1_3);
       
       JSeparator separator_1_4 = new JSeparator();
       separator_1_4.setBounds(24, 494, 175, 2);
       panel.add(separator_1_4);
   
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
        
		JButton btnNewButton_2_1 = new JButton("Refresh");
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2_1.setForeground(new Color(115, 24, 154));
        btnNewButton_2_1.setBounds(430, 125, 89, 29);
        contentPane.add(btnNewButton_2_1);

		JLabel lblNewLabel_1 = new JLabel("Home is Where Your Story Begins.");
		lblNewLabel_1.setForeground(new Color(115, 24, 154));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(297, 11, 446, 47);
		contentPane.add(lblNewLabel_1);

        JButton btnNewButton_2 = new JButton("Search");
        btnNewButton_2.setBackground(new Color(0, 128, 0));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBounds(687, 76, 89, 29);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 SearchFrame frame = new SearchFrame();
				frame.setVisible(true);
				dispose();
				
			}
		});
        
        
		JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.setBounds(248, 165, 691, 417);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane_1);

        scrollPanel = new JPanel();
        scrollPanel.setPreferredSize(new Dimension(691, 20000));
        scrollPane_1.setViewportView(scrollPanel);
        scrollPanel.setLayout(null);

        List<Property> properties = Property.getProperties();
        int initialY = 15;
        int initialX = 15;

        for (Property property : properties) {
            JPanel propertyPanel = createPropertyPanel(property, initialX, initialY);
            initialY += 350; // Adjust Y position for the next property panel
            scrollPanel.add(propertyPanel);
        }
    }
	
	

private JPanel createPropertyPanel(Property property, int initialX, int initialY) {
    JPanel propertyPanel = new JPanel();
    propertyPanel.setBackground(new Color(181, 150, 202)); 
    propertyPanel.setBorder(BorderFactory.createLineBorder(new Color(153, 102, 204)));
    propertyPanel.setLayout(null);
    propertyPanel.setBounds(initialX, initialY, 650, 330);

    JLabel typeLabel = new JLabel("TYPE: " + property.getPropertyType());
    typeLabel.setBounds(20, 10, 200, 20);
    typeLabel.setForeground(Color.WHITE);
    typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
    propertyPanel.add(typeLabel);

    JLabel priceLabel = new JLabel("PRICE: " + String.valueOf(property.getPrice()));
    priceLabel.setBounds(20, 40, 200, 20);
    priceLabel.setForeground(Color.WHITE);
    priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
    propertyPanel.add(priceLabel);

    JLabel addressLabel = new JLabel("Address: " + property.getAddress());
    addressLabel.setBounds(20, 70, 400, 20);
    addressLabel.setForeground(Color.WHITE);
    addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
    propertyPanel.add(addressLabel);

    JLabel numLabel = new JLabel("Owner's phone number: " + property.getOwnerPhone());
    numLabel.setBounds(20, 100, 300, 20);
    numLabel.setForeground(Color.WHITE);
    numLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
    propertyPanel.add(numLabel);

    JLabel mailLabel = new JLabel("Owner's email: " + property.getOwnerEmail());
    mailLabel.setBounds(20, 130, 300, 20);
    mailLabel.setForeground(Color.WHITE);
    mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
    propertyPanel.add(mailLabel);

    JLabel descriptionLabel = new JLabel("Description: ");
    descriptionLabel.setBounds(20, 160, 400, 20);
    descriptionLabel.setForeground(Color.WHITE);
    descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
    propertyPanel.add(descriptionLabel);

    String propertyDescription = property.getDescription();

    JTextArea descriptionTextArea = new JTextArea(propertyDescription);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setWrapStyleWord(true);
    descriptionTextArea.setEditable(false); 

    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
    scrollPane.setBounds(20, 190, 250, 70); 
    propertyPanel.add(scrollPane);


    // Création d'un JPanel blanc pour afficher l'image
    JPanel imagePanel = new JPanel();
    imagePanel.setBackground(Color.WHITE);
    imagePanel.setBounds(350, 10, 290, 310);
    propertyPanel.add(imagePanel);

    // Création d'un JLabel pour afficher l'icône
    JLabel iconLabel = new JLabel();
    ImageIcon icon = new ImageIcon(LandingFrame.class.getResource("assets//realestate.jpg"));
    iconLabel.setIcon(icon);
    iconLabel.setBounds(0, 0, 290, 300); 
    imagePanel.add(iconLabel);

    JButton btnEdit = new JButton("Favorite");
    btnEdit.setBackground(Color.BLUE);
    btnEdit.setForeground(Color.WHITE);
    btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnEdit.setBounds(155, 280, 89, 29);
    propertyPanel.add(btnEdit);

    

    JButton btnRemove = new JButton("Remove");
    btnRemove.setBackground(Color.RED);
    btnRemove.setForeground(Color.WHITE);
    btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnRemove.setBounds(30, 280, 89, 29);
    propertyPanel.add(btnRemove);
    
    btnRemove.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String typeString = User.getType();
            System.out.println(typeString);
            if (typeString.equals("CLIENT")) {
                 //hna zidddddiii marrrroooo
            }
                
            else {
                
                if(typeString.equals("REAL_ESTATE_AGENT")){
                    
                    int propertyId = property.getId(); 
                    boolean success = Real_estate_agent.remove_property(propertyId); 

                    if (success) {
                    
                    scrollPanel.remove(propertyPanel);
                    scrollPanel.revalidate();
                    scrollPanel.repaint();

                   
                    dispose();
                    LandingFrame newLandingFrame = new LandingFrame();
                    newLandingFrame.setVisible(true);
                    }
                }
                else{
                    
                    int propertyId = property.getId(); 
                    boolean success = Owner.remove_property(propertyId); 

                    if (success) {
                    
                    scrollPanel.remove(propertyPanel);
                    scrollPanel.revalidate();
                    scrollPanel.repaint();

                   
                    dispose();
                    LandingFrame newLandingFrame = new LandingFrame();
                    newLandingFrame.setVisible(true);
                    }

                }
                 
                
            }
            
        }
    }
    );

    return propertyPanel;
}

private void removeProperty(int propertyId) {
    System.out.println(propertyId);
    try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS)) {
        if (connection != null) {
            try {
                String query = "DELETE FROM BienImmobilier WHERE IDbien = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, propertyId);
                preparedStatement.executeUpdate();

                // Fermer l'ancienne fenêtre avant d'ouvrir une nouvelle instance
                this.dispose();

                LandingFrame L = new LandingFrame();
                L.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database connection is not established.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
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
	if (e.getSource() == btnNewButton_2_1) {
		System.out.println("imchi imchi");
        fetchLatestPropertyDetails();
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

	public static void main(String[] args) {
	        
	        LandingFrame frame = new LandingFrame();
	        frame.setVisible(true);
	    }
}