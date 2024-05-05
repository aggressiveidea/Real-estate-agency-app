import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

enum owner_type {
    LESSOR, SELLER;
}

public class Owner extends User {

    public owner_type ownertype;
    public int property_id;
    
    // constructor 1
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

    // constructor 2
    public Owner(int id, String surname, String name, String email, String phone_number, int property_id) {
        super(id, surname, name, email, phone_number, 2);
        this.property_id = property_id;
    }

    // full constructor
    public Owner(int id, String surname, String name, String email, String phone_number, String username,
            String password, int property_id) {
        super(id, surname, name, email, phone_number, 2, username, password);
        this.property_id = property_id;
    }

    // getters and setters
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

    // methods

    public int add_property(property_type typeproperty, String address) {
        // Generate random ID
        int id = generateRandomId();

        // Execute SQL insert
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "aldjia123")) {
            String sql = "INSERT INTO Proprietaire (IDpropr, Nompropr, Prenompropr, Emailpropr, telephonepropr) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Set parameters for the prepared statement
                pstmt.setInt(1, id);
                pstmt.setString(2, typeproperty.getNompropr());
                pstmt.setString(3, typeproperty.getPrenompropr());
                pstmt.setString(4, typeproperty.getEmailpropr());
                pstmt.setString(5, typeproperty.getTelephonepropr());

                // Execute the SQL query
                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Property added successfully. ID: " + id);
                    return id;
                } else {
                    System.out.println("Failed to add property.");
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add property.");
            return -1;
        }
    }

    public void remove_property(int property_id) {

    }

    private int generateRandomId() {
        return (int) (Math.random() * 1000000); // Adjust range as needed
    }

    @Override
    public String toString() {
        return "Proprietaire [ownertype=" + ownertype + "]";
    }

}



