package main.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class AgentFrame extends JFrame {

    private JPanel contentPane;
    private JButton retour;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgentFrame frame = new AgentFrame();
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
    public AgentFrame() {
        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Transactionframe.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(963, 630);
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
        panel_1.setBounds(106, 63, 237, 541);
        panel_1.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 963, 63);
        panel_2.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("Agents ");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblNewLabel.setBounds(144, 11, 165, 41);
        panel_2.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(134, 50, 118, 2);
        panel_2.add(separator);

        JPanel panel_21 = new JPanel();
        panel_21.setBackground(Color.WHITE);
        panel_21.setBounds(357, 185, 582, 177);
        contentPane.add(panel_21);
        panel_21.setLayout(null);
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
        
        JLabel lblNewLabel_2 = new JLabel("Surname : ");
        lblNewLabel_2.setForeground(new Color(115,24,154));
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(10, 68, 73, 25);
        panel_21.add(lblNewLabel_2);
       
        
     
        
        JLabel lblNewLabel_3 = new JLabel("ID : ");
        lblNewLabel_3.setForeground(new Color(115,24,154));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(10, 0, 64, 25);
        panel_21.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Name : ");
        lblNewLabel_3_1.setForeground(new Color(115,24,154));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3_1.setBounds(10, 34, 64, 25);
        panel_21.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_4 = new JLabel("00150");//pour afficher le type
        lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(73, 5, 112, 20);
        panel_21.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("DAOUADI ");//pour afficher le prix
        lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1.setBounds(83, 37, 112, 20);
        panel_21.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Email : ");
        lblNewLabel_2_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_2_1.setBounds(10, 104, 57, 25);
        panel_21.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Phone number : ");
        lblNewLabel_2_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_2_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_2_2.setBounds(10, 137, 139, 25);
        panel_21.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("daouadi.khadidja@gmail.com ");
        lblNewLabel_4_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1_1.setBounds(73, 108, 212, 20);
        panel_21.add(lblNewLabel_4_1_1);
        
        JLabel lblNewLabel_4_1_2 = new JLabel("46789367904");
        lblNewLabel_4_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1_2.setBounds(136, 139, 112, 20);
        panel_21.add(lblNewLabel_4_1_2);
        
        JLabel lblNewLabel_4_1_3 = new JLabel("Khadidja ");
        lblNewLabel_4_1_3.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_4_1_3.setBounds(93, 70, 112, 20);
        panel_21.add(lblNewLabel_4_1_3);
        
        
                  
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setBounds(295, 0, 268, 172);
                panel_21.add(lblNewLabel_1);
                
                lblNewLabel_1.setIcon(new ImageIcon(AgentFrame.class.getResource("assets\\Bidhom-Blog-New-–-31 (1).png")));
        
        JLabel lblListeOfAgents = new JLabel("Liste of agents ");
        lblListeOfAgents.setForeground(new Color(115,24,154));
        lblListeOfAgents.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblListeOfAgents.setBounds(544, 103, 258, 41);
        contentPane.add(lblListeOfAgents);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(341, 63, 608, 541);
        contentPane.add(scrollPane);
        
}
}