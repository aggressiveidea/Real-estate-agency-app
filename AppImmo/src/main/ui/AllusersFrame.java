package main.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class AllusersFrame extends JFrame implements ActionListener{

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
                    AllusersFrame frame = new AllusersFrame();
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
    public AllusersFrame() {
        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AllusersFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(963, 630);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 107, 593);
        panel.setBackground(new Color(66, 14, 88));
        panel.setLayout(null);
        contentPane.add(panel);

        retour = new JButton("<");
        retour.setBounds(10, 10, 45, 45);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LandingFrame mainpage = new LandingFrame();
                mainpage.setVisible(true);
                dispose();
            }
        });
        panel.add(retour);
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(115, 24, 154));
        panel_1.setBounds(104, 0, 845, 593);
        panel_1.setLayout(null);
        contentPane.add(panel_1);

        JLabel lblNewLabel = new JLabel("List of users");
        lblNewLabel.setBounds(266, 11, 252, 41);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        panel_1.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(256, 49, 181, 2);
        panel_1.add(separator);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 74, 715, 519);
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel_1.add(scrollPane_1);

        scrollPanel = new JPanel();
        scrollPanel.setBackground(new Color(115, 24, 154, 130));
        scrollPanel.setPreferredSize(new Dimension(691, 1200));
        scrollPane_1.setViewportView(scrollPanel);
        scrollPanel.setLayout(null);

        // Example user panel (you will need to create these dynamically based on the actual data)
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 10, 676, 254);
        scrollPanel.add(panel_2);
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setLayout(null);

        JLabel lblId = new JLabel("ID : ");
        lblId.setBounds(10, 11, 64, 25);
        lblId.setForeground(new Color(115, 24, 154));
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblId);

        JLabel lblName = new JLabel("Name : ");
        lblName.setBounds(10, 47, 64, 25);
        lblName.setForeground(new Color(115, 24, 154));
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblName);

        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setBounds(10, 89, 82, 25);
        lblUsername.setForeground(new Color(115, 24, 154));
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblUsername);

        JLabel lblEmail = new JLabel("Email : ");
        lblEmail.setBounds(10, 131, 64, 25);
        lblEmail.setForeground(new Color(115, 24, 154));
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblEmail);

        JLabel lblPhoneNumber = new JLabel("Phone Number : ");
        lblPhoneNumber.setBounds(10, 173, 139, 25);
        lblPhoneNumber.setForeground(new Color(115, 24, 154));
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblPhoneNumber);

        JLabel lblType = new JLabel("TYPE :");
        lblType.setBounds(10, 218, 64, 25);
        lblType.setForeground(new Color(115, 24, 154));
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblType);

        JLabel lblIdValue = new JLabel("343854");
        lblIdValue.setBounds(84, 11, 151, 25);
        lblIdValue.setForeground(Color.BLACK);
        lblIdValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblIdValue);

        JLabel lblNameValue = new JLabel("bnadem");
        lblNameValue.setBounds(84, 47, 139, 25);
        lblNameValue.setForeground(Color.BLACK);
        lblNameValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNameValue);

        JLabel lblUsernameValue = new JLabel("wlid bnadem");
        lblUsernameValue.setBounds(115, 89, 140, 25);
        lblUsernameValue.setForeground(Color.BLACK);
        lblUsernameValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblUsernameValue);

        JLabel lblEmailValue = new JLabel("wlidbnadem@gmail.com");
        lblEmailValue.setBounds(84, 131, 260, 25);
        lblEmailValue.setForeground(Color.BLACK);
        lblEmailValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblEmailValue);

        JLabel lblPhoneNumberValue = new JLabel("32875926");
        lblPhoneNumberValue.setBounds(147, 173, 145, 25);
        lblPhoneNumberValue.setForeground(Color.BLACK);
        lblPhoneNumberValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblPhoneNumberValue);

        JLabel lblTypeValue = new JLabel("Client");
        lblTypeValue.setBounds(84, 218, 171, 25);
        lblTypeValue.setForeground(Color.BLACK);
        lblTypeValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblTypeValue);

        JLabel lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setBounds(394, 0, 208, 243);
        
        ImageIcon originalIcon = new ImageIcon(AllusersFrame.class.getResource("assets\\Aesthetic-Cute-Anime-Profile-Picture.jpg"));
        
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        lblNewLabel_1.setIcon(scaledIcon);
        panel_2.add(lblNewLabel_1);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(66, 14, 88));
        panel_3.setBounds(738, 0, 107, 593);
        panel_1.add(panel_3);

        // Add more user panels dynamically based on actual data
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
