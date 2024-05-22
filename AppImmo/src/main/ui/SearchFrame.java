package main.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.DAO.OracleAcc;
import main.DAO.Property;
import main.DAO.Real_estate_agent;
import main.DAO.User;
import main.DAO.UserSession;
import main.DAO.Owner;

import main.DAO.Property;

public class SearchFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel scrollPanel;
    private JButton retour;

    //Launch the application.
    public static void main(String[] args) {
                try {
                    String info = "DUPLEXE";
                    SearchFrame frame = new SearchFrame(info);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    //Create the frame.
    public SearchFrame(String info) {

        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(SearchFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 621);
        setResizable(false);

        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(200, 10, 5, 10));
        contentPane.setLayout(null);
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
        contentPane.add(retour);

        scrollPanel = new JPanel();
        scrollPanel.setBackground(new Color(115, 24, 154, 100));
        scrollPanel.setPreferredSize(new Dimension(850, 10000));
        scrollPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setBounds(10, 100, 900, 520);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);

        JLabel lblSearchResults = new JLabel("Search Results");
        lblSearchResults.setForeground(new Color(115, 24, 154));
        lblSearchResults.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblSearchResults.setBounds(360, 35, 304, 39);
        contentPane.add(lblSearchResults);

        JSeparator separator = new JSeparator();
        separator.setBounds(355, 75, 210, 10);
        contentPane.add(separator);

        /****************************************/

        List<Property> properties = Property.getProperties();
        int initialY = 15;
        int initialX = 15;


        try {
            int number = Integer.parseInt(info);
            
            for (Property property : properties) {
                if (property.getId()==number){
                    JPanel propertyPanel = createPropertyPanel(property, initialX, initialY);
                    initialY += 350; // Adjust Y position for the next property panel
                    scrollPanel.add(propertyPanel);
                }
            }
        } catch (NumberFormatException e) {
            for (Property property : properties) {
                if (property.getPropertyType()==info || property.getAddress()==info){
                    JPanel propertyPanel = createPropertyPanel(property, initialX, initialY);
                    initialY += 350; // Adjust Y position for the next property panel
                    scrollPanel.add(propertyPanel);
                }
            }
        }

        
        
    }
    

    private JPanel createPropertyPanel(Property property, int initialX, int initialY) {
        JPanel propertyPanel = new JPanel();
        propertyPanel.setBackground(new Color(255, 255, 255)); 
        propertyPanel.setBorder(BorderFactory.createLineBorder(new Color(153, 102, 204)));
        propertyPanel.setLayout(null);
        propertyPanel.setBounds(initialX, initialY, 860, 330);
    
        JLabel typeLabel = new JLabel("TYPE: " + property.getPropertyType());
        typeLabel.setBounds(50, 10, 200, 20);
        typeLabel.setForeground(Color.BLACK);
        typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        propertyPanel.add(typeLabel);
    
        JLabel priceLabel = new JLabel("PRICE: " + String.valueOf(property.getPrice()));
        priceLabel.setBounds(50, 40, 200, 20);
        priceLabel.setForeground(Color.BLACK);
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        propertyPanel.add(priceLabel);
    
        JLabel addressLabel = new JLabel("Address: " + property.getAddress());
        addressLabel.setBounds(50, 70, 400, 20);
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        propertyPanel.add(addressLabel);
    
        JLabel numLabel = new JLabel("Owner's phone number: " + property.getOwnerPhone());
        numLabel.setBounds(50, 100, 300, 20);
        numLabel.setForeground(Color.BLACK);
        numLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        propertyPanel.add(numLabel);
    
        JLabel mailLabel = new JLabel("Owner's email: " + property.getOwnerEmail());
        mailLabel.setBounds(50, 130, 300, 20);
        mailLabel.setForeground(Color.BLACK);
        mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        propertyPanel.add(mailLabel);
    
        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setBounds(50, 160, 400, 20);
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        propertyPanel.add(descriptionLabel);
    
        String propertyDescription = property.getDescription();
    
        JTextArea descriptionTextArea = new JTextArea(propertyDescription);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setEditable(false); 
    
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        scrollPane.setBounds(50, 190, 250, 70); 
        propertyPanel.add(scrollPane);
    
        JLabel iconLabel = new JLabel();
        ImageIcon icon = new ImageIcon(LandingFrame.class.getResource("assets//realestate.jpg"));
        iconLabel.setIcon(icon);
        iconLabel.setBounds(500, 0, 290, 300); 
        propertyPanel.add(iconLabel);
    
        JButton btnEdit = new JButton("Favorite");
        btnEdit.setBackground(Color.BLUE);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEdit.setBounds(155, 280, 89, 29);
        propertyPanel.add(btnEdit);
        
        return propertyPanel;
    }
        
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle any other actions if necessary
    }
}
