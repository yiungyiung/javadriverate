/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserService;

import com.mycompany.mavenproject1.model.Rating;
import com.mycompany.mavenproject1.model.Vehicle;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yash
 */
public interface UsersService {

    int register(String name, String Password, String address, String email, String Phone, String Username);

    String login(String email, String Password);

    List<String> anomlogin(String username);

    boolean deleteAnomUser(String userID);

    public boolean addVehicle(String vehicleNumber, int year, String manufacturer, String model, String color, String vehicleCategory, String email);

    public boolean addRating(String vehicleNumber, boolean goodRating, boolean badRating,
            byte[] picture, String comment, double latitude, double longitude);
    public List<Vehicle> getAllVehiclesForUser(String email) ;
    public List<Rating> searchRatingsBySubstring(String substring);
    public List<Rating> getAllRatings();
    public Map<String, Integer> getBestVehiclesWithGoodVotes();
    public Map<String, Integer> getWorstVehiclesWithNegativeVotes();
}
