package main.DAO;

import java.util.Date;

enum contract_type{
    PURCHASE_AGREEMENT_CONTRACT, LEASE_AGREEMENTS;
}

public class Contract {
    
    public int id, client_id, payment_id, owner_id, agent_id;
    public String client_name, client_surname, client_email, client_phone,client_address;
    public String owner_name, owner_surname, owner_email, owner_phone, owner_address;
    public String agent_name, agent_surname;
    public Date duration;
    public double amount;
    public contract_type type;

    
    //construtor 1
    public Contract(int id, String agent_name, String agent_surname, Date duration, double amount) {
        this.id = id;
        this.agent_name = agent_name;
        this.agent_surname = agent_surname;
        this.duration = duration;
        this.amount = amount;
    }
    //those constructors don't containt type, it will be modified only by its setter

    //empty constructor
    public Contract() {
    }

    //getters and setters
    public void setType(int t){
        switch (t) {
            case 1:
                this.type = contract_type.PURCHASE_AGREEMENT_CONTRACT;
                break;
            case 2:
                this.type = contract_type.LEASE_AGREEMENTS;
                break;
            default:
                break;
        }
    }

    public contract_type getType (contract_type type){
        return this.type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getduration() {
        return duration;
    }

    public void setduration(Date duration) {
        this.duration = duration;
    }

    public double getamount() {
        return amount;
    }

    public void setamount(double amount) {
        this.amount = amount;
    }

   
}

