/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserService;

import com.mycompany.mavenproject1.UserDAO.UsersDAO;
import com.mycompany.mavenproject1.model.Rating;
import com.mycompany.mavenproject1.model.UserModel;
import com.mycompany.mavenproject1.model.Vehicle;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yash
 */
public class UserServiceImpl implements UsersService {

    private static UserServiceImpl instance;

    private UserServiceImpl() {

    }

    public static synchronized UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public int register(String name, String Password, String address, String email, String Phone, String Username) {
        UserModel user = new UserModel(name, email, Password, address, Phone, Username);
        int i = UsersDAO.getInstance().saveRegisteredUser(user);
        return i;
    }

    @Override
    public String login(String email, String Password) {

        String uname = UsersDAO.getInstance().checkLogin(email, Password);
        return uname;
    }

    @Override
    public List<String> anomlogin(String username) {
        List<String> uname = UsersDAO.getInstance().checkLogin(username);
        return uname;
    }

    @Override
    public boolean deleteAnomUser(String userID) {
        boolean st = UsersDAO.getInstance().deleteAnomUser(Integer.parseInt(userID));
        return st;
    }

    @Override
    public boolean addVehicle(String vehicleNumber, int year, String manufacturer, String model,
            String color, String vehicleCategory, String email) {
        boolean st = UsersDAO.getInstance().addVehicle(vehicleNumber, year, manufacturer, model,
                color, vehicleCategory, email);
        return st;
    }

    @Override
    public boolean addRating(String vehicleNumber, boolean goodRating, boolean badRating,
            byte[] picture, String comment, double latitude, double longitude) {
        boolean st = UsersDAO.getInstance().addRating(vehicleNumber, goodRating, badRating,  picture, comment, latitude, longitude);
        return st;
    }

    @Override
    public List<Vehicle> getAllVehiclesForUser(String email) {
        List<Vehicle> vh = UsersDAO.getInstance().getAllVehiclesForUser(email);
        return vh;
    }

    @Override
    public List<Rating> searchRatingsBySubstring(String substring) {
        List<Rating> rt = UsersDAO.getInstance().searchRatingsBySubstring(substring);
        return rt;
    }

    @Override
    public List<Rating> getAllRatings() {
    List<Rating> rt = UsersDAO.getInstance().getAllRatings();
    return rt;
    }

    @Override
    public Map<String, Integer> getBestVehiclesWithGoodVotes() {
        Map<String, Integer> st = UsersDAO.getInstance().getBestVehiclesWithGoodVotes();
        return st;
    }

    @Override
    public Map<String, Integer> getWorstVehiclesWithNegativeVotes() {
        Map<String, Integer> st = UsersDAO.getInstance().getWorstVehiclesWithNegativeVotes();
        return st;
    }
}
