package main.DAO;

public class Client extends User{

    //constructor 1
    public Client(String username, String password, int t) {
        super(username, password);
    }

    //constructor 2
    public Client(String surname, String name, String email, String phone_number) {
        super(id, surname, name, email, phone_number, 1);
    }

    //full constructor
    public Client(String surname, String name, String email, String phone_number, String username,
            String password) {
        super(id, surname, name, email, phone_number, 1, username, password);
    }
    
}