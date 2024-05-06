package main.DAO;

import java.util.Random;

public class Property {

    public int id;
    public static int assignedAgentid;
    public property_type property_type;
    public property_papers papers;
    public p_specifications specifications;
    public static double Size;
    public static String address;
    public static String description;
    public static double price;
    public double price_min;

    // Constructor
    public Property(int assignedAgentid,
            double size, String address, String description, double price, double price_min) {
        
        this.id = generateRandomId();

        Property.assignedAgentid = assignedAgentid;
        Property.Size = size;
        Property.address = address;
        Property.description = description;
        Property.price = price;
        this.price_min = price_min;
    }

    public Property(String address2, String type, double price2, double size2, String description2, double minPrice,
            String papers2, String specifications2) {
        //TODO Auto-generated constructor stub
    }

    private int generateRandomId (){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

    //methods
    public int affecteproperty(int id) {
        return id;
        // add later
    }

    public int searchproperty(String property_type) {
        return assignedAgentid;
        // add later
    }

    public int searchproperty(double price) {
        return assignedAgentid;
        // add later
    }

    // Getter and Setter methods

    public int getId() {
        return id;
    }

    public static double getSize() {
        return Size;
    }

    public static String getAddress() {
        return address;
    }

    public static String getDescription() {
        return description;
    }

    public static double getPrice() {
        return price;
    }

    public static int getAssignedAgentid() {
        return assignedAgentid;
    }

    public static void setAssignedAgentid(int assignedAgentid) {
        Property.assignedAgentid = assignedAgentid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(double size) {
        Size = size;
    }

    public void setAddress(String address) {
        Property.address = address;
    }

    public void setDescription(String description) {
        Property.description = description;
    }

    public void setPrice(double price) {
        Property.price = price;
    }

    public void setPrice_min(double price_min) {
        this.price_min = price_min;
    }

    public property_type getProperty_type() {
        return property_type;
    }

    public void setProperty_type(property_type property_type) {
        this.property_type = property_type;
    }

    public property_papers getPapers() {
        return papers;
    }

    public void setPapers(property_papers papers) {
        this.papers = papers;
    }

    public p_specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(p_specifications specifications) {
        this.specifications = specifications;
    }

    // Nested enum classes
    enum property_type {
        STUDIO, F1, F2, F3, F4, F5, DUPLEXE, VILLA, CARCASS, COMMERCIAL, BUILDING, LAND;
    }

    enum property_papers {
        NOTARIAL_ACT, REAL_ESTATE_PROMOTION, DECISION, REAL_ESTATE_BOOKLET, STAMBED_PAPERS, INDIVISION_ACT;
    }

    enum p_specifications {
        WATER, GAS, ELECTRICITY, GARAGE, GARDEN, FURNISHED;
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", property_type=" + property_type + ", Size=" + Size + ", address=" + address
                + ", description=" + description + ", price=" + price + "]";
    }

    public void setType(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setType'");
    }
}



