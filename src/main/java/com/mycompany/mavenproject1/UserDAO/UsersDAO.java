/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserDAO;

import com.mycompany.mavenproject1.config.DBconnection;
import com.mycompany.mavenproject1.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yash
 */
public class UsersDAO {
    
    private static UsersDAO instance;
    
    private UsersDAO()
    {
        
    }
    
    public static synchronized UsersDAO getInstance()
    {
        if(instance == null)
        {
            instance = new UsersDAO();
            
        }
        
        return instance;
    }
    
    public void save(UserModel user)
    {
        Connection connection = DBconnection.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("insert into userreg (Email, password, name, age) values (? ,?, ?, ?) ");
            pr.setString(1, user.getEmail());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getName());
            pr.setString(4, user.getAge().toString());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
