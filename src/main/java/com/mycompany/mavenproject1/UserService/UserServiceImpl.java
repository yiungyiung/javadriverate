/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserService;

import com.mycompany.mavenproject1.UserDAO.UsersDAO;
import com.mycompany.mavenproject1.model.UserModel;

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
        
        String uname=UsersDAO.getInstance().checkLogin(email, Password);
        return uname;
    }
    
    
    
    

}
