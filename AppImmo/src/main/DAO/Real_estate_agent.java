package main.DAO;

public class Real_estate_agent {
    
    public int property_id, transaction_id, appointment_id;

    //constructor
    public Real_estate_agent(int property_id, int transaction_id, int appointment_id) {
        this.property_id = property_id;
        this.transaction_id = transaction_id;
        this.appointment_id = appointment_id;
    }

    //methods
    public void remove_property (int property_id){
        //add later
    }

    public void modify_property (int property_id){
        //add later
    }

    public int add_appointment (int id, int client_id){
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
