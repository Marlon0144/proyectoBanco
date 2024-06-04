package com.mycompany.backproyectoweb.resources.Controller;

import com.mycompany.backproyectoweb.resources.Model.dao.UserDAO;
import com.mycompany.backproyectoweb.resources.Model.entidades.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class servletRegister extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String confirmPassword = request.getParameter("confirmPassword");
        
        try {
            // La llamada que puede lanzar SQLException
            UserDAO userDAO = new UserDAO();
            User user;
            if(firstName != null && password != null){
                user = new User(firstName,password);
                userDAO.addUser(user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            } else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // Manejar la excepción SQLException
            e.printStackTrace();
            request.setAttribute("message", "Ocurrió un error al procesar la consulta: " + e.getMessage());
        }
    }
}
