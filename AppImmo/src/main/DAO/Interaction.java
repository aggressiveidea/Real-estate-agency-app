package main.DAO;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Interaction {
    
    public int id, client_id, property_id;
    public Date date;
    public Time hour;
    public String details;

    //constructor 1
    public Interaction(int id, int client_id, int property_id, Date date, Time hour, String details) {
        this.id = id;
        this.client_id = client_id;
        this.property_id = property_id;
        this.date = date;
        this.hour = hour;
        this.details = details;
    }
    
    //constructor 2
    public Interaction(int id2) {
        this.id = id2;
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

    //methodes
    public void AddInteraction ()
    {
        //for later
    }

    public void RemoveInteraction (int id)
    {
        //for later
    }
    
}
