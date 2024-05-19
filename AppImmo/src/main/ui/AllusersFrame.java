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
import javax.swing.BorderFactory;

import main.DAO.User;
import java.util.List;


public class AllusersFrame extends JFrame implements ActionListener {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel scrollPanel;
    private JButton retour;
    public static List<User> users;
    /**
     * Launch the application.
     */
    public AllusersFrame(List<User> users) {
        AllusersFrame.users = users;
        initialize();
        displayUsers(10, 10, users);
    }

    /**
     * Create the frame.
     */
    public void initialize() { {
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
        scrollPanel.setBackground(new Color(183, 137, 203)); 
        scrollPanel.setLayout(null);
        scrollPane_1.setViewportView(scrollPanel);
        scrollPanel.setPreferredSize(new Dimension(691, 20000));

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(66, 14, 88));
        panel_3.setBounds(738, 0, 107, 593);
        panel_1.add(panel_3);
    }
}

    private void displayUsers(int initialX, int initialY, List<User> users) {
        if (users != null) {
            int yPosition = initialY;
            for (User user : users) {
                JPanel userPanel = new JPanel();
                userPanel.setBackground(Color.WHITE); // Fond blanc pour chaque panneau utilisateur
                userPanel.setBorder(BorderFactory.createLineBorder(new Color(153, 102, 204)));
                userPanel.setBounds(initialX, yPosition, 680, 320);
                userPanel.setLayout(null);

                // Labels pour les informations utilisateur
                addLabel(userPanel, "ID: ", String.valueOf(user.getId()), 20, 30);
                addLabel(userPanel, "Name: ", user.getSurname(), 20, 74);
                addLabel(userPanel, "Surname: ", user.getName(), 20, 120);
                addLabel(userPanel, "Email: ", user.getEmail(), 20, 162);
                addLabel(userPanel, "Phone number: ", user.getPhone_number(), 20, 206);
                addLabel(userPanel, "Type: ", user.getType().toString(), 20, 256);

                // Image
                JLabel iconLabel = new JLabel();
                ImageIcon icon = new ImageIcon(AllusersFrame.class.getResource("assets\\Bidhom-Blog-New31 (1).png"));
                iconLabel.setIcon(icon);
                iconLabel.setBounds(400, 10, 250, 300); // Ajustez la position et la taille de l'image
                userPanel.add(iconLabel);

                scrollPanel.add(userPanel); // Add userPanel to scrollPanel
                yPosition += 340; // Adjust Y position for the next user panel
            }
            scrollPanel.setPreferredSize(new Dimension(691, yPosition)); // Adjust scrollPanel size based on content
            scrollPanel.revalidate();
            scrollPanel.repaint();
        } else {
            System.out.println("Aucun utilisateur à afficher.");
        }
    }

    private void addLabel(JPanel panel, String labelText, String text, int x, int y) {
        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(115, 24, 154));
        label.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label.setBounds(x, y + 10, 150, 20); 
        panel.add(label);

        JLabel textLabel;
        switch (labelText) {
            case "Phone number:":
                textLabel = new JLabel(text);
               textLabel.setForeground(Color.BLACK);
               textLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
               textLabel.setBounds(x + 200, y + 10, 500, 20);
               panel.add(textLabel); 
                break;
            case "Name:":
                textLabel = new JLabel(text);
               textLabel.setForeground(Color.BLACK);
               textLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
               textLabel.setBounds(x + 60, y + 10, 500, 20);
               panel.add(textLabel); 
            break ;
            case "ID:":
               textLabel = new JLabel(text);
               textLabel.setForeground(Color.BLACK);
               textLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
               textLabel.setBounds(x + 40, y + 10, 500, 20);
               panel.add(textLabel); 
            break;
            default:
               textLabel = new JLabel(text);
               textLabel.setForeground(Color.BLACK);
               textLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
               textLabel.setBounds(x + 120, y + 10, 500, 20);
               panel.add(textLabel);
                break;
        }

  
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
