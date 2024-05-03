package main.DAO;

enum property_type{
    STUDIO, F1, F2, F3, F4, F5, DUPLEXE, VILLA, CARCASS, COMMERCIAL, BUILDING, LAND; 
}

enum property_papers{
    NOTARIAL_ACT, REAL_ESTATE_PROMOTION, DECISION, REAL_ESTATE_BOOKLET,
     STAMBED_PAPERS, INDIVISION_ACT;
}

enum p_specifications{
    WATER, GAS, ELECTRCITY, GARAGE, GARDEN, FOURNISHED;
}

public class Property {

    public int id, assignedAgentid;
    public property_type property_type;
    public property_papers papers;
    public p_specifications specifications;
    public double Size;
    public String address;
    public String description;
    public double price, price_min; 


    //constructor
    public Property(int id, int assignedAgentid,
            double size, String address, String description, double price, double price_min) {
        this.id = id;
        this.assignedAgentid = assignedAgentid;
        Size = size;
        this.address = address;
        this.description = description;
        this.price = price;
        this.price_min = price_min;
    }
    //property_type, papers, specifications are in the setters instead of the constructor

    //constructeur 2
    public Property(int id) {
        this.id = id;
    }

    //methods 
    public int affecteproperty (int id){
        return id;
        //add later
    }

    //change this type later after enumeration
    public int searchproperty (String property_type){
        return assignedAgentid;
        //add later
    }

    public int searchproperty (double price){
        return assignedAgentid;
        //add later
    }

    //getters and setters
    public int getAssignedAgentid() {
        return assignedAgentid;
    }

    public void setAssignedAgentid(int assignedAgentid) {
        this.assignedAgentid = assignedAgentid;
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

    public void setproperty_Type (int t){
        switch (t) {
            case 0:
                this.property_type = property_type.STUDIO;
                break;
            case 1:
                this.property_type = property_type.F1;
                break;
            case 2:
                this.property_type = property_type.F2;
                break;
            case 3:
                this.property_type = property_type.F3;
                break;
            case 4:
                this.property_type = property_type.F4;
                break;
            case 5:
                this.property_type = property_type.F5;
                break;
            case 6:
                this.property_type = property_type.VILLA;
                break;
            case 7:
                this.property_type = property_type.BUILDING;
                break;
            case 8 :
                this.property_type = property_type.COMMERCIAL;
                break;
            case 9 :
                this.property_type = property_type.CARCASS;
                break;
            case 10 :
                this.property_type = property_type.DUPLEXE;
                break;
            case 11 :
                this.property_type = property_type.LAND;
                break;
            default:
                this.property_type = null;
                break;
        }
    }

    public property_type getProperty_type(){
        return this.property_type;
    }

    public void setpapers (int t){
        switch (t) {
            case 1:
                this.papers = property_papers.NOTARIAL_ACT;
                break;
            case 2:
                this.papers = property_papers.REAL_ESTATE_PROMOTION;
                break;
            case 3:
                this.papers = property_papers.DECISION;
                break;
            case 4:
                this.papers = property_papers.REAL_ESTATE_BOOKLET;
                break;
            case 5:
                this.papers = property_papers.STAMBED_PAPERS;
                break;
            case 6:
                this.papers = property_papers.INDIVISION_ACT;
                break;
            default:
                this.papers = null;
                break;
        }
    }

    public property_papers getpapers (){
        return this.papers;
    }

    public void setspecifications (int t){
        switch (t) {
            case 1:
                this.specifications = p_specifications.WATER;
                break;
            case 2:
                this.specifications = p_specifications.GAS;
                break;
            case 3:
                this.specifications = p_specifications.ELECTRCITY;
                break;
            case 4:
                this.specifications = p_specifications.GARAGE;
                break;
            case 5:
                this.specifications = p_specifications.GARDEN;
                break;
            case 6:
                this.specifications = p_specifications.FOURNISHED;
                break;
            default:
                this.specifications = null;
                break;
        }
    }

    public p_specifications getspecifications(int t){
        return this.specifications;
    }


    @Override
    public String toString() {
        return "Property [id=" + id + ", property_type=" + property_type + ", Size=" + Size + ", address=" + address
                + ", description=" + description + ", price=" + price + "]";
    }

    
}


