package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Property {

    public int id;
    public int assignedAgentid;
    public PropertyType propertyType;
    private PropertyPapers papers;
    private PSpecifications specifications;
    public double size;
    public double price;
    private double priceMin;
    public String address;
    public String description;
    private String ownerName;
    private String ownerPhone;
    private String ownerEmail;
    public int ownerid;

    // Constructors
    public Property(int assignedAgentid, double size, String address, String description, double price, double priceMin) {
        this.id = generateRandomId();
        this.assignedAgentid = assignedAgentid;
        this.size = size;
        this.address = address;
        this.description = description;
        this.price = price;
        this.priceMin = priceMin;
    }

    public Property(String type, String papers, String specifications) {
        this.propertyType = PropertyType.valueOf(type);
        this.papers = PropertyPapers.valueOf(papers);
        this.specifications = PSpecifications.valueOf(specifications);
    }

    public Property(int propId, String address, String description, double price, PropertyType type, String ownerName, String ownerPhone, String ownerEmail,int id) {
        this.ownerid = propId;
        this.address = address;
        this.description = description;
        this.price = price;
        this.propertyType = type;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerEmail = ownerEmail;
        this.id = id;
    }

    private int generateRandomId() {
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

    // Getter and Setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignedAgentid() {
        return assignedAgentid;
    }

    public void setAssignedAgentid(int assignedAgentid) {
        this.assignedAgentid = assignedAgentid;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getAddress() {
        return address.toString();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

      public String getOwnerId() {
        return ownerEmail;
    }

    public void setOwnerId(int ownerid) {
        this.id = ownerid;
    }

    public String getPropertyType() {
        return propertyType.name();
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public PropertyPapers getPapers() {
        return papers;
    }

    public void setPapers(PropertyPapers papers) {
        this.papers = papers;
    }

    public PSpecifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(PSpecifications specifications) {
        this.specifications = specifications;
    }

    public static List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS)) {
            System.out.println("Database connection established.");
              String sql = "SELECT b.Typebien, b.Prixbien, b.Localbien, b.Descbien, p.IDpropr, p.Nompropr, p.Prenompropr, p.Emailpropr, p.Telephonepropr,b.IDbien " +
                         "FROM BienImmobilier b " +
                         "JOIN Proprietaire p ON b.PropriID = p.IDpropr";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                System.out.println("Executing query: " + sql);
                ResultSet resultSet = statement.executeQuery();

                int rowCount = 0;
                while (resultSet.next()) {
                    rowCount++;
                    String type = resultSet.getString("Typebien").trim();;
                    double price = resultSet.getDouble("Prixbien");
                    String address = resultSet.getString("Localbien");
                    String description = resultSet.getString("Descbien");
                    int propId = resultSet.getInt("IDpropr");
                    String ownerName = resultSet.getString("Nompropr") + " " + resultSet.getString("Prenompropr");
                    String ownerPhone = resultSet.getString("Telephonepropr");
                    String ownerEmail = resultSet.getString("Emailpropr");
                    int propretyId = resultSet.getInt("IDbien");
                    System.out.println("Property ID: " + propretyId + ", Type: " + type);
    
                    try {
                        PropertyType propertyType = PropertyType.valueOf(type);
                        Property property = new Property(propId, address, description, price, propertyType, ownerName, ownerPhone, ownerEmail, propretyId);
                        properties.add(property);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Erreur de conversion du type de propriété : '" + type + "'");
                        e.printStackTrace();
                    }
                }
                System.out.println("Number of rows retrieved: " + rowCount);

                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }

    // Nested enum classes
    public enum PropertyType {
        STUDIO, F1, F2, F3, F4, F5, DUPLEXE, VILLA, CARCASS, COMMERCIAL, BUILDING, LAND;
    }

    public enum PropertyPapers {
        NOTARIAL_ACT, REAL_ESTATE_PROMOTION, DECISION, REAL_ESTATE_BOOKLET, STAMPED_PAPERS, INDIVISION_ACT;
    }

    public enum PSpecifications {
        WATER, GAS, ELECTRICITY, GARAGE, GARDEN, FURNISHED;
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", propertyType=" + propertyType + ", size=" + size + ", address=" + address
                + ", description=" + description + ", price=" + price + ", ownerName=" + ownerName + ", ownerPhone=" + ownerPhone + ", ownerEmail=" + ownerEmail + "]";
    }

    public static void main(String[] args) {
        List<Property> properties = getProperties();
        for (Property property : properties) {
            System.out.println(property);
        }
    }
}
