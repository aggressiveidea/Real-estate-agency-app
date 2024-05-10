package main.ui;

import java.awt.Color;  
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;



import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
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
        btnRemoveAccount.setForeground(new Color(115, 24, 154));
        btnRemoveAccount.setFont(new Font("Dialog", Font.PLAIN, 11));
        btnRemoveAccount.setBounds(23, 496, 185, 23);
        panel_1.add(btnRemoveAccount);
        btnRemoveAccount.addActionListener(this); // Add action listener

        JButton btnEditAccount = new JButton("Edit account");
        btnEditAccount.setForeground(new Color(115, 24, 154));
        btnEditAccount.setFont(new Font("Dialog", Font.PLAIN, 11));
        btnEditAccount.setBounds(23, 447, 185, 23);
        panel_1.add(btnEditAccount);
        
                // Button to browse and select an image
                btnBrowse = new JButton("Browse");
                btnBrowse.setForeground(new Color(115, 24, 154));
                btnBrowse.setFont(new Font("Dialog", Font.PLAIN, 11));
                btnBrowse.setBounds(65, 164, 100, 30);
                panel_1.add(btnBrowse);
                // JLabel to display the image
                imageLabel = new JLabel();
                imageLabel.setBounds(23, 11, 185, 135);
                panel_1.add(imageLabel);
                
                JLabel lblNewLabel_2 = new JLabel("ID : ");
                lblNewLabel_2.setForeground(Color.WHITE);
                lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNewLabel_2.setBounds(23, 221, 49, 23);
                panel_1.add(lblNewLabel_2);
                
                JLabel lblNewLabel_2_1 = new JLabel("Username :");
                lblNewLabel_2_1.setForeground(Color.WHITE);
                lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNewLabel_2_1.setBounds(23, 265, 128, 23);
                panel_1.add(lblNewLabel_2_1);
                
                JLabel lblNewLabel_2_2 = new JLabel("Type : ");
                lblNewLabel_2_2.setForeground(Color.WHITE);
                lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNewLabel_2_2.setBounds(23, 313, 100, 37);
                panel_1.add(lblNewLabel_2_2);
                
                JLabel lblNewLabel_3 = new JLabel("New label");
                lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
                lblNewLabel_3.setBounds(130, 225, 152, 22);
                panel_1.add(lblNewLabel_3);
                
                JLabel lblNewLabel_3_1 = new JLabel("New label");
                lblNewLabel_3_1.setBounds(130, 266, 152, 22);
                panel_1.add(lblNewLabel_3_1);
                
                JLabel lblNewLabel_3_2 = new JLabel("New label");
                lblNewLabel_3_2.setBounds(130, 324, 152, 22);
                panel_1.add(lblNewLabel_3_2);
                btnBrowse.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            // Set the selected image to the label
                            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                            imageLabel.setIcon(imageIcon);
                        }
                    }
                });
        btnEditAccount.addActionListener(this); 
        
        
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
				
				JSeparator separator = new JSeparator();
				separator.setBounds(142, 50, 123, 2);
				panel_2.add(separator);
				retour.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				 LandingFrame mainpage = new LandingFrame();
				 mainpage.setVisible(true);
				
				dispose();
				
			}
		});


        JLabel lblNewLabel_1 = new JLabel("Latest interactions");
        lblNewLabel_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(555, 74, 206, 39);
        contentPane.add(lblNewLabel_1);
        
        table = new JTable();
        table.setBackground(new Color(115,24,154,130));
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