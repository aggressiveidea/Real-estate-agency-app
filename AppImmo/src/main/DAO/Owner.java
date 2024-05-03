package main.DAO;

public class Owner {

    public String owner_type; //change this type after enumeration
    public int property_id;

    //constructor   
    public Owner (boolean t, int perperty_id) {
        
        this.property_id = property_id;
        // if the condition is true, then the owner is a seller, or else he's a lessor
       if (t) {
        this.owner_type = "Seller";
        } else {
        this.owner_type = "Lessor";
        }
    }

   //getters and setters
    public String getowner_type() {
        return owner_type;
    }

    public void setowner_type(String owner_type) {
        this.owner_type = owner_type;
    }

   public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    //methods
    
    //change type after enumeration
    public int add_property (int id, String property_type, String address){
        // add later
    }

    public void remove_property (int perperty_id){
        // add later
    }

    @Override 
    public String toString() {
        return "Proprietaire [owner_type=" + owner_type + "]";
    }

   
}

