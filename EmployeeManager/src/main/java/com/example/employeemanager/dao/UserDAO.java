package com.example.employeemanager.dao;

import com.example.employeemanager.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;
    private static final String INSERT_USER_SQL = "INSERT INTO users (firstName, familyName, email, phoneNumber, post, salaire) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM users";
    private static final String DELETE_USER_SQL = "DELETE FROM user WHERE id = ?";

//    public static void main(String[] args) {
//        Connection con = null; // Initialize the connection variable
//
//        try {
//            // Establish the connection to the database
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmanager", "root", "123456789");
//
//            // Check if the connection is successful
//            if (con != null) {
//                System.out.println("Database is connected");
//            }
//        } catch (SQLException e) {
//            // Handle7 any SQL exceptions
//            System.out.println("Not connected: " + e.getMessage());
//        } finally {
//            // Close the connection if it was established
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        }
//    }

    public void createUser(User user) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmanager", "root", "123456789");
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL))
        {
            preparedStatement.setString(1, user.getFamilyName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getPost());
            preparedStatement.setDouble(6, user.getSalaire());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmanager", "root", "123456789");
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery()){

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("firstName");
                    String prenom = resultSet.getString("familyName");
                    String email = resultSet.getString("email");
                    String numero = resultSet.getString("phoneNumber");
                    String poste = resultSet.getString("post");
                    double salaire = resultSet.getDouble("salaire");

                    User user = new User(nom, prenom, email, numero, poste, salaire);
                    user.setId(id);
                    users.add(user);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void deleteUser(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmanager", "root", "123456789");

        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}