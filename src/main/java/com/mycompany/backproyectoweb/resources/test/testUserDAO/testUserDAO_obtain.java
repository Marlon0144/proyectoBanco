package com.mycompany.backproyectoweb.resources.test.testUserDAO;

import com.mycompany.backproyectoweb.resources.Model.dao.UserDAO;
import com.mycompany.backproyectoweb.resources.Model.entidades.User;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class testUserDAO_obtain {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        try{
            System.out.println(String.valueOf(userDAO.countUsers()));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    } 
}
