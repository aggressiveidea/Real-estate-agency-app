package main.DAO;

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
    public Property(int id, int assignedAgentid,
            double size, String address, String description, double price, double price_min) {
        this.id = id;
        this.assignedAgentid = assignedAgentid;
        this.Size = size;
        this.address = address;
        this.description = description;
        this.price = price;
        this.price_min = price_min;
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
}



