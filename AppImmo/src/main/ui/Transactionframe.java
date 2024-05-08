package main.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transactionframe extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JButton retour;

	public Transactionframe() {
		setTitle("IMMO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Transactionframe.class.getResource("assets\\logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(963, 630);
        setResizable(false);
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
		panel_1.setBounds(106, 63, 237, 634);
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
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnNewButton.setBounds(34, 30, 147, 23);
		btnNewButton.setForeground(new Color(115, 24, 154));
		panel_1.add(btnNewButton);
		
		JButton btnRemoveAppointment = new JButton("Remove appointment ");
		btnRemoveAppointment.setForeground(new Color(115, 24, 154));
		btnRemoveAppointment.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnRemoveAppointment.setBounds(34, 90, 147, 23);
		panel_1.add(btnRemoveAppointment);
		
		JButton btnRemoveProperty = new JButton("Remove property ");
		btnRemoveProperty.setForeground(new Color(115, 24, 154));
		btnRemoveProperty.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnRemoveProperty.setBounds(34, 144, 147, 23);
		panel_1.add(btnRemoveProperty);
		
		JButton btnRemoveATransaction = new JButton("Remove a transaction ");
		btnRemoveATransaction.setForeground(new Color(115, 24, 154));
		btnRemoveATransaction.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnRemoveATransaction.setBounds(34, 205, 147, 23);
		panel_1.add(btnRemoveATransaction);
		
		JButton btnModifyProperty = new JButton("modify property ");
		btnModifyProperty.setForeground(new Color(115, 24, 154));
		btnModifyProperty.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnModifyProperty.setBounds(34, 263, 147, 23);
		panel_1.add(btnModifyProperty);
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
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Cost  : ");
		lblNewLabel_2_1_2.setForeground(new Color(115,24,154));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(409, 474, 96, 23);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Date : ");
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rent ", "Buy"}));
		comboBox.setBounds(515, 380, 224, 22);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(515, 431, 224, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(515, 477, 224, 20);
		contentPane.add(textField_5);
		
		JButton btnSave = new JButton("Save ");
		btnSave.setForeground(new Color(115, 24, 154));
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnSave.setBounds(430, 532, 147, 23);
		contentPane.add(btnSave);
		
		JButton btnGenerateContract = new JButton("Generate Contract ");
		btnGenerateContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateContract.setForeground(new Color(115, 24, 154));
		btnGenerateContract.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnGenerateContract.setBounds(691, 532, 147, 23);
		contentPane.add(btnGenerateContract);
		
	}
	public static void main(String[] args) {
	       
		Transactionframe frame = new Transactionframe();
		frame.setVisible(true);
	}
}