package main.ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TableFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton retour;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableFrame frame = new TableFrame();
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
    public TableFrame() {
        setTitle("IMMO");
        // Ensure the image path is correct
        setIconImage(Toolkit.getDefaultToolkit().getImage(TableFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(963, 630);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 949, 603);
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

        table = new JTable();
        table.setColumnSelectionAllowed(true);
        table.setBounds(79, 90, 790, 468);
        panel.add(table);

        JLabel lblNewLabel = new JLabel("Liste of appointments");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(358, 31, 357, 37);
        panel.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(342, 66, 318, 2);
        panel.add(separator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
