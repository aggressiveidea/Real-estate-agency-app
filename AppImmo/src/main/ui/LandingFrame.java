package main.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LandingFrame extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField txtSearch;
    private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_1_1;

    private JTextArea txtrrg;

    public LandingFrame() {
        setTitle("IMMO");
        URL imageURL = ClassLoader.getSystemResource("assets/logo.png");
        if (imageURL != null) {
            setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
        } else {
            System.err.println("Image URL is null. Cannot set icon.");
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(963, 630);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(115, 24, 154));
        panel.setBounds(0, 0, 222, 662);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(153, 102, 204));
        panel_1.setBounds(0, -27, 222, 160);
        panel.add(panel_1);
        panel_1.setLayout(null);

        // Load the image URL
        imageURL = ClassLoader.getSystemResource("assets/FullLogoblack_Transparent_firstpage.png");

        // Check if imageURL is null before creating ImageIcon
        if (imageURL != null) {
            ImageIcon logoIcon = new ImageIcon(imageURL);
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(logoIcon);
            lblNewLabel.setBounds(10, 31, 165, 129);
            panel_1.add(lblNewLabel);
        } else {
            // Handle the case where imageURL is null
            System.err.println("Image URL is null. Cannot create ImageIcon.");
        }

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(41, 284, 175, 2);
        panel.add(separator_1);

        // Other components...
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
        btnNewButton.setBackground(new Color(240, 240, 240));
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Home is Where Your Story Begins.");
        lblNewLabel_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 28));
        lblNewLabel_1.setBounds(297, 11, 446, 47);
        contentPane.add(lblNewLabel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(271, 185, 682, 177);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(0, 0, 682, 177);
        panel_2.add(panel_3);
        JLabel lblNewLabel_2 = new JLabel("DESCRIPTION : ");
        lblNewLabel_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(0, 56, 139, 25);
        panel_2.add(lblNewLabel_2);

        txtrrg = new JTextArea();
        txtrrg.setForeground(new Color(255, 255, 255));
        txtrrg.setBounds(1, 185, 229, 0);
        txtrrg.setBackground(Color.WHITE);
        panel_2.add(txtrrg);
        txtrrg.setWrapStyleWord(true);
        txtrrg.setDoubleBuffered(true);
        txtrrg.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        txtrrg.setDragEnabled(true);
        txtrrg.setLineWrap(true);
        txtrrg.setFont(new Font("Dialog", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(txtrrg);
        scrollPane.setBounds(0, 81, 682, 96);
        panel_2.add(scrollPane);

        JLabel lblNewLabel_3 = new JLabel("TYPE :");
        lblNewLabel_3.setForeground(new Color(115, 24, 154));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(0, 0, 64, 25);
        panel_2.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("PRICE : ");
        lblNewLabel_3_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3_1.setBounds(0, 25, 64, 25);
        panel_2.add(lblNewLabel_3_1);

        JLabel lblNewLabel_4 = new JLabel("");//pour afficher le type
        lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(73, 5, 112, 20);
        panel_2.add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("");//pour afficher le prix
        lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1.setBounds(73, 25, 112, 20);
        panel_2.add(lblNewLabel_4_1);

        JButton btnNewButton_2 = new JButton("Search");
        btnNewButton_2.setForeground(new Color(115, 24, 154));
        btnNewButton_2.setBounds(687, 76, 89, 29);
        contentPane.add(btnNewButton_2);

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
            // Handle profile button action
        }
    }

    public static void main(String[] args) {
        LandingFrame frame = new LandingFrame();
        frame.setVisible(true);
    }
}



