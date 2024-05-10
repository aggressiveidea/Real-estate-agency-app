package main.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditaccountFrame extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField numTelephoneField;
    private JTextField emailField;
    private JButton btnEdit;
    private JButton retour;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditaccountFrame frame = new EditaccountFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EditaccountFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(EditaccountFrame.class.getResource("assets\\logo.png")));

        // Initialize content pane
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEditInformations = new JLabel();
        lblEditInformations.setText("Edit informations ");
        lblEditInformations.setForeground(new Color(115, 24, 154));
        lblEditInformations.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 35));
        lblEditInformations.setVerticalAlignment(JLabel.TOP);
        lblEditInformations.setHorizontalAlignment(JLabel.CENTER);
        lblEditInformations.setBorder(BorderFactory.createEmptyBorder(60, 10, 10, 10));
        lblEditInformations.setBounds(196, -50, 313, 115);

        nomField = new JTextField();
        nomField.setBounds(196, 119, 339, 30);
        prenomField = new JTextField();
        prenomField.setBounds(196, 182, 339, 30);
        numTelephoneField = new JTextField();
        numTelephoneField.setBounds(196, 249, 339, 30);
        emailField = new JTextField();
        emailField.setBounds(196, 317, 339, 30);

        JLabel Nom = new JLabel("Name");
        Nom.setForeground(Color.white);
        Nom.setBounds(90, 115, 200, 30);
        Nom.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        JLabel Prenom = new JLabel("Surname");
        Prenom.setForeground(Color.white);
        Prenom.setBounds(70, 178, 200, 30);
        Prenom.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        JLabel NumTel = new JLabel("Phone number");
        NumTel.setForeground(Color.white);
        NumTel.setBounds(33, 245, 200, 30);
        NumTel.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        JLabel Email = new JLabel("Email");
        Email.setForeground(Color.white);
        Email.setBounds(108, 313, 200, 30);
        Email.setFont(new Font("Arial (Corps CS)", Font.PLAIN, 20));

        btnEdit = new JButton("Edit");
        btnEdit.setForeground(new Color(115, 24, 154));
        btnEdit.setFont(new Font("Dialog", Font.BOLD, 11));
        btnEdit.setBounds(196, 396, 343, 30);
        btnEdit.addActionListener(this);

        setTitle("IMMO");
        setSize(656, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(new Color(115, 24, 154));
        setLocationRelativeTo(null);

        getContentPane().add(lblEditInformations);
        getContentPane().add(nomField);
        getContentPane().add(prenomField);
        getContentPane().add(numTelephoneField);
        getContentPane().add(emailField);
        getContentPane().add(Nom);
        getContentPane().add(Prenom);
        getContentPane().add(NumTel);
        getContentPane().add(Email);
        getContentPane().add(btnEdit);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 642, 65);
        panel.setLayout(null);
        getContentPane().add(panel);

        retour = new JButton("<");
        retour.setBounds(21, 11, 45, 45);
        panel.add(retour);
        retour.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retour) {
            ProfileFrame frame = new ProfileFrame();
            frame.setVisible(true);
            dispose(); 
        } else if (e.getSource() == btnEdit) {
            
            String name = nomField.getText();
            String surname = prenomField.getText();
            String phoneNumber = numTelephoneField.getText();
            String email = emailField.getText();
           
        }
    }
}
