package main.DAO;



enum client_type {
    BUYER, TENANT;
}

public class Client extends User {

    private client_type clientType;

    // constructor 1
    public Client(String username, String password, int t) {
        super(username, password);
    }

    // constructor 2
    public Client(int id, String surname, String name, String email, String phone_number) {
        super(id, surname, name, email, phone_number, 1);
    }

    // full constructor
    public Client(int id, String surname, String name, String email, String phone_number, String username,
            String password) {
        super(id, surname, name, email, phone_number, 1, username, password);
    }

    // getters and setters
    public client_type getClientType() {
        return clientType;
    }

    public void setClientType(client_type clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "Client [clientType=" + clientType + "]";
    }

}
