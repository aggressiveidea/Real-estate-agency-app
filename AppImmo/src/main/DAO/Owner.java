package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.ui.OracleAcc;


public class Owner extends User {

    public int property_id;
    
    // constructor 1
    public Owner(String username, String password, int t, int property_id) {
        super(username, password);
        this.property_id = property_id;
    }

    // constructor 2
    public Owner(String surname, String name, String email, String phone_number, int property_id) {
        super(property_id, surname, name, email, phone_number, 2);
        this.property_id = property_id;
    }

    // full constructor
    public Owner(String surname, String name, String email, String phone_number, String username,
            String password, int property_id) {
        super(property_id, surname, name, email, phone_number, 2, username, password);
        this.property_id = property_id;
    }

    // methods

    public int add_property(Property property) {
        
        int id = generateRandomId();

        // Execute SQL insert
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS)) {
            String sql = "INSERT INTO BienImmobilier (IDbien, Typebien, Taillebien, Prixbien, Localbien, Descbien, AgentID, PropriID) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Set parameters for the prepared statement
                pstmt.setInt(1, id);
                pstmt.setString(2, property.property_type.name());
                pstmt.setDouble(3, Property.Size);
                pstmt.setDouble(4, Property.price);
                pstmt.setString(5, Property.address);
                pstmt.setString(6, Property.description);
                pstmt.setInt(7, Property.assignedAgentid);
                pstmt.setInt(8, getProperty_id());

                // Execute the SQL query
                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Property added successfully. ID: " + id);
                    return id;
                } else {
                    System.out.println("Failed to add property.");
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add property.");
            return -1;
        }
    }

    public void remove_property(int property_id) {
        // Implementation for removing property
    }

    private int generateRandomId() {
        return (int) (Math.random() * 1000000); // Adjust range as needed
    }


    // getters and setters

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
}




