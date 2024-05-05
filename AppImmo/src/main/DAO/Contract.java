package main.DAO;

import java.util.Date;
import java.util.Random;

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
    public Contract(String agent_name, String agent_surname, double amount) {
        
        this.id = generateRandomId();

        this.duration = new Date ();

        this.agent_name = agent_name;
        this.agent_surname = agent_surname;
        this.amount = amount;
    }
    //those constructors don't containt type, it will be modified only by its setter

    private int generateRandomId (){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

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

