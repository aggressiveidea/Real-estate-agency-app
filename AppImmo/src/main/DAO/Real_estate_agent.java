package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.ui.LandingFrame;

public class Real_estate_agent extends User{
    
    public int property_id, transaction_id, appointment_id;

    //constructor 1
    public Real_estate_agent(String username, String password, int property_id, int transaction_id,
            int appointment_id) {
        super(username, password);
        this.property_id = property_id;
        this.transaction_id = transaction_id;
        this.appointment_id = appointment_id;
    }

    //constructor 2
    public Real_estate_agent(String surname, String name, String email, String phone_number,
            int property_id, int transaction_id, int appointment_id) {
        super(appointment_id, surname, name, email, phone_number, 3);
        this.property_id = property_id;
        this.transaction_id = transaction_id;
        this.appointment_id = appointment_id;
    }

    //constructor 3
    public Real_estate_agent(String surname, String name, String email, String phone_number,
            String username, String password, int property_id, int transaction_id, int appointment_id) {
        super(appointment_id, surname, name, email, phone_number, 3, username, password);
        this.property_id = property_id;
        this.transaction_id = transaction_id;
        this.appointment_id = appointment_id;
    }

    //methods
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
    

    public void modify_property (int property_id){
        //add later
    }

    public int add_appointment (int id, int client_id,int owner_id){
        return client_id;
        // add later
    }

    public void remove_appointment (int appointment_id){
        //add later
    }

    public void remove_transaction (int transaction_id){
        //add later
    }

    //change this type later after enumeration
    public int add_transaction (int id, String type){
        return id;
        //add later
    }

    //getters and setters
    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }
    
    
}
