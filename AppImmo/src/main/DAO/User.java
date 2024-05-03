package main.DAO;

public class User {

    public int id;
    public String surname, name, email, phone_number;
    public String type; //change this type later after enumeration
    public String username, password;

    //consructor 1
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //constructor 2
    public User(int id, String surname, String name, String email, String phone_number, String type) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.type = type;
    }

    //full constructor
    public User(int id, String surname, String name, String email, String phone_number, String type, String username,
            String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    //methods

    public void modify (){
        //later
    }

    public void remove (int id){
        //later
    }

    public void signup (){
        //for later
    }

    public void login (){
        //for later
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
