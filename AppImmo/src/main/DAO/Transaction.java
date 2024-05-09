package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import main.ui.OracleAcc;

enum transaction_type{
    RENT, BUY;
}

public class Transaction {

    public int id, property_id, agent_id, client_id, owner_id, contract_id, payment_id;
    public transaction_type type;
    public Date date;
    public double cost;

    //constructor
    public Transaction(int property_id, int agent_id, int client_id, int owner_id, int contract_id,
            int payment_id, double cost) {
        
        this.id = generateRandomId();

        this.date = new Date();

        this.property_id = property_id;
        this.agent_id = agent_id;
        this.client_id = client_id;
        this.owner_id = owner_id;
        this.contract_id = contract_id;
        this.payment_id = payment_id;
        this.cost = cost;
    }

    //constructor 2
    public Transaction (){
        this.id = generateRandomId();
        this.date = new Date();
    }
    //type in the setter instead of the constructors

    //necessary methods
    private int generateRandomId (){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }  

    private java.sql.Date SqlDate (Date utilDate){
        return new java.sql.Date (utilDate.getTime());
    }

    //class methods
    public int generate_contract(int id){
        return id;
        //add later
    }

    public int add_payment (double cost){
       
        Payment pay = new Payment(this.id, cost);
        this.payment_id = pay.id;

        //SQL insert
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);

            String sql = "INSERT INTO Payment (ID, Amount, DatePay) VALUES (?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, this.payment_id);
            pstmt.setDouble(2, cost);
            pstmt.setDate(3,SqlDate(this.date));

            // Execute query
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Transaction added successfully", "NOTE",JOptionPane.PLAIN_MESSAGE);
                return pay.id;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Payment", "ERROR 1",JOptionPane.ERROR_MESSAGE);
                return -1;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to add Payment", "ERROR 2",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public transaction_type getType() {
        return type;
    }

    public void settype (int t){
        switch (t) {
            case 1:
                this.type = transaction_type.RENT;
                break;
            case 2:
                this.type = transaction_type.BUY;
                break;
            default:
                this.type = null;
                break;
        }
    }

    public Date getDate() {
        return date;
    }

    public Date getSQLDate() {
        return SqlDate(this.date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    
}

