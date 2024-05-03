package main.DAO;

enum owner_type{
    LESSOR, SELLER;
}

public class Owner extends User{

    public owner_type ownertype;
    public int property_id;

    //constructor 1
    public Owner(String username, String password, owner_type ownertype, int property_id) {
        super(username, password);
        this.ownertype = ownertype;
        this.property_id = property_id;
    }

    //constructor 2
    public Owner(int id, String surname, String name, String email, String phone_number, String type,
            owner_type ownertype, int property_id) {
        super(id, surname, name, email, phone_number, type);
        this.ownertype = ownertype;
        this.property_id = property_id;
    }

    //full constructor
    public Owner(int id, String surname, String name, String email, String phone_number, String type, String username,
            String password, owner_type ownertype, int property_id) {
        super(id, surname, name, email, phone_number, type, username, password);
        this.ownertype = ownertype;
        this.property_id = property_id;
    }

    //getters and setters
    public owner_type getownertype() {
        return ownertype;
    }

    public void setownertype(owner_type ownertype) {
        this.ownertype = ownertype;
    }

   public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    //methods

    public int add_property (int id, property_type typeproperty, String address){
        // add later
    }

    public void remove_property (int perperty_id){
        // add later
    }

    @Override 
    public String toString() {
        return "Proprietaire [ownertype=" + ownertype + "]";
    }

   
}

