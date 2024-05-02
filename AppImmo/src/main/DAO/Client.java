package main.DAO;

public class Client {
    
    public String client_type;

    //constructor
    public Client(boolean t) {
        if (t == true)
        this.client_type = "Buyer";
        else this.client_type = "Tenant";
    }

    public String getclient_type() {
        return client_type;
    }
    public void setclient_type(String client_type) {
        this.client_type = client_type;
    }

    @Override
    public String toString() {
        return "Client [client_type=" + client_type + "]";
    }

    
}