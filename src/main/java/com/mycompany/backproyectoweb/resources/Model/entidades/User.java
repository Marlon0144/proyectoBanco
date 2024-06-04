/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backproyectoweb.resources.Model.entidades;
import com.mycompany.backproyectoweb.resources.Model.dao.*;
import java.sql.SQLException;

public class User {
    public UserDAO userDAO = new UserDAO();
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    
    
    public int calculateCont(){
        try {
            int totalUsers = userDAO.countUsers();
            return totalUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
            
            
    public User(String firstName, String lastName, String emailAddress, String password) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }
    
    public User(int id, String firstName,String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }
    
    public User(String firstName) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = "";
        this.emailAddress = "";
        this.password = "";
    }
    
    public User(String firstName, String password) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = "";
        this.emailAddress = "";
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", password=" + password + '}';
    }
    
}
