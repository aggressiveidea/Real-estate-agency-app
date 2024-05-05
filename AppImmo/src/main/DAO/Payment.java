package main.DAO;

import java.util.Date;
import java.util.Random;

public class Payment {
    
    public int id, transaction_id;
    public double amount;
    public Date date;

    //constructor
    public Payment(int transaction_id, double amount) {
        
        this.id = generateRandomId();

        this.date = new Date();

        this.transaction_id = transaction_id;
        this.amount = amount;
    }

    private int generateRandomId (){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
