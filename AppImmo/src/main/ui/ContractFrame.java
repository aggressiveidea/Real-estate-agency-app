package main.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.DAO.Contract;
import main.DAO.OracleAcc;
import main.DAO.Transaction;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class ContractFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton retour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractFrame frame = new ContractFrame(new Transaction());
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
	public ContractFrame(Transaction tran) {
        
		setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AppointementFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 621);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Contract ");
        lblNewLabel.setForeground(new Color(115,24,154));
        lblNewLabel.setBounds(368, 47, 229, 39);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        contentPane.add(lblNewLabel);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(874, 0, 41, 609);
        panel_1_1.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_1_1);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBackground(new Color(115, 24, 154));
        panel_1_1_1.setBounds(0, 0, 876, 39);
        contentPane.add(panel_1_1_1);
        panel_1_1_1.setLayout(null);
        
        retour = new JButton("<");
        retour.setBounds(10, 11, 41, 23);
        panel_1_1_1.add(retour);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                 Transactionframe transactionframe = new Transactionframe();
                 transactionframe.setVisible(true);
                
                dispose();
            }
        });
        
        JPanel panel_1_1_1_1 = new JPanel();
        panel_1_1_1_1.setBackground(new Color(115, 24, 154));
        panel_1_1_1_1.setBounds(-36, 546, 912, 63);
        contentPane.add(panel_1_1_1_1);
        
        JPanel panel_1_1_2 = new JPanel();
        panel_1_1_2.setBackground(new Color(115, 24, 154));
        panel_1_1_2.setBounds(0, 0, 41, 573);
        contentPane.add(panel_1_1_2);
        
        JLabel lblNewLabel_1_2 = new JLabel("Name : ");
        lblNewLabel_1_2.setForeground(new Color(115,24,154));
        lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(93, 162, 128, 23);
        contentPane.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Surname : ");
        lblNewLabel_1_2_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_1.setBounds(93, 210, 142, 23);
        contentPane.add(lblNewLabel_1_2_1);
        
        JLabel lblNewLabel_1_2_2 = new JLabel("Email : ");
        lblNewLabel_1_2_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_2.setBounds(93, 260, 128, 23);
        contentPane.add(lblNewLabel_1_2_2);
        
        JLabel lblNewLabel_1_2_4 = new JLabel("Phone number : ");
        lblNewLabel_1_2_4.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4.setBounds(93, 316, 163, 23);
        contentPane.add(lblNewLabel_1_2_4);
        
        JLabel lblNewLabel_1_2_5 = new JLabel("Contract type : ");
        lblNewLabel_1_2_5.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_5.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_5.setBounds(93, 388, 150, 23);
        contentPane.add(lblNewLabel_1_2_5);
        
        JLabel lblClient = new JLabel("CLIENT ");
        lblClient.setForeground(new Color(115, 24, 154));
        lblClient.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblClient.setBounds(107, 97, 109, 39);
        contentPane.add(lblClient);
        
        JLabel lblOwner = new JLabel("OWNER ");
        lblOwner.setForeground(new Color(115, 24, 154));
        lblOwner.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblOwner.setBounds(509, 97, 109, 39);
        contentPane.add(lblOwner);
        
        JLabel lblNewLabel_1_2_6 = new JLabel(" Name : ");
        lblNewLabel_1_2_6.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_6.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_6.setBounds(506, 162, 128, 23);
        contentPane.add(lblNewLabel_1_2_6);
        
        JLabel lblNewLabel_1_2_1_1 = new JLabel(" Surname : ");
        lblNewLabel_1_2_1_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_1_1.setBounds(506, 210, 142, 23);
        contentPane.add(lblNewLabel_1_2_1_1);
        
        JLabel lblNewLabel_1_2_2_1 = new JLabel("Email : ");
        lblNewLabel_1_2_2_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_2_1.setBounds(511, 260, 128, 23);
        contentPane.add(lblNewLabel_1_2_2_1);
        
        JLabel lblNewLabel_1_2_4_1 = new JLabel("Phone number : ");
        lblNewLabel_1_2_4_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_1.setBounds(509, 316, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_1);
        
        JLabel lblNewLabel_1_2_4_2 = new JLabel("Duration : ");
        lblNewLabel_1_2_4_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_2.setBounds(93, 434, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_2);
        
        JLabel lblNewLabel_1_2_4_3 = new JLabel("Amount : ");
        lblNewLabel_1_2_4_3.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_3.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_3.setBounds(509, 390, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_3);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(112, 375, 618, 2);
        contentPane.add(separator);

        // ************** DA LOGIC *******************

        Contract cont = tran.generate_contract();

        String clientSurname = "";
        try {
            // Create a Connection object
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

            // Create a PreparedStatement object with SQL query
            String sql = "SELECT prenomClient FROM Client WHERE IDclient = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tran.client_id);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Retrieve client's surname from the ResultSet
            if (rs.next()) {
                clientSurname = rs.getString("prenomClient");
            }

            // Close the ResultSet, PreparedStatement, and Connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
            e.getMessage();
            e.printStackTrace();
        }

        JLabel lblNewLabel_1 = new JLabel(clientSurname);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(181, 164, 203, 22);
        contentPane.add(lblNewLabel_1);

        String clientName = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT NomClient FROM Client WHERE IDclient = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.client_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve client's name from the ResultSet
                if (rs.next()) {
                    clientName = rs.getString("NomClient");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
        JLabel lblNewLabel_1_1 = new JLabel(clientName);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(207, 212, 203, 22);
        contentPane.add(lblNewLabel_1_1);

        String clientemail = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT EmailClient FROM Client WHERE IDclient = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.client_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve client's email from the ResultSet
                if (rs.next()) {
                    clientemail = rs.getString("EmailClient");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
        JLabel lblNewLabel_1_3 = new JLabel(clientemail);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(181, 262, 229, 22);
        contentPane.add(lblNewLabel_1_3);

        String clientnum = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT telephoneClient FROM Client WHERE IDclient = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.client_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve client's number phone from the ResultSet
                if (rs.next()) {
                    clientnum = rs.getString("telephoneClient");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
        JLabel lblNewLabel_1_5 = new JLabel(clientnum);
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_5.setBounds(265, 318, 203, 22);
        contentPane.add(lblNewLabel_1_5);

        String ownersurname = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT Prenompropr FROM Proprietaire WHERE IDpropr = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.owner_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve owner's surname from the ResultSet
                if (rs.next()) {
                    ownersurname = rs.getString("Prenompropr");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
        JLabel lblNewLabel_1_6 = new JLabel(ownersurname);
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_6.setBounds(607, 163, 203, 22);
        contentPane.add(lblNewLabel_1_6);

        String ownername = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT Nompropr FROM Proprietaire WHERE IDpropr = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.owner_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve owner's name from the ResultSet
                if (rs.next()) {
                    ownername = rs.getString("Nompropr");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
        JLabel lblNewLabel_1_7 = new JLabel(ownername);
        lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_7.setBounds(630, 212, 203, 22);
        contentPane.add(lblNewLabel_1_7);
        
        String owneremail = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT Emailpropr FROM Proprietaire WHERE IDpropr = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.owner_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve owner's email from the ResultSet
                if (rs.next()) {
                    owneremail = rs.getString("Emailpropr");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        JLabel lblNewLabel_1_8 = new JLabel(owneremail);
        lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_8.setBounds(607, 261, 203, 22);
        contentPane.add(lblNewLabel_1_8);

        String ownernum = "";
            try {
                // Create a Connection object
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

    
                // Create a PreparedStatement object with SQL query
                String sql = "SELECT telephonepropr FROM Proprietaire WHERE IDpropr = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tran.owner_id);
    
                // Execute the query
                ResultSet rs = pstmt.executeQuery();
    
                // Retrieve owner's number phone from the ResultSet
                if (rs.next()) {
                    ownernum = rs.getString("telephonepropr");
                }
    
                // Close the ResultSet, PreparedStatement, and Connection
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
        JLabel lblNewLabel_1_10 = new JLabel(ownernum);
        lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_10.setBounds(682, 318, 203, 22);
        contentPane.add(lblNewLabel_1_10);

        String type = JOptionPane.showInputDialog("Please write the type of the contract : ");
        
        JLabel lblNewLabel_1_11 = new JLabel(type);
        lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_11.setBounds(252, 390, 203, 22);
        contentPane.add(lblNewLabel_1_11);

        String costString = String.format("%.2f", tran.cost); // Formats the double to 2 decimal places
        
        JLabel lblNewLabel_1_12 = new JLabel(costString);
        lblNewLabel_1_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_12.setBounds(618, 390, 203, 22);
        contentPane.add(lblNewLabel_1_12);
        
        JLabel lblNewLabel_1_13 = new JLabel(cont.duration);
        lblNewLabel_1_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_13.setBounds(221, 436, 203, 22);
        contentPane.add(lblNewLabel_1_13);
        
        JButton btnSave = new JButton("Save");
        btnSave.setForeground(new Color(115,24,154));
        btnSave.setBounds(346, 512, 173, 23);
        contentPane.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
						BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    	Graphics2D g2d = image.createGraphics();
                    	getContentPane().paint(g2d);
                    	g2d.dispose();

						JFileChooser fileChooser = new JFileChooser();
                    	int option = fileChooser.showSaveDialog(ContractFrame.this);
                    	if (option == JFileChooser.APPROVE_OPTION) {
                        	File selectedFile = fileChooser.getSelectedFile();
                        
                        	// Save the image to the selected file
                        	ImageIO.write(image, "png", selectedFile);
                   		}
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Failed to save image", "ERROR",JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
            }
        });
        
        JLabel lblNewLabel_1_2_5_1 = new JLabel("Property Adrress : ");
        lblNewLabel_1_2_5_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_5_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_5_1.setBounds(505, 434, 187, 23);
        contentPane.add(lblNewLabel_1_2_5_1);
        
        JLabel lblNewLabel_1_12_1 = new JLabel("Alger centre ");
        lblNewLabel_1_12_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_12_1.setBounds(682, 436, 187, 23);
        contentPane.add(lblNewLabel_1_12_1);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(new Color(115,24,154));
        separator_1.setBounds(361, 84, 128, 2);
        contentPane.add(separator_1);
       
	}
}
