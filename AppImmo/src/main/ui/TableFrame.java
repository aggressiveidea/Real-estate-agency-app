package main.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TableFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableFrame frame = new TableFrame();
                    frame.setVisible(true);
                    frame.loadData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 
     */
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
        scrollPane.setBackground(new Color(115,24,154));
        scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setBounds(79, 86, 790, 472);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 20));
        table.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(table);
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "Agent ID", "Client ID", "Owner ID", "Property address", "Date"
            }
        );
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
    }

    // Method to load data from the database and populate the table

    public void loadData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "OracleAcc.USER", "OracleAcc.PASS");
            
            // Create a statement
            statement = connection.createStatement();
            
            // Execute the query to fetch data from the RDV table
            String query = "SELECT * FROM RDV";
            resultSet  = statement.executeQuery(query);
            
            // Loop through the result set and add rows to the table model
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int agentId = resultSet.getInt("AGENTID");
                int clientId = resultSet.getInt("CLIENTID");
                int ownerId = resultSet.getInt("OWNERID");
                String address = resultSet.getString("ADDRESS_RDV");
                Date date = resultSet.getDate("DATE_RDV");
                
                tableModel.addRow(new Object[] {id, agentId, clientId, ownerId, address, date});
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the result set, statement, and connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


