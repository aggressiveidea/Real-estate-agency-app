package main.DAO;

import java.sql.Time;
import java.util.Date;
import java.util.Random;;

public class Appointment {
    
    public int id, client_id, owner_id, agent_id; 
    public String property_address;
    public Date appointment_date;         
    public Time appointment_hour_deb;     
    public Time appointment_hour_fin;      


    // Constructeur 
    public Appointment(int client_id, Date date, int owner_id, int agent_id, String property_address, Time appointment_hour_deb, Time appointment_hour_fin) {
        
        this.id = generateRandomId();

        this.appointment_date = date;

        this.client_id = client_id;
        this.owner_id = owner_id;
        this.agent_id = agent_id;
        this.property_address = property_address;
        this.appointment_hour_deb = appointment_hour_deb;
        this.appointment_hour_fin = appointment_hour_fin;
    }

    //constructeur 2     
    public Appointment() {
        this.id = generateRandomId();
    }

    //necessary methods
    private int generateRandomId (){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

    private java.sql.Date SqlDate (Date utilDate){
        return new java.sql.Date (utilDate.getTime());
    }

    public java.sql.Date getSQLDate() {
        return SqlDate(this.appointment_date);
    }

    
    // getters and setters

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

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getProperty_address() {
        return property_address;
    }

    public void setProperty_address(String property_address) {
        this.property_address = property_address;
    }

    public Date getappointment_date() {
        return appointment_date;
    }

    public void setappointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public Time getappointment_hour_deb() {
        return appointment_hour_deb;
    }

    public void setappointment_hour_deb(Time appointment_hour_deb) {
        this.appointment_hour_deb = appointment_hour_deb;
    }

    public Time getappointment_hour_fin() {
        return appointment_hour_fin;
    }

    public void setappointment_hour_fin(Time appointment_hour_fin) {
        this.appointment_hour_fin = appointment_hour_fin;
    }

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", appointment_date=" + appointment_date + ", appointment_hour_deb=" + appointment_hour_deb
                + ", appointment_hour_fin=" + appointment_hour_fin + "]";
    }

}
