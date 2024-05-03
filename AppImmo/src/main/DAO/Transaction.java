package main.DAO;

import java.sql.Date;

enum transaction_type{
    RENT, BUY;
}

public class Transaction {

    public int id, property_id, agent_id, client_id, owner_id, contract_id, payment_id;
    public transaction_type type;
    public Date date;
    public double cost;

    //constructor
    public Transaction(int id, int property_id, int agent_id, int client_id, int owner_id, int contract_id,
            int payment_id, Date date, double cost) {
        this.id = id;
        this.property_id = property_id;
        this.agent_id = agent_id;
        this.client_id = client_id;
        this.owner_id = owner_id;
        this.contract_id = contract_id;
        this.payment_id = payment_id;
        this.date = date;
        this.cost = cost;
    }
    //type in the setter instead of the constructor

    //methods
    public int generate_contract(int id){
        return id;
        //add later
    }

    public int add_payment (int id, double cost){
        return id;
        //add later
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
