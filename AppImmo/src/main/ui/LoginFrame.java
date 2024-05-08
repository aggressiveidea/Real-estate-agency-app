package main.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import main.DAO.User;

public class LoginFrame extends JFrame {
    private JButton button;
    private JTextField textField;
    private JPasswordField textField2;
    private JButton btnNewButton;
    private Connection connection;
    private Statement statement;
    private JPanel panel;

    public LoginFrame() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "8888");
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
        panel.setBackground(new Color(115, 24, 154, 130));
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

        button = new JButton("LOGIN");
        button.setBounds(69, 335, 201, 30);
        panel.add(button);
        button.setForeground(new Color(115, 24, 154));
        button.setFont(new Font("Dialog", Font.PLAIN, 11));

        JLabel lblNewLabel_1 = new JLabel("You don't have an account ?");
        lblNewLabel_1.setBounds(22, 402, 155, 14);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));

        btnNewButton = new JButton("Sign up");
        btnNewButton.setBounds(178, 394, 92, 30);
        panel.add(btnNewButton);
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false); // Remove button border
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignupFrame SignupFrame = new SignupFrame();
                SignupFrame.setVisible(true);
                dispose();
            }
        });

        JLabel lblLogin = new JLabel();
        lblLogin.setBounds(69, -16, 211, 115);
        panel.add(lblLogin);
        lblLogin.setText("Login");
        lblLogin.setForeground(Color.white);
        lblLogin.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 35));
        lblLogin.setVerticalAlignment(JLabel.TOP);
        lblLogin.setHorizontalAlignment(JLabel.CENTER);
        lblLogin.setBorder(BorderFactory.createEmptyBorder(60, 10, 10, 10));

        JLabel label2 = new JLabel();
        label2.setBounds(47, 11, 267, 115);
        panel.add(label2);
        label2.setText("Hello! let's get started");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("assets/login bg.jpg")));
        lblNewLabel.setBounds(0, 0, 969, 593);
        getContentPane().add(lblNewLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(textField2.getPassword());

                if (e.getSource() == button) {
                    User user = new User(username, password);
                    user.login();
                    
                    LandingFrame landing  = new LandingFrame();

                    dispose(); // Ferme la fenêtre de connexion après l'affichage du message
                }
            }
        });
    }

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }
}