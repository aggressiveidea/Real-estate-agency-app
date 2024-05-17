package main.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.DAO.OracleAcc;
import main.DAO.User;
import main.ui.LoginFrame;

public class InformationsFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField numTelephoneField;
    private JTextField emailField;
    private JButton button;
    private JButton retour;

    public Connection connection;

    public InformationsFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(InformationsFrame.class.getResource("assets\\logo.png")));
        JLabel label = new JLabel();
        label.setText("Registration");
        label.setForeground(new Color(115, 24, 154));
        label.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 35));
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(60, 10, 10, 10));
        label.setBounds(196, -50, 313, 115);

        nomField = new JTextField();
        nomField.setBounds(100, 119, 339, 30);
        prenomField = new JTextField();
        prenomField.setBounds(100, 213, 339, 30);
        numTelephoneField = new JTextField();
        numTelephoneField.setBounds(100, 302, 339, 30);
        emailField = new JTextField();
        emailField.setBounds(100, 390, 339, 30);

        JLabel nomLabel = new JLabel("Name");
        nomLabel.setForeground(Color.white);
        nomLabel.setBounds(100, 78, 200, 30);
        nomLabel.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        JLabel prenomLabel = new JLabel("Surname");
        prenomLabel.setForeground(Color.white);
        prenomLabel.setBounds(100, 160, 200, 30);
        prenomLabel.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        JLabel numTelLabel = new JLabel("Phone number");
        numTelLabel.setForeground(Color.white);
        numTelLabel.setBounds(100, 254, 200, 30);
        numTelLabel.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.white);
        emailLabel.setBounds(100, 343, 200, 30);
        emailLabel.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        button = new JButton("Register");
        button.setForeground(new Color(115, 24, 154));
        button.setFont(new Font("Dialog", Font.PLAIN, 11));
        button.setBounds(262, 500, 343, 30);
        button.addActionListener(this);

        retour = new JButton("<");
        retour.setBounds(10, 10, 45, 45);
        retour.addActionListener(this);

        this.setTitle("IMMO");
        this.setSize(780, 592);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(115, 24, 154));
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);

        getContentPane().add(label);
        getContentPane().add(nomField);
        getContentPane().add(prenomField);
        getContentPane().add(numTelephoneField);
        getContentPane().add(emailField);
        getContentPane().add(nomLabel);
        getContentPane().add(prenomLabel);
        getContentPane().add(numTelLabel);
        getContentPane().add(emailLabel);
        getContentPane().add(button);
        getContentPane().add(retour);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 766, 65);
        getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(467, 98, 289, 275);
        getContentPane().add(panel_1);
        panel_1.setBackground(new Color(115, 24, 154));
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InformationsFrame.class.getResource("assets\\clipart2415206.png")));
        lblNewLabel.setBounds(10, 0, 279, 275);
        panel_1.add(lblNewLabel);

        ImageIcon originalIcon = new ImageIcon(AllusersFrame.class.getResource("assets\\clipart2415206.png"));
        
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        lblNewLabel.setIcon(scaledIcon);
        panel_1.add(lblNewLabel);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String numtel = numTelephoneField.getText();
            String email = emailField.getText();

            try {
                User utilisateur = new User(nom, prenom, email, numtel);
                utilisateur.signup(nom, prenom, numtel, email);  

                nomField.setText("");
                prenomField.setText("");
                numTelephoneField.setText("");
                emailField.setText("");
            
                dispose();
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
                // Afficher la page InformationsFrame
                setVisible(true);
            }
        } else if (e.getSource() == retour) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        InformationsFrame frame = new InformationsFrame();
        frame.setVisible(true);
    }
}

