/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserDAO;

import com.mycompany.mavenproject1.config.DBconnection;
import com.mycompany.mavenproject1.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yash
 */
public class UsersDAO {

    private static UsersDAO instance;

    private UsersDAO() {

    }

    public static synchronized UsersDAO getInstance() {
        if (instance == null) {
            instance = new UsersDAO();

        }

        return instance;
    }

    public int saveRegisteredUser(UserModel user) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement userInsertStatement = null;
        PreparedStatement registeredUserInsertStatement = null;
        ResultSet generatedKeys = null;
        int result = 0; // 0 represents failure by default

        try {
            // Insert into User table
            userInsertStatement = connection.prepareStatement("INSERT INTO User (Username) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            userInsertStatement.setString(1, user.getUsername());
            userInsertStatement.executeUpdate();

            // Get the generated UserID
            generatedKeys = userInsertStatement.getGeneratedKeys();
            int userId = -1;
            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1);
            }

            // Insert into Registered_User table
            registeredUserInsertStatement = connection.prepareStatement("INSERT INTO Registered_User (Name, Phone, Email, Password, Address, UserID) VALUES (?, ?, ?, ?, ?, ?)");
            registeredUserInsertStatement.setString(1, user.getName());
            registeredUserInsertStatement.setString(2, user.getPhone());
            registeredUserInsertStatement.setString(3, user.getEmail());
            registeredUserInsertStatement.setString(4, user.getPassword());
            registeredUserInsertStatement.setString(5, user.getAddress());
            registeredUserInsertStatement.setInt(6, userId);
            result = registeredUserInsertStatement.executeUpdate(); // Update result with the executeUpdate() return value

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (userInsertStatement != null) {
                try {
                    userInsertStatement.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (registeredUserInsertStatement != null) {
                try {
                    registeredUserInsertStatement.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return result; // Return 1 for success, 0 for failure
    }

    public String checkLogin(String email, String password) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String username = null;

        try {
            // Query to select username based on email and password
            String query = "SELECT u.Username "
                    + "FROM User u "
                    + "JOIN Registered_User ru ON u.UserID = ru.UserID "
                    + "WHERE ru.Email = ? AND ru.Password = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            // Check if a row is returned
            if (resultSet.next()) {
                username = resultSet.getString("Username");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

        return username;
    }

}
