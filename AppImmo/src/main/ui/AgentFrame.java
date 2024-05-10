package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.util.List;

import main.DAO.User;

public class AgentFrame extends JFrame {

    public JPanel contentPane; // Ajout de la déclaration de contentPane
    public JButton retour; // Ajout de la déclaration de retour

    public JPanel scrollPanel;

    public List<User> agents;  // Ajout d'un champ pour stocker la liste d'agents

    public AgentFrame(List<User> agents) {
        this.agents = agents; // Stockage de la liste d'agents passée en paramètre
        initialize();
        displayAgents();
    }

    private void initialize() {
        setTitle("IMMO");
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(963, 630);
        contentPane = new JPanel(); // Correction de la déclaration de contentPane
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
        separator.setBounds(144, 50, 101, 2);
        panel_2.add(separator);

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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(342, 63, 606, 541);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);

        scrollPanel = new JPanel();
        scrollPanel.setPreferredSize(new Dimension(1000, 5000));
        scrollPanel.setLayout(null);
        scrollPane.setViewportView(scrollPanel);
    }

    private void displayAgents() {
        int initialX = 10;
        int initialY = 100;
        int yOffset = 200;

        // Création du JLabel pour le message "Liste of agents"
        JLabel messageLabel = new JLabel("Liste of agents");
        messageLabel.setForeground(new Color(115, 24, 154));
        messageLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        messageLabel.setBounds(203, 20, 200, 40);
        scrollPanel.add(messageLabel);

        for (User agent : agents) {
            JPanel agentPanel = new JPanel();
            agentPanel.setBackground(Color.WHITE);
            agentPanel.setBounds(initialX, initialY, 582, 177);
            scrollPanel.add(agentPanel);
            agentPanel.setLayout(null);

            // Création d'un JLabel pour afficher l'icône
            JLabel iconLabel = new JLabel();
            ImageIcon icon = new ImageIcon(AgentFrame.class.getResource("assets\\Bidhom-Blog-New31 (1).png"));
            iconLabel.setIcon(icon);
            iconLabel.setBounds(582 - icon.getIconWidth() - 10, 10, icon.getIconWidth(), icon.getIconHeight());
            agentPanel.add(iconLabel);

            addLabel(agentPanel, "ID : ", String.valueOf(agent.getId()), 20, 0);
            addLabel(agentPanel, "Nom : ", agent.getSurname(), 20, 34);
            addLabel(agentPanel, "Prénom : ", agent.getName(), 20, 68);
            addLabel(agentPanel, "Email : ", agent.getEmail(), 20, 104);
            addLabel(agentPanel, "Numéro de téléphone : ", agent.getPhone_number(), 20, 137);

            initialY += yOffset;
        }
    }

    private void addLabel(JPanel panel, String labelText, String text, int x, int y) {
        JLabel label = new JLabel(labelText + text);
        label.setForeground(new Color(115, 24, 154));
        label.setFont(new Font("Dialog", Font.PLAIN, 15));
        label.setBounds(x, y, 500, 25);

        panel.add(label);
    }
}