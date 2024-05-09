package main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import main.ui.LandingFrame;
import main.ui.LoginFrame;
import main.ui.InformationsFrame;

enum Type {
    OWNER, CLIENT, REAL_ESTATE_AGENT;
}

public class User {

    public Connection connection;
    public Statement statement;

    public int id;
    public String surname, name, email, phone_number;
    public Type type;
    public String username, password;
    public int id_generate;
    public int idall;

    // Constructor 1
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Constructor 2
    public User(int id, String surname, String name, String email, String phone_number, int t) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        switch (t) {
            case 1:
                this.type = Type.CLIENT;
                break;
            case 2:
                this.type = Type.OWNER;
                break;
            case 3:
                this.type = Type.REAL_ESTATE_AGENT;
                break;
            default:
                this.type = null;
                break;
        }
    }

    // Full constructor
    public User(int id, String surname, String name, String email, String phone_number, int t, String username, String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        switch (t) {
            case 1:
                this.type = Type.CLIENT;
                break;
            case 2:
                this.type = Type.OWNER;
                break;
            case 3:
                this.type = Type.REAL_ESTATE_AGENT;
                break;
            default:
                this.type = null;
                break;
        }
    }

// Full constructor
    public User( String surname, String name, String email, String phone_number, int t, String username,String password) {
 
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        switch (t) {
            case 1:
            this.type = Type.CLIENT;
            break;
            case 2:
            this.type = Type.OWNER;
            break;
            case 3:
            this.type = Type.REAL_ESTATE_AGENT;
            break;
            default:
            this.type = null;
            break;
        }
    }

    public User(String nom, String prenom, String email, String numtel) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", OracleAcc.USER, OracleAcc.PASS);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.surname = nom;
        this.name = prenom;
        this.email = email;
        this.phone_number = numtel;
    }
    

    // Methods

    public void modify() {
        // Later
    }

    public void remove(int id) {
        // Later
    }

    public void signup(String username, String password, String type1) throws SQLException {

       // boolean value = true

        // Generate a unique 7-digit ID
        Random rand = new Random();
        id_generate = rand.nextInt(9000000) + 1000000;
        int num = 0;

        // Retrieve the maximum number from the LOGIN table
        PreparedStatement ps = connection.prepareStatement("SELECT MAX(NUM) FROM LOGIN");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            num = rs.getInt(1);
        }

        // Insert user information into the LOGIN table
        String sql = "INSERT INTO login (nomutilisateur, motdepasse, id, NUM, typeuser) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id_generate);
            preparedStatement.setInt(4, num + 1);
            preparedStatement.setString(5, type1);

            // Execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while registering: " + e.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void signup(String nom, String prenom, String numtel, String email) {
        try {
            // Requête SQL pour obtenir le maximum de NUM dans LOGIN
            PreparedStatement ps = connection.prepareStatement("SELECT id, typeuser FROM LOGIN WHERE NUM = (SELECT MAX(NUM) FROM LOGIN)");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id_generate = rs.getInt(1); // Récupérer la valeur du maximum de NUM
                String userType = rs.getString(2); // Récupérer le type d'utilisateur
                switch (userType) {
                    case "OWNER":
                        // Insert into Proprietaire table
                        String sql1 = "INSERT INTO Proprietaire (IDpropr, Nompropr, Prenompropr, Emailpropr, telephonepropr) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
                            preparedStatement.setInt(1, id_generate);
                            preparedStatement.setString(2, nom);
                            preparedStatement.setString(3, prenom);
                            preparedStatement.setString(4, email);
                            preparedStatement.setString(5, numtel);
                            preparedStatement.executeUpdate();
                        }
                        break;
                    case "REAL_ESTATE_AGENT":
                        // Insert into AgentImm table
                        String sql2 = "INSERT INTO AgentImm (IDagent, NomAgent, PrenomAgent, EmailAgent, telephoneAgAJent) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)) {
                            preparedStatement.setInt(1, id_generate);
                            preparedStatement.setString(2, nom);
                            preparedStatement.setString(3, prenom);
                            preparedStatement.setString(4, email);
                            preparedStatement.setString(5, numtel);
                            preparedStatement.executeUpdate();
                        }
                        break;
                    case "CLIENT":
                        // Insert into Client table
                        String sql3 = "INSERT INTO Client (IDclient, NomClient, prenomClient,telephoneClient,EmailClient) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql3)) {
                            preparedStatement.setInt(1, id_generate);
                            preparedStatement.setString(2, nom);
                            preparedStatement.setString(3, prenom);
                            preparedStatement.setString(4, numtel);
                            preparedStatement.setString(5, email);
                            preparedStatement.executeUpdate();
                        }
                        break;
                    default:
                        System.err.println("Erreur : type d'utilisateur non reconnu");
                        System.out.println(userType);
                        break;
                }
            }
                    // Fermeture des ressources ResultSet et PreparedStatement
                    rs.close();
                    ps.close();
                    // Si l'insertion s'est bien passée, afficher le message de bienvenue et ouvrir la page de connexion
                    JOptionPane.showMessageDialog(null, "Welcome, " + nom + " " + prenom);
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL lors de l'inscription: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
            // Recharger la page InformationsFrame en cas d'erreur
            InformationsFrame informationsFrame = new InformationsFrame();
            informationsFrame.setVisible(true);
        }
    }

    public void login() {
        try {
            String sql = "SELECT * FROM login WHERE nomutilisateur = ? AND motdepasse = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("yes ");
                String sql1 = "SELECT id FROM LOGIN WHERE  nomutilisateur = ? AND motdepasse = ?";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setString(1, username);
                ps1.setString(2, password);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    System.out.println("catched");
                    idall = rs1.getInt("id");
                    System.out.println("catch the id done");
                }
                JOptionPane.showMessageDialog(null, "Successfully logged in");
                 // Open the main page after successful login
                new LandingFrame().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "User doesn't exist");
                new LoginFrame().setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while logging in: " + e.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static List<User> getAgents() {
        List<User> agents = new ArrayList<>();
        try {
            // Connexion à la base de données
           // Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "sabrine.123");

            // Requête SQL pour sélectionner les informations des agents
            String sql = "SELECT IDagent, NomAgent, PrenomAgent, EmailAgent, telephoneAgAJent FROM AgentImm ";

            // Préparation de la requête
            PreparedStatement statement = connection.prepareStatement(sql);

            // Exécution de la requête
            ResultSet resultSet = statement.executeQuery();

            // Parcours du résultat pour récupérer les agents
            while (resultSet.next()) {
                int id = resultSet.getInt("IDagent");
                String surname = resultSet.getString("NomAgent");
                String name = resultSet.getString("PrenomAgent");
                String email = resultSet.getString("EmailAgent");
                String phone_number = resultSet.getString("telephoneAgAJent");

                // Création de l'objet User correspondant à l'agent
                User agent = new User(id, surname, name, email, phone_number, 3);

                // Ajout de l'agent à la liste des agents
                agents.add(agent);
            }

            // Fermeture des ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de récupération des agents
        }
        return agents;
    }
    // Getters and setters

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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

    public int getId_generate() {
        return id_generate;
    }

    public void setId_generate(int id_generate) {
        this.id_generate = id_generate;
    }
}
