package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

public class Interaction {
    
    public int id, client_id, property_id;
    public Date date;
    public Time hour;
    public String details;

    //constructor 1
    public Interaction(int client_id, int property_id, Time hour, String details) {
        
        this.id = generateRandomId();

        this.date = new Date();

        this.client_id = client_id;
        this.property_id = property_id;
        this.hour = hour;
        this.details = details;
    }
    
    //constructor 2
    public Interaction() {
        this.id = generateRandomId();
    }
 
    private int generateRandomId (){
        Random rand = new Random();
        return rand.nextInt(1000000);
    } 
    
    private java.sql.Date SqlDate (Date utilDate){
        return new java.sql.Date (utilDate.getTime());
    }

    //methodes
    public void AddInteraction ()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

            String sql = "INSERT INTO Interaction (ID,Dateintr,Descriptioninter) VALUES (?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, this.id);
            pstmt.setDate(2, SqlDate(this.date));
            pstmt.setString(3, this.details);

            // Execute query
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Interaction added successfully", "NOTE",JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Interaction", "ERROR 1",JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to add Interaction", "ERROR 2",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void RemoveInteraction(int id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
    
            String sql = "DELETE FROM Interaction WHERE ID = ?";
    
            PreparedStatement pstmt = conn.prepareStatement(sql);
    
            pstmt.setInt(1, id);
    
            // Execute query
            int rowsDeleted = pstmt.executeUpdate();
    
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Interaction deleted successfully", "NOTE", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete Interaction: Interaction not found", "ERROR 1", JOptionPane.ERROR_MESSAGE);
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete Interaction", "ERROR 2", JOptionPane.ERROR_MESSAGE);
        }
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time gethour() {
        return hour;
    }

    public void sethour(Time hour) {
        this.hour = hour;
    }

    public String getdetails() {
        return details;
    }

    public void setdetails(String details) {
        this.details = details;
    }
    
}
