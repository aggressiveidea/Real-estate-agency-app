package main.DAO;

enum client_type{
    BUYER, TENANT;
}

public class Client extends User{
    
    public client_type clienttype;

    //constructor 1
    public Client(String username, String password, int t) {
        super(username, password);
        switch (t) {
            case 1:
                this.clienttype = client_type.BUYER;
                break;
            case 2:
                this.clienttype = client_type.TENANT;
                break;
            default:
                break;
        }
    }

    //constructor 2
    public Client(int id, String surname, String name, String email, String phone_number) {
        super(id, surname, name, email, phone_number, 1);
    }

    //full constructor
    public Client(int id, String surname, String name, String email, String phone_number, String username,
            String password) {
        super(id, surname, name, email, phone_number, 1, username, password);
    }

    //setters and getters
    public client_type getclient_type() {
        return clienttype;
    }
    public void setclient_type(client_type clienttype) {
        this.clienttype = clienttype;
    }

    @Override
    public String toString() {
        return "Client [client_type=" + clienttype + "]";
    }

    
}