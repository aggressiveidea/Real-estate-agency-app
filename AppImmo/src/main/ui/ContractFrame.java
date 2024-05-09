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
        
        JLabel lblNewLabel_1_2 = new JLabel(" Name : ");
        lblNewLabel_1_2.setForeground(new Color(115,24,154));
        lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(107, 162, 128, 23);
        contentPane.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_2_1 = new JLabel(" Surname : ");
        lblNewLabel_1_2_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_1.setBounds(107, 210, 142, 23);
        contentPane.add(lblNewLabel_1_2_1);
        
        JLabel lblNewLabel_1_2_2 = new JLabel("Email : ");
        lblNewLabel_1_2_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_2.setBounds(115, 260, 128, 23);
        contentPane.add(lblNewLabel_1_2_2);
        
        JLabel lblNewLabel_1_2_3 = new JLabel("Address : ");
        lblNewLabel_1_2_3.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_3.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_3.setBounds(115, 306, 128, 23);
        contentPane.add(lblNewLabel_1_2_3);
        
        JLabel lblNewLabel_1_2_4 = new JLabel("Phone number : ");
        lblNewLabel_1_2_4.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4.setBounds(115, 355, 163, 23);
        contentPane.add(lblNewLabel_1_2_4);
        
        JLabel lblNewLabel_1_2_5 = new JLabel("Contract type : ");
        lblNewLabel_1_2_5.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_5.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_5.setBounds(115, 441, 150, 23);
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
        
        JLabel lblNewLabel_1_2_3_1 = new JLabel("Address : ");
        lblNewLabel_1_2_3_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_3_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_3_1.setBounds(509, 306, 128, 23);
        contentPane.add(lblNewLabel_1_2_3_1);
        
        JLabel lblNewLabel_1_2_4_1 = new JLabel("Phone number : ");
        lblNewLabel_1_2_4_1.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_1.setBounds(509, 355, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_1);
        
        JLabel lblNewLabel_1_2_4_2 = new JLabel("Duration : ");
        lblNewLabel_1_2_4_2.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_2.setBounds(115, 488, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_2);
        
        JLabel lblNewLabel_1_2_4_3 = new JLabel("Amount : ");
        lblNewLabel_1_2_4_3.setForeground(new Color(115, 24, 154));
        lblNewLabel_1_2_4_3.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1_2_4_3.setBounds(509, 441, 163, 23);
        contentPane.add(lblNewLabel_1_2_4_3);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(107, 406, 618, 2);
        contentPane.add(separator);
        
        JLabel lblNewLabel_1 = new JLabel("Khadidja");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(214, 164, 203, 22);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("DAOUADI");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(214, 212, 203, 22);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_3 = new JLabel("Khadidja.DAOUADI@gmail.com");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(214, 262, 229, 22);
        contentPane.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("Alger");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_4.setBounds(214, 307, 203, 22);
        contentPane.add(lblNewLabel_1_4);
        
        JLabel lblNewLabel_1_5 = new JLabel("3276526954");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_5.setBounds(265, 355, 203, 22);
        contentPane.add(lblNewLabel_1_5);
        
        JLabel lblNewLabel_1_6 = new JLabel("bnadem");
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_6.setBounds(607, 163, 203, 22);
        contentPane.add(lblNewLabel_1_6);
        
        JLabel lblNewLabel_1_7 = new JLabel("wlid bnadem");
        lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_7.setBounds(607, 210, 203, 22);
        contentPane.add(lblNewLabel_1_7);
        
        JLabel lblNewLabel_1_8 = new JLabel("bnadem@gmail.com");
        lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_8.setBounds(607, 261, 203, 22);
        contentPane.add(lblNewLabel_1_8);
        
        JLabel lblNewLabel_1_9 = new JLabel("kach placa");
        lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_9.setBounds(607, 306, 203, 22);
        contentPane.add(lblNewLabel_1_9);
        
        JLabel lblNewLabel_1_10 = new JLabel("00000000");
        lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_10.setBounds(661, 357, 203, 22);
        contentPane.add(lblNewLabel_1_10);
        
        JLabel lblNewLabel_1_11 = new JLabel("Lease agreements");
        lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_11.setBounds(265, 441, 203, 22);
        contentPane.add(lblNewLabel_1_11);
        
        JLabel lblNewLabel_1_12 = new JLabel("450000");
        lblNewLabel_1_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_12.setBounds(607, 443, 203, 22);
        contentPane.add(lblNewLabel_1_12);
        
        JLabel lblNewLabel_1_13 = new JLabel("1 ans");
        lblNewLabel_1_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_13.setBounds(225, 488, 203, 22);
        contentPane.add(lblNewLabel_1_13);
        
        JButton btnNewButton = new JButton("Save");
        btnNewButton.setForeground(new Color(115,24,154));
        btnNewButton.setBounds(346, 512, 173, 23);
        contentPane.add(btnNewButton);
       
	}
    
}
