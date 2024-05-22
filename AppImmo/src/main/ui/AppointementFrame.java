package main.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.DAO.Appointment;
import main.DAO.OracleAcc;

import javax.swing.JSeparator;


public class AppointementFrame extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton retour;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField;
    private JTextField textField_1;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    AppointementFrame frame = new AppointementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public AppointementFrame() {
        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AppointementFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 621);
        setResizable(false);

        this.setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Appointment");
        lblNewLabel.setForeground(new Color(115,24,154));
        lblNewLabel.setBounds(297, 50, 229, 39);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Client's ID:");
        lblNewLabel_1.setForeground(new Color(115,24,154));
        lblNewLabel_1.setBounds(115, 218, 128, 20);
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Owner's ID:");
        lblNewLabel_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1.setBounds(117, 285, 140, 20);
        lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Property address:");
        lblNewLabel_1_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1.setBounds(115, 337, 186, 29);
        lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Date:");
        lblNewLabel_1_1_1_1.setForeground(new Color(115,24,154));
        lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(117, 402, 76, 29);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        
        
        JButton btnNewButton = new JButton("Add Appointment");
        btnNewButton.setBackground(Color.BLUE);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnNewButton.setBounds(299, 481, 254, 29);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                String agentIDS = textField.getText();
                String clientIDS = textField_5.getText();
                String ownerIDS = textField_4.getText();
                String dateS = textField_1.getText();
                String address = textField_2.getText();

                int agentID = Integer.parseInt(agentIDS);
                int clientID = Integer.parseInt(clientIDS);
                int ownerID = Integer.parseInt(ownerIDS);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                try {

                    Date date = formatter.parse(dateS);

                    Appointment app = new Appointment();
                    app.setappointment_date(date);
                    

                    String SQL = "INSERT INTO RDV (ID, Address_rdv, date_rdv) VALUES (?,?,?)";

                    try {
                        
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

					    PreparedStatement pstmt = conn.prepareStatement(SQL);

                        pstmt.setInt(1,app.getId());
                        pstmt.setString(2, address);
                        pstmt.setDate(3, app.getSQLDate());

                        // Execute query
					    pstmt.executeUpdate();
					    JOptionPane.showMessageDialog(null, "Appointment added successfully!");

                        //save file 
                        try {
                            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                            Graphics2D g2d = image.createGraphics();
                            getContentPane().paint(g2d);
                            g2d.dispose();
    
                            JFileChooser fileChooser = new JFileChooser();
                            int option = fileChooser.showSaveDialog(AppointementFrame.this);
                            if (option == JFileChooser.APPROVE_OPTION) {
                                File selectedFile = fileChooser.getSelectedFile();
                            
                                // Save the image to the selected file
                                ImageIO.write(image, "png", selectedFile);
                               }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Failed to save image", "ERROR",JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Failed to add appointment :"+ex.getStackTrace(), "ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ParseException  ee) {
                    JOptionPane.showMessageDialog(null, "Wrong date format, it must be (yyyy-MM-dd)", "ERROR",JOptionPane.ERROR_MESSAGE);
					ee.printStackTrace();
                }
    
            }
        });
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(742, 0, 41, 609);
        panel_1_1.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_1_1);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBackground(new Color(115, 24, 154));
        panel_1_1_1.setBounds(0, 0, 783, 39);
        contentPane.add(panel_1_1_1);
        panel_1_1_1.setLayout(null);
        
        retour = new JButton("<");
        retour.setBounds(10, 11, 41, 23);
        panel_1_1_1.add(retour);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                 Transactionframe transactionframe = new Transactionframe();
                 transactionframe.setVisible(true);
               
                dispose();
            }
        });
        
        JPanel panel_1_1_1_1 = new JPanel();
        panel_1_1_1_1.setBackground(new Color(115, 24, 154));
        panel_1_1_1_1.setBounds(-36, 546, 819, 63);
        contentPane.add(panel_1_1_1_1);
        
        JPanel panel_1_1_2 = new JPanel();
        panel_1_1_2.setBackground(new Color(115, 24, 154));
        panel_1_1_2.setBounds(0, 0, 41, 573);
        contentPane.add(panel_1_1_2);
        
        JLabel lblNewLabel_1_2 = new JLabel("Agent's ID:");
        lblNewLabel_1_2.setForeground(new Color(115,24,154));
        lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(115, 154, 128, 23);
        contentPane.add(lblNewLabel_1_2);
        
        //property address
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(299, 345, 254, 28);
        contentPane.add(textField_2);
        
        //owner id
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(299, 277, 254, 28);
        contentPane.add(textField_4);
        
        //client id
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(299, 210, 254, 28);
        contentPane.add(textField_5);
        
        //agent id
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(299, 149, 254, 28);
        contentPane.add(textField);
        
        //date 
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(299, 403, 254, 28);
        contentPane.add(textField_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(286, 87, 186, 2);
        separator.setBackground(new Color(115,24,154));
        contentPane.add(separator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}