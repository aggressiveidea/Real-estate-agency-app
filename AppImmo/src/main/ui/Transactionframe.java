package main.ui;

import java.sql.Date;

import java.awt.*;
import java.awt.image.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.DAO.OracleAcc;
import main.DAO.Transaction;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Transactionframe extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton retour;
	
	
	Transaction tran = new Transaction();

	public Transactionframe() {
		setTitle("IMMO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Transactionframe.class.getResource("assets\\logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(963, 630);
        setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 107, 685);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(66, 14, 88));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 63, 252, 634);
		panel_1.setBackground(new Color(115, 24, 154));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppointementFrame frame = new AppointementFrame();
				frame.setVisible(true);
			
				dispose();
			}
		});
		retour = new JButton("<");
        retour.setBounds(10, 10, 45, 45);
        contentPane.add(retour);
        retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 LandingFrame mainpage = new LandingFrame();
				 
				 mainpage.setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton.setBounds(34, 30, 193, 23);
		btnNewButton.setForeground(new Color(115, 24, 154));
		panel_1.add(btnNewButton);
		
		JButton btnRemoveAppointment = new JButton("Remove appointment ");
		btnRemoveAppointment.setBackground(new Color(153, 0, 0));
		btnRemoveAppointment.setForeground(new Color(255, 255, 255));
		btnRemoveAppointment.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnRemoveAppointment.setBounds(34, 90, 193, 23);
		panel_1.add(btnRemoveAppointment);
		
		JButton btnRemoveATransaction = new JButton("Remove a transaction ");
		btnRemoveATransaction.setBackground(new Color(153, 0, 0));
		btnRemoveATransaction.setForeground(Color.WHITE);
		btnRemoveATransaction.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnRemoveATransaction.setBounds(34, 151, 193, 23);
		panel_1.add(btnRemoveATransaction);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1052, 63);
		panel_2.setBackground(new Color(115, 24, 154));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transaction");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel.setBounds(155, 11, 165, 41);
		panel_2.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(137, 50, 193, 2);
		panel_2.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Insert a transaction ");
		lblNewLabel_1.setForeground(new Color(115,24,154));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(515, 85, 252, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Agent_id : ");
		lblNewLabel_2.setForeground(new Color(115,24,154));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(409, 175, 96, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Property_id : ");
		lblNewLabel_2_1.setForeground(new Color(115,24,154));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(409, 222, 96, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Client_id : ");
		lblNewLabel_2_1_1.setForeground(new Color(115,24,154));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(409, 274, 96, 23);
		contentPane.add(lblNewLabel_2_1_1);
		
		/*JLabel lblNewLabel_2_1_2 = new JLabel("Cost  : ");
		lblNewLabel_2_1_2.setForeground(new Color(115,24,154));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(409, 474, 96, 23);
		contentPane.add(lblNewLabel_2_1_2);*/
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Cost : ");
		lblNewLabel_2_1_3.setForeground(new Color(115,24,154));
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_3.setBounds(409, 428, 96, 23);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Type : ");
		lblNewLabel_2_1_4.setForeground(new Color(115,24,154));
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_4.setBounds(409, 378, 96, 23);
		contentPane.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_5 = new JLabel("Owner_id  : ");
		lblNewLabel_2_1_5.setForeground(new Color(115,24,154));
		lblNewLabel_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_5.setBounds(409, 325, 96, 23);
		contentPane.add(lblNewLabel_2_1_5);
		
		textField = new JTextField();
		textField.setBounds(515, 178, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(515, 225, 224, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(515, 277, 224, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(515, 328, 224, 20);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(115,24,154));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rent", "Buy"}));
		comboBox.setBounds(515, 380, 224, 22);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(515, 431, 224, 20);
		contentPane.add(textField_4);
		
		/*textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(515, 477, 224, 20);
		contentPane.add(textField_5);*/
		
		
		JButton btnSave = new JButton("Save ");
		btnSave.setBackground(Color.BLUE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String agentID_t = textField.getText();
				String Property_id_t = textField_1.getText();
				String Client_id_t = textField_2.getText();
				String Owner_id_t = textField_3.getText();
				String Type = comboBox.getSelectedItem().toString();
				String Cost_t = textField_4.getText();
				
				int agentID = Integer.parseInt(agentID_t);
				int Property_id = Integer.parseInt(Property_id_t);
				int Client_id = Integer.parseInt(Client_id_t);
				int Owner_id = Integer.parseInt(Owner_id_t);
				int Cost = Integer.parseInt(Cost_t);

				int IDT = tran.getId();
				Date date = (Date) tran.getSQLDate();

				tran.setAgent_id(agentID);
				tran.setClient_id(Client_id);
				tran.setOwner_id(Owner_id);
				tran.setProperty_id(Property_id);
				tran.setCost(Cost);
				
				if (Type == "Rent")
					tran.settype(1);
				else tran.settype(2);

				String sql = "INSERT INTO Transactions (IDtransaction, Typetrans, Datetans, Cost) VALUES (?,?,?,?)";

				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

					PreparedStatement pstmt = conn.prepareStatement(sql);

					pstmt.setInt(1, IDT);
					pstmt.setString(2, Type);
					pstmt.setDate(3, date);
					//pstmt.setInt(4,Client_id);
					//pstmt.setInt (5,Owner_id);
					//pstmt.setInt (6,agentID);
					pstmt.setInt (4,Cost);

					// Execute query
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Transaction added successfully!");

					try {
						BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    	Graphics2D g2d = image.createGraphics();
                    	getContentPane().paint(g2d);
                    	g2d.dispose();

						JFileChooser fileChooser = new JFileChooser();
                    	int option = fileChooser.showSaveDialog(Transactionframe.this);
                    	if (option == JFileChooser.APPROVE_OPTION) {
                        	File selectedFile = fileChooser.getSelectedFile();
                        
                        	// Save the image to the selected file
                        	ImageIO.write(image, "png", selectedFile);
                   		}
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Failed to save image", "ERROR",JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}

				} catch (Exception ee) {
					ee.printStackTrace();
            		JOptionPane.showMessageDialog(null, "Failed to add transaction", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnSave.setBounds(430, 532, 155, 23);
		contentPane.add(btnSave);
		
		JButton btnGenerateContract = new JButton("Generate Contract ");
		btnGenerateContract.setBackground(new Color(0, 100, 0));
		btnGenerateContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContractFrame frame = new ContractFrame(tran);
				frame.setVisible(true);
				dispose();
			}
		});
		btnGenerateContract.setForeground(new Color(255, 255, 255));
		btnGenerateContract.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnGenerateContract.setBounds(691, 532, 172, 23);
		contentPane.add(btnGenerateContract);
		
	}
	public static void main(String[] args) {
	       
		Transactionframe frame = new Transactionframe();
		frame.setVisible(true);
	}
}