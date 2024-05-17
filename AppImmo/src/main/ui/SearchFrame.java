package main.ui;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class SearchFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel scrollPanel;
    private JButton retour;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchFrame frame = new SearchFrame();
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
    public SearchFrame() {

        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(SearchFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 621);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        retour = new JButton("<");
        retour.setBounds(10, 10, 45, 45);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LandingFrame mainpage = new LandingFrame();
                mainpage.setVisible(true);
                dispose();
            }
        });

        scrollPanel = new JPanel();
        scrollPanel.setBackground(new Color(115, 24, 154, 110));
        scrollPanel.setPreferredSize(new Dimension(900, 1200));
        scrollPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        scrollPanel.add(retour);

        JLabel lblNewLabel = new JLabel("Search results");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(360, 10, 304, 39);
        scrollPanel.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(94, 76, 711, 294);
        scrollPanel.add(panel_2);
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(366, 0, 300, 294);
        panel_3.setBackground(Color.WHITE);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(SearchFrame.class.getResource("assets\\realestate.jpg")));
        lblNewLabel_5.setBounds(0, 0, 300, 294);
        panel_3.add(lblNewLabel_5);

        JLabel lblNewLabel_3 = new JLabel("TYPE :");
        lblNewLabel_3.setBounds(10, 0, 64, 25);
        lblNewLabel_3.setForeground(new Color(115, 24, 154));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("PRICE : ");
        lblNewLabel_3_1.setBounds(10, 36, 64, 25);
        lblNewLabel_3_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_1);

        JLabel lblNewLabel_4 = new JLabel("Studio");
        lblNewLabel_4.setBounds(84, 2, 112, 20);
        lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("45000");
        lblNewLabel_4_1.setBounds(84, 38, 112, 20);
        lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4_1);

        JLabel lblNewLabel_3_2 = new JLabel("DA");
        lblNewLabel_3_2.setBounds(196, 36, 64, 25);
        lblNewLabel_3_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_2);

        JLabel lblNewLabel_2 = new JLabel("Description :");
        lblNewLabel_2.setBounds(10, 185, 139, 25);
        lblNewLabel_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_2);

        JLabel lblNewLabel_3_1_1 = new JLabel("Owner's phone number : ");
        lblNewLabel_3_1_1.setBounds(10, 72, 172, 25);
        lblNewLabel_3_1_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_1_1);

        JLabel lblNewLabel_4_1_1 = new JLabel("48375244697");
        lblNewLabel_4_1_1.setBounds(190, 74, 119, 20);
        lblNewLabel_4_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4_1_1);

        JLabel lblNewLabel_3_1_1_1 = new JLabel("Owner's email : ");
        lblNewLabel_3_1_1_1.setBounds(10, 108, 112, 25);
        lblNewLabel_3_1_1_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_3_1_1_1);

        JLabel lblNewLabel_4_1_2 = new JLabel("albertcamus@gmail.com");
        lblNewLabel_4_1_2.setBounds(132, 110, 184, 20);
        lblNewLabel_4_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_4_1_2);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 218, 310, 65);
        panel_2.add(scrollPane_1);

        JLabel lblNewLabel_1 = new JLabel("<html>2 pièces traversant de 55 m² exposé SUD EST situé au 5ᵉ étage sans ascenseur comprenant :</html>");
        scrollPane_1.setViewportView(lblNewLabel_1);

        JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Address : ");
        lblNewLabel_3_1_1_1_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3_1_1_1_1.setBounds(10, 149, 96, 25);
        panel_2.add(lblNewLabel_3_1_1_1_1);

        JLabel lblNewLabel_4_1_3 = new JLabel("SUD EST de france");
        lblNewLabel_4_1_3.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1_3.setBounds(84, 154, 224, 20);
        panel_2.add(lblNewLabel_4_1_3);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(360, 49, 193, 2);
        scrollPanel.add(separator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle any other actions if necessary
    }
}