package main.ui;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;



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

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LandingFrame extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_1_1;
	private JLabel textField;
	private JLabel textField_1;
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
        lblNewLabel_5.setIcon(new ImageIcon(LandingFrame.class.getResource("assets\\real estate.jpg")));
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
        
        JLabel lblNewLabel_4_1_2 = new JLabel("kachbnadem@gmail.com");
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
                
                JLabel lblNewLabel_6 = new JLabel("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
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
                
                JLabel lblNewLabel_4_1_3 = new JLabel("Alger centre");
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
	 public static void main(String[] args) {
	        
	        LandingFrame frame = new LandingFrame();
	        frame.setVisible(true);
	    }
}