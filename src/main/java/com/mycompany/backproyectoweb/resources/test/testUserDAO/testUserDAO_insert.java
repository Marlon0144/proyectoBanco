package com.mycompany.backproyectoweb.resources.test.testUserDAO;

import com.mycompany.backproyectoweb.resources.Model.dao.UserDAO;
import com.mycompany.backproyectoweb.resources.Model.entidades.User;
import java.sql.SQLException;

public class testUserDAO_insert {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        
        //Creacion de users
        User user1 = new User("MarlonGI");
        
        
        System.out.println(user1);
        //Insertar en la base de datos
        try{
            userDAO.addUser(user1);
            System.out.println("Cuentas añadidas exitosamente");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    } 
}
