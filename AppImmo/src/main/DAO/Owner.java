package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DAO.*;
import main.DAO.Property;

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
                pstmt.setString(2, property.getPropertyType());
                pstmt.setDouble(3, property.getSize());
                pstmt.setDouble(4, property.getPrice());
                pstmt.setString(5, property.getAddress());
                pstmt.setString(6, property.getDescription());
                pstmt.setInt(7, property.getAssignedAgentid());
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

    
        // Implementation for removing property
    public static boolean remove_property(int property_id) {
            System.out.println(property_id);
            try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS)) {
                if (connection != null) {
                    try {
                        String query = "DELETE FROM BienImmobilier WHERE IDbien = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, property_id);
                        preparedStatement.executeUpdate();
                        return true; // Suppression réussie
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return false; // Suppression échouée
                    }
                } else {
                    System.out.println("Database connection is not established.");
                    return false; // Connexion échouée
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false; // Connexion échouée
            }
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




