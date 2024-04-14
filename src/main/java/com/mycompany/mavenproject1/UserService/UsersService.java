/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.UserService;

/**
 *
 * @author yash
 */
public interface UsersService {
    int register(String name, String Password, String address, String email, String Phone, String Username);
    
    String login(String email,String Password);
}
