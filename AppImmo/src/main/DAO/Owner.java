package main.DAO;

enum owner_type{
    LESSOR, SELLER;
}

public class Owner extends User{

    public owner_type ownertype;
    public int property_id;


    //constructor 1
    public Owner(String username, String password, int t, int property_id) {
        super(username, password);
        this.property_id = property_id;
        switch (t) {
            case 1:
                this.ownertype = owner_type.LESSOR;
                break;
            case 2:
                this.ownertype = owner_type.SELLER;
                break;
            default:
                break;
        }
    }

    //constructor 2
    public Owner(int id, String surname, String name, String email, String phone_number,int property_id) {
        super(id, surname, name, email, phone_number, 2);
    }

    //full constructor
    public Owner(int id, String surname, String name, String email, String phone_number, String username,
            String password, int property_id) {
        super(id, surname, name, email, phone_number, 2, username, password);
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

