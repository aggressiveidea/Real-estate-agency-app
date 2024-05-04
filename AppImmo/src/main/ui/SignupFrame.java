package main.ui;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SignupFrame extends JFrame implements ActionListener {

    private JButton button;
    
    private JTextField textField;
    private JPasswordField textField2;
    private JButton btnNewButton;
    private Connection connection;
    private Statement statement;
    private JPanel panel;
   

    public SignupFrame() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "aldjia123");
            statement = connection.createStatement();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

       

        this.setTitle("IMMO");
        this.setSize(963, 630);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(SignupFrame.class.getResource("assets\\logo.png")));
        getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setBackground(new Color(115, 24, 154,130));
        panel.setBounds(357, 76, 351, 438);
        getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(69, 183, 201, 30);
        panel.add(textField);

        JLabel label3 = new JLabel("Username");
        label3.setBounds(35, 68, 146, 104);
        panel.add(label3);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 17));
        label3.setVerticalAlignment(JLabel.TOP);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));

        JLabel label4 = new JLabel("Password");
        label4.setBounds(56, 149, 103, 113);
        panel.add(label4);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 17));
        label4.setVerticalAlignment(JLabel.TOP);
        label4.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));

        textField2 = new JPasswordField();
        textField2.setBounds(69, 262, 201, 30);
        panel.add(textField2);

        button = new JButton("SIGN UP");
        button.setBounds(69, 348, 201, 30);
        panel.add(button);
        button.setForeground(new Color(115, 24, 154));
        button.setFont(new Font("Dialog", Font.PLAIN, 11));

        JLabel lblNewLabel_1 = new JLabel("You already have an account ?");
        lblNewLabel_1.setBounds(22, 402, 155, 14);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));

        btnNewButton = new JButton("Log in");
        btnNewButton.setBounds(178, 394, 92, 30);
        panel.add(btnNewButton);
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setContentAreaFilled(false); 
        btnNewButton.setBorderPainted(false); // Remove button border
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 LoginFrame LoginFrame = new LoginFrame();
				LoginFrame.setVisible(true);
				dispose();
				
			}
		});

        JLabel label = new JLabel();
        label.setBounds(69, -16, 211, 115);
        panel.add(label);
        label.setText("Sign up");
        label.setForeground(Color.white);
        label.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 35));
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(60, 10, 10, 10));

        JLabel label2 = new JLabel();
        label2.setBounds(47, 11, 267, 115);
        panel.add(label2);
        label2.setText("Hello! let's get started");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));
        
        JLabel lblSignupAs = new JLabel(" signup as : ");
        lblSignupAs.setVerticalAlignment(SwingConstants.TOP);
        lblSignupAs.setForeground(Color.WHITE);
        lblSignupAs.setFont(new Font("Dialog", Font.PLAIN, 17));
        lblSignupAs.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));
        lblSignupAs.setBounds(47, 224, 130, 113);
        panel.add(lblSignupAs);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setForeground(new Color(115, 24, 154));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Owner ", "Client ", "Real estate agent "}));
        comboBox.setBounds(151, 307, 119, 22);
        panel.add(comboBox);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SignupFrame.class.getResource("assets\\sign up bg.jpg")));
        lblNewLabel.setBounds(0, 0, 969, 593);
        getContentPane().add(lblNewLabel);

        

    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String username = textField.getText();
            String password = new String(textField2.getPassword());
            String sql = "INSERT INTO login VALUES('" + username + "','" + password + "')";
            try {
                statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(button, "Successfully registered");
                // Go to the registration page
                //InfoFrame InfoFrame = new InfoFrame();
                //InfoFrame.setVisible(true);
                this.dispose();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(button, "Error occurred while registering");
            }
            textField.setText(""); //hadi bach nfrgho l input feild
            textField2.setText("");
        } 
    }

    public static void main(String[] args) {
       
        SignupFrame frame = new SignupFrame();
    
        frame.setVisible(true);
    }
}