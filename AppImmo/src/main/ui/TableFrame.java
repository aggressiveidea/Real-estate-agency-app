package main.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import java.text.SimpleDateFormat;

import main.DAO.OracleAcc;

import main.DAO.*;

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
                    frame.insertTestData(); // Insert test data
                    frame.loadData(); // Load data from the database

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

     // Method to insert test data into the tables
    public void insertTestData() {
        Connection connection = null;
        Statement statement = null;
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

            // Create a statement
            statement = connection.createStatement();

            // Insert data into the OWNER, CLIENT, and AGENT tables
            statement.executeUpdate("INSERT INTO Proprietaire ( IDpropr , Nompropr) VALUES (9938303, 'OwnerName')"); // Adjust columns as needed
            statement.executeUpdate("INSERT INTO CLIENT (IDclient, NomClient) VALUES (8158972, 'ClientName')"); // Adjust columns as needed
            statement.executeUpdate("INSERT INTO AgentImm (IDagent, NomAgent) VALUES (3537078, 'AgentName')"); // Adjust columns as needed

            // Insert a single appointment into the RDV table
            String insertQuery = "INSERT INTO RDV (ID, AGENTID, CLIENTID, OWNERID, ADDRESS_RDV, DATE_RDV) " +
                                 "VALUES (1, 3537078, 8158972, 9938303, '123 Main St', TO_DATE('01/06/24', 'MM/DD/YY'))";
            statement.executeUpdate(insertQuery);
            System.out.println("Inserted test data into OWNER, CLIENT, AGENT, and RDV tables.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
            
            // Create a statement
            statement = connection.createStatement();
            
            // Execute the query to fetch data from the RDV table
            String query = "SELECT * FROM RDV";
             resultSet = statement.executeQuery(query);

            // Check if result set is empty
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No data found in RDV table");
            } else {
                // Loop through the result set and add rows to the table model
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    int agentId = resultSet.getInt("AGENTID");
                    int clientId = resultSet.getInt("CLIENTID");
                    int ownerId = resultSet.getInt("OWNERID");
                    String address = resultSet.getString("ADDRESS_RDV");
                    java.sql.Date date = resultSet.getDate("DATE_RDV"); // Retrieve date as java.sql.Date

                    // Format date as required by the table model
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                    String formattedDate = sdf.format(date);

                    Object[] rowData = {id, agentId, clientId, ownerId, address, formattedDate}; // Use formatted date
                    tableModel.addRow(rowData);

                    // Print the fetched row data to the console
                    System.out.println("Row added: " + java.util.Arrays.toString(rowData));
                }
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
   // @Override
  ///  public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    //    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  //  }
}


