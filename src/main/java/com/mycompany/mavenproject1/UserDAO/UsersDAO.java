/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserDAO;

import com.mycompany.mavenproject1.config.DBconnection;
import com.mycompany.mavenproject1.model.Rating;
import com.mycompany.mavenproject1.model.UserModel;
import com.mycompany.mavenproject1.model.Vehicle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
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
        CallableStatement procedureCall = null;
        int result = 0; // 0 represents failure by default

        try {
            // Prepare the call to the stored procedure
            procedureCall = connection.prepareCall("{CALL Create_New_Registered_User(?, ?, ?, ?, ?, ?, ?)}");

            // Set the input parameters
            procedureCall.setString(1, user.getName());
            procedureCall.setString(2, user.getPhone());
            procedureCall.setString(3, user.getEmail());
            procedureCall.setString(4, user.getPassword());
            procedureCall.setString(5, user.getAddress());

            // Register output parameters
            procedureCall.registerOutParameter(6, Types.VARCHAR); // Username
            procedureCall.registerOutParameter(7, Types.BOOLEAN); // Success

            // Execute the stored procedure
            procedureCall.execute();

            // Retrieve output parameters
            String username = procedureCall.getString(6);
            boolean success = procedureCall.getBoolean(7);

            if (success) {
                result = 1; // Success
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources
            if (procedureCall != null) {
                try {
                    procedureCall.close();
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
        CallableStatement procedureCall = null;
        ResultSet resultSet = null;
        String username = null;

        try {
            // Prepare the call to the stored procedure
            procedureCall = connection.prepareCall("{CALL User_Login(?, ?, ?)}");

            // Set the input parameters
            procedureCall.setString(1, email);
            procedureCall.setString(2, password);

            // Register output parameters
            procedureCall.registerOutParameter(3, Types.VARCHAR); // Username

            // Execute the stored procedure
            procedureCall.execute();

            // Retrieve output parameters
            username = procedureCall.getString(3);

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
            if (procedureCall != null) {
                try {
                    procedureCall.close();
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

    public List<String> checkLogin(String username) {
        // Connection variables
        Connection connection = null;
        CallableStatement procedureCall = null;
        List<String> result = new ArrayList<>();

        try {
            // Establish connection
            connection = DBconnection.getConnection();

            // Prepare the call to the stored procedure
            procedureCall = connection.prepareCall("{CALL Insert_Non_Registered_User(?, ?)}");

            // Set the input parameter
            procedureCall.setString(1, username);

            // Register the output parameter
            procedureCall.registerOutParameter(1, java.sql.Types.VARCHAR);
            procedureCall.registerOutParameter(2, java.sql.Types.INTEGER);

            // Execute the stored procedure
            procedureCall.execute();

            // Get the output parameters
            String updatedUsername = procedureCall.getString(1);
            int userID = procedureCall.getInt(2);

            result.add(userID + "");
            result.add(updatedUsername);
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                // Return null if duplicate username is encountered
                return null;
            } else {
                // Handle other SQL exceptions
                e.printStackTrace();
            }
        } finally {
            try {
                if (procedureCall != null) {
                    procedureCall.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean deleteAnomUser(int userID) {
        // Connection variables
        Connection connection = null;
        CallableStatement procedureCall = null;
        boolean success = false;

        try {
            // Establish connection
            connection = DBconnection.getConnection();

            // Prepare the call to the stored procedure
            procedureCall = connection.prepareCall("{CALL Delete_User(?)}");

            // Set the input parameter
            procedureCall.setInt(1, userID);

            // Execute the stored procedure
            success = procedureCall.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return success;
        } finally {
            // Close resources
            try {
                if (procedureCall != null) {
                    procedureCall.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    public boolean addVehicle(String vehicleNumber, int year, String manufacturer, String model,
            String color, String vehicleCategory, String email) {
        try (Connection connection = DBconnection.getConnection(); CallableStatement procedureCall = connection.prepareCall("{CALL AddVehicle(?, ?, ?, ?, ?, ?, ?)}")) {

            // Set the input parameters
            procedureCall.setString(1, vehicleNumber);
            procedureCall.setInt(2, year);
            procedureCall.setString(3, manufacturer);
            procedureCall.setString(4, model);
            procedureCall.setString(5, color);
            procedureCall.setString(6, vehicleCategory);
            procedureCall.setString(7, email);

            // Execute the stored procedure
            procedureCall.execute();

            // If execution completes without exception, return true
            return true;

        } catch (SQLException ex) {
            // Handle exceptions
            ex.printStackTrace();
            // You can throw a custom exception or return false indicating failure
            return false;
        }
    }

    public boolean addRating(String vehicleNumber, boolean goodRating, boolean badRating,
            byte[] picture, String comment, double latitude, double longitude) {
        try (Connection connection = DBconnection.getConnection(); CallableStatement procedureCall = connection.prepareCall("{CALL AddRating(?, ?, ?, ?, ?, ?, ?)}")) {

            // Set the input parameters
            procedureCall.setString(1, vehicleNumber);
            procedureCall.setBoolean(2, goodRating);
            procedureCall.setBoolean(3, badRating);
            procedureCall.setBytes(4, picture);
            procedureCall.setString(5, comment);
            procedureCall.setDouble(6, latitude);
            procedureCall.setDouble(7, longitude);

            // Execute the stored procedure
            procedureCall.execute();

            // If execution completes without exception, return true
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Vehicle> getAllVehiclesForUser(String email) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT v.*, d.TotalRating AS TotalRating "
                + "FROM Vehicle v "
                + "JOIN Registered_User ru ON v.RegID = ru.RegID "
                + "JOIN Driver d ON v.VehicleNumber = d.VehicleNumber "
                + "WHERE ru.Email = ?")) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String vehicleNumber = resultSet.getString("VehicleNumber");
                int year = resultSet.getInt("Year");
                String manufacturer = resultSet.getString("Manufacturer");
                String model = resultSet.getString("Model");
                String color = resultSet.getString("Color");
                String category = resultSet.getString("VehicleCategory");
                String rating = resultSet.getString("TotalRating");
                Vehicle vehicle = new Vehicle(vehicleNumber, String.valueOf(year), manufacturer, model, color, category, rating);
                vehicles.add(vehicle);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Rating> searchRatingsBySubstring(String substring) {
        List<Rating> ratings = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection(); CallableStatement procedureCall = connection.prepareCall("{CALL SearchRatings(?)}")) {
            procedureCall.setString(1, substring);
            ResultSet resultSet = procedureCall.executeQuery();

            while (resultSet.next()) {
                int ratingId = resultSet.getInt("RatingID");
                boolean goodRating = resultSet.getBoolean("GoodRating");
                boolean badRating = resultSet.getBoolean("BadRating");
                // Omit Picture retrieval as it's a BLOB
                String comment = resultSet.getString("Comment");
                int driverId = resultSet.getInt("DriverID");
                String vehicleNumber = resultSet.getString("VehicleNumber");
                Timestamp ratingTimestamp = resultSet.getTimestamp("RatingTimestamp");
                double latitude = resultSet.getDouble("Latitude");
                double longitude = resultSet.getDouble("Longitude");

                Rating rating = new Rating(ratingId, goodRating, badRating, null, comment, driverId, vehicleNumber, ratingTimestamp, latitude, longitude);
                ratings.add(rating);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ratings;
    }

    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(
                "SELECT RatingID, GoodRating, BadRating, Comment, DriverID, VehicleNumber, RatingTimestamp, Latitude, Longitude "
                + "FROM Rating "
                + "ORDER BY RatingTimestamp DESC")) {

            while (resultSet.next()) {
                int ratingId = resultSet.getInt("RatingID");
                boolean goodRating = resultSet.getBoolean("GoodRating");
                boolean badRating = resultSet.getBoolean("BadRating");
                String comment = resultSet.getString("Comment");
                int driverId = resultSet.getInt("DriverID");
                String vehicleNumber = resultSet.getString("VehicleNumber");
                Timestamp timestamp = resultSet.getTimestamp("RatingTimestamp");
                double latitude = resultSet.getDouble("Latitude");
                double longitude = resultSet.getDouble("Longitude");

                // Create a Rating object and add it to the list
                Rating rating = new Rating(ratingId, goodRating, badRating, comment, driverId, vehicleNumber, timestamp, latitude, longitude);
                ratings.add(rating);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ratings;
    }

    // Function to get worst vehicles along with their negative votes
    public Map<String, Integer> getWorstVehiclesWithNegativeVotes() {
        Map<String, Integer> worstVehicles = new HashMap<>();

        try (Connection connection = DBconnection.getConnection(); CallableStatement statement = connection.prepareCall("{CALL GetWorstVehicles()}")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String vehicleNumber = resultSet.getString("VehicleNumber");
                int negativeVotes = resultSet.getInt("NegativeVotes");
                worstVehicles.put(vehicleNumber, negativeVotes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return worstVehicles;
    }

    // Function to get best vehicles along with their good votes
    public Map<String, Integer> getBestVehiclesWithGoodVotes() {
        Map<String, Integer> bestVehicles = new HashMap<>();

        try (Connection connection = DBconnection.getConnection(); CallableStatement statement = connection.prepareCall("{CALL GetBestVehicles()}")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String vehicleNumber = resultSet.getString("VehicleNumber");
                int goodVotes = resultSet.getInt("GoodVotes");
                bestVehicles.put(vehicleNumber, goodVotes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return bestVehicles;
    }
}
