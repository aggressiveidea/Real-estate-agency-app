package main.ui;

import java.awt.Color;  
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.DAO.OracleAcc;
import main.DAO.User;
import main.DAO.UserSession;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class ProfileFrame extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton retour;
    private JLabel imageLabel;
    private JButton btnBrowse;
    private JTable table;

    public ProfileFrame() {
        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ProfileFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 802, 625);
        this.setSize(963, 630);
        this.setResizable(false);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 107, 593);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(66, 14, 88));

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(106, 63, 292, 530);
        panel_1.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnRemoveAccount = new JButton("Remove account");
        btnRemoveAccount.setBackground(new Color(153, 0, 0));
        btnRemoveAccount.setForeground(new Color(255, 255, 255));
        btnRemoveAccount.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnRemoveAccount.setBounds(23, 496, 185, 23);
        panel_1.add(btnRemoveAccount);
        btnRemoveAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to remove your account?", "Confirm Remove Account",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    User user = new User();
                    user.remove(User.idall); // Using static variable idall
                    dispose(); // Close the frame
                    new LoginFrame().setVisible(true); // Redirect to the login page
                }
            }
        });

        JButton btnEditAccount = new JButton("Edit account");
        btnEditAccount.setBackground(Color.BLUE);
        btnEditAccount.setForeground(new Color(255, 255, 255));
        btnEditAccount.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnEditAccount.setBounds(23, 447, 185, 23);
        panel_1.add(btnEditAccount);
        btnEditAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditaccountFrame editaccount = new EditaccountFrame();
                editaccount.setVisible(true);
                dispose(); // Close the current frame
            }
        });

        // Button to browse and select an image
        btnBrowse = new JButton("Browse");
        btnBrowse.setForeground(new Color(115, 24, 154));
        btnBrowse.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnBrowse.setBounds(65, 164, 100, 30);
        panel_1.add(btnBrowse);

        imageLabel = new JLabel();
        imageLabel.setBounds(23, 11, 185, 135);
        panel_1.add(imageLabel);

        JLabel lblNewLabel_2 = new JLabel("ID : ");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(23, 221, 49, 23);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Username :");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(23, 266, 128, 23);
        panel_1.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("Type : ");
        lblNewLabel_2_2.setForeground(Color.WHITE);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_2.setBounds(23, 309, 100, 37);
        panel_1.add(lblNewLabel_2_2);

        String username = UserSession.getCurrentUsername();
        int userID = 0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
            String sql = "SELECT id FROM login WHERE nomutilisateur = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userID = rs.getInt("id");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        String type = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
            String sql = "SELECT typeuser FROM login WHERE nomutilisateur = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                type = rs.getString("typeuser");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        JLabel lblNewLabel_3 = new JLabel(String.valueOf(userID));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_3.setBounds(82, 225, 152, 22);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel(username);
        lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_1.setBounds(140, 266, 152, 22);
        panel_1.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_2 = new JLabel(type);
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_2.setBounds(105, 312, 152, 30);
        panel_1.add(lblNewLabel_3_2);

        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    imageLabel.setIcon(imageIcon);
                }
            }
        });

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 949, 63);
        panel_2.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("Profile");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblNewLabel.setBounds(155, 11, 165, 41);
        panel_2.add(lblNewLabel);

        retour = new JButton("<");
        retour.setBounds(10, 10, 45, 45);
        panel_2.add(retour);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LandingFrame mainpage = new LandingFrame();
                mainpage.setVisible(true);
                dispose();
            }
        });

        JSeparator separator = new JSeparator();
        separator.setBounds(142, 50, 123, 2);
        panel_2.add(separator);

        JLabel lblNewLabel_1 = new JLabel("Latest interactions");
        lblNewLabel_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(555, 74, 206, 39);
        contentPane.add(lblNewLabel_1);

        table = new JTable();
        table.setBackground(new Color(115, 24, 154, 130));
        table.setBounds(428, 165, 492, 417);
        contentPane.add(table);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(428, 165, 492, 417);
        contentPane.add(scrollPane);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Remove account")) {
            // Handle remove account action here
            System.out.println("Remove account button clicked");
        } else if (e.getActionCommand().equals("Edit account")) {

            EditaccountFrame editaccount = new EditaccountFrame();
            editaccount.setVisible(true);
            this.dispose();
            System.out.println("Edit account button clicked");
        }
        
}
public static void main(String[] args) {
	       
	        ProfileFrame frame = new ProfileFrame();
	        frame.setVisible(true);
	    }
}