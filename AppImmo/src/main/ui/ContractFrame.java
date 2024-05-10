package main.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class ContractFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton retour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractFrame frame = new ContractFrame();
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
	public ContractFrame() {
		setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AppointementFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 621);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Contract ");
        lblNewLabel.setForeground(new Color(115,24,154));
        lblNewLabel.setBounds(368, 47, 229, 39);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        contentPane.add(lblNewLabel);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(874, 0, 41, 609);
        panel_1_1.setBackground(new Color(115, 24, 154));
        contentPane.add(panel_1_1);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBackground(new Color(115, 24, 154));
        panel_1_1_1.setBounds(0, 0, 876, 39);
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
        panel_1_1_1_1.setBounds(-36, 546, 912, 63);
        contentPane.add(panel_1_1_1_1);
        
        JPanel panel_1_1_2 = new JPanel();
        panel_1_1_2.setBackground(new Color(115, 24, 154));
        panel_1_1_2.setBounds(0, 0, 41, 573);
        contentPane.add(panel_1_1_2);
        
        JLabel lblNewLabel_1_2 = new JLabel("Name : ");
        lblNewLabel_1_2.setForeground(new Color(115,24,154));
        lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(93, 162, 128, 23);
        contentPane.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Surname : ");
        lblNewLabel_1_2_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_1.setBounds(93, 210, 142, 23);
        contentPane.add(lblNewLabel_1_2_1);
        
        JLabel lblNewLabel_1_2_2 = new JLabel("Email : ");
        lblNewLabel_1_2_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_2.setBounds(93, 260, 128, 23);
        contentPane.add(lblNewLabel_1_2_2);
        
        JLabel lblNewLabel_1_2_4 = new JLabel("Phone number : ");
        lblNewLabel_1_2_4.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4.setBounds(93, 316, 163, 23);
        contentPane.add(lblNewLabel_1_2_4);
        
        JLabel lblNewLabel_1_2_5 = new JLabel("Contract type : ");
        lblNewLabel_1_2_5.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_5.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_5.setBounds(93, 388, 150, 23);
        contentPane.add(lblNewLabel_1_2_5);
        
        JLabel lblClient = new JLabel("CLIENT ");
        lblClient.setForeground(new Color(115, 24, 154));
        lblClient.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblClient.setBounds(107, 97, 109, 39);
        contentPane.add(lblClient);
        
        JLabel lblOwner = new JLabel("OWNER ");
        lblOwner.setForeground(new Color(115, 24, 154));
        lblOwner.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblOwner.setBounds(509, 97, 109, 39);
        contentPane.add(lblOwner);
        
        JLabel lblNewLabel_1_2_6 = new JLabel(" Name : ");
        lblNewLabel_1_2_6.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_6.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_6.setBounds(506, 162, 128, 23);
        contentPane.add(lblNewLabel_1_2_6);
        
        JLabel lblNewLabel_1_2_1_1 = new JLabel(" Surname : ");
        lblNewLabel_1_2_1_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_1_1.setBounds(506, 210, 142, 23);
        contentPane.add(lblNewLabel_1_2_1_1);
        
        JLabel lblNewLabel_1_2_2_1 = new JLabel("Email : ");
        lblNewLabel_1_2_2_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_2_1.setBounds(511, 260, 128, 23);
        contentPane.add(lblNewLabel_1_2_2_1);
        
        JLabel lblNewLabel_1_2_4_1 = new JLabel("Phone number : ");
        lblNewLabel_1_2_4_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_1.setBounds(509, 316, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_1);
        
        JLabel lblNewLabel_1_2_4_2 = new JLabel("Duration : ");
        lblNewLabel_1_2_4_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_2.setBounds(93, 434, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_2);
        
        JLabel lblNewLabel_1_2_4_3 = new JLabel("Amount : ");
        lblNewLabel_1_2_4_3.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_3.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_3.setBounds(509, 390, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_3);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(112, 375, 618, 2);
        contentPane.add(separator);
        
        JLabel lblNewLabel_1 = new JLabel("Khadidja");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(181, 164, 203, 22);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("DAOUADI");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(207, 212, 203, 22);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_3 = new JLabel("Khadidja.DAOUADI@gmail.com");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(181, 262, 229, 22);
        contentPane.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_5 = new JLabel("3276526954");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_5.setBounds(265, 318, 203, 22);
        contentPane.add(lblNewLabel_1_5);
        
        JLabel lblNewLabel_1_6 = new JLabel("bnadem");
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_6.setBounds(607, 163, 203, 22);
        contentPane.add(lblNewLabel_1_6);
        
        JLabel lblNewLabel_1_7 = new JLabel("wlid bnadem");
        lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_7.setBounds(630, 212, 203, 22);
        contentPane.add(lblNewLabel_1_7);
        
        JLabel lblNewLabel_1_8 = new JLabel("bnadem@gmail.com");
        lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_8.setBounds(607, 261, 203, 22);
        contentPane.add(lblNewLabel_1_8);
        
        JLabel lblNewLabel_1_10 = new JLabel("00000000");
        lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_10.setBounds(682, 318, 203, 22);
        contentPane.add(lblNewLabel_1_10);
        
        JLabel lblNewLabel_1_11 = new JLabel("Lease agreements");
        lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_11.setBounds(252, 390, 203, 22);
        contentPane.add(lblNewLabel_1_11);
        
        JLabel lblNewLabel_1_12 = new JLabel("450000");
        lblNewLabel_1_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_12.setBounds(618, 390, 203, 22);
        contentPane.add(lblNewLabel_1_12);
        
        JLabel lblNewLabel_1_13 = new JLabel("1 ans");
        lblNewLabel_1_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_13.setBounds(221, 436, 203, 22);
        contentPane.add(lblNewLabel_1_13);
        
        JButton btnNewButton = new JButton("Save");
        btnNewButton.setForeground(new Color(115,24,154));
        btnNewButton.setBounds(346, 512, 173, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1_2_5_1 = new JLabel("Property Adrress : ");
        lblNewLabel_1_2_5_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_5_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_5_1.setBounds(505, 434, 187, 23);
        contentPane.add(lblNewLabel_1_2_5_1);
        
        JLabel lblNewLabel_1_12_1 = new JLabel("Alger centre ");
        lblNewLabel_1_12_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_12_1.setBounds(682, 436, 187, 23);
        contentPane.add(lblNewLabel_1_12_1);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(new Color(115,24,154));
        separator_1.setBounds(361, 84, 128, 2);
        contentPane.add(separator_1);
       
	}
}
