package main.ui; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import main.DAO.OracleAcc;

public class TableFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton retour;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableFrame frame = new TableFrame();
                    frame.setVisible(true);
                    frame.loadData(); // Load data from the database
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TableFrame() {
        setTitle("IMMO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LandingFrame.class.getResource("assets\\logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(963, 630);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(66, 14, 88));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(115, 24, 154));
        scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setBounds(79, 86, 790, 472);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(table);
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "Agent ID", "Client ID", "Owner ID", "Property address", "Date"
            }
        );

        retour = new JButton("<");
        retour.setBounds(10, 10, 45, 40);
        contentPane.add(retour);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LandingFrame mainpage = new LandingFrame();
                mainpage.setVisible(true);
                dispose();
            }
        });
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);

        JLabel lblNewLabel = new JLabel("List of appointments ");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(358, 31, 357, 37);
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(342, 66, 318, 2);
        contentPane.add(separator);
        
        // Load data from the database
        loadData();
    }

    public void loadData() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
            String query = "SELECT * FROM RDV";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            tableModel.setRowCount(0); // Clear existing data

            while (rs.next()) {
                int id = rs.getInt("ID");
                int agentID = rs.getInt("AGENTID");
                int clientID = rs.getInt("CLIENTID");
                int ownerID = rs.getInt("OWNERID");
                String address = rs.getString("ADDRESS_RDV");
                Date date = rs.getDate("DATE_RDV");

                tableModel.addRow(new Object[]{id, agentID, clientID, ownerID, address, date});
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Uncomment this method if you intend to implement it
    /*
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    */
}


