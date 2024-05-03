package main.DAO;

public class Property {
    
    public int id, assignedAgentid;
    public String property_type, papers, specifications; //change all these 3 types later after adding enumeration
    public double Size;
    public String address;
    public String description;
    public double price, price_min;


    //constructor
    public Property(int id, int assignedAgentid, String property_type, String papers, String specifications,
            double size, String address, String description, double price, double price_min) {
        this.id = id;
        this.assignedAgentid = assignedAgentid;
        this.property_type = property_type;
        this.papers = papers;
        this.specifications = specifications;
        Size = size;
        this.address = address;
        this.description = description;
        this.price = price;
        this.price_min = price_min;
    }

    //constructeur 2
    public Property(int id) {
        this.id = id;
    }

    //methods 
    public int affecteproperty (int id){
        //add later
    }

    //change this type later after enumeration
    public int searchproperty (String property_type){
        //add later
    }

    public int searchproperty (double price){
        //add later
    }

    //getters and setters
    public int getAssignedAgentid() {
        return assignedAgentid;
    }

    public void setAssignedAgentid(int assignedAgentid) {
        this.assignedAgentid = assignedAgentid;
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public double getPrice_min() {
        return price_min;
    }

    public void setPrice_min(double price_min) {
        this.price_min = price_min;
    }

    public int getId() {
        return id;
    }

    public String getproperty_type() {
        return property_type;
    }

    public double getSize() {
        return Size;
    }

    public String getaddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public double getprice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setproperty_type(String property_type) {
        this.property_type = property_type;
    }

    public void setSize(double Size) {
        this.Size = Size;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setprice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Property [id=" + id + ", property_type=" + property_type + ", Size=" + Size + ", address=" + address
                + ", description=" + description + ", price=" + price + "]";
    }

    
}


