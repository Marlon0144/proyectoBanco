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

@WebServlet("/login")
public class servletLoggin extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        try {
            // La llamada que puede lanzar SQLException
            User user = this.userDAO.getUserbyNameAndPassword(name, password);

            if (user != null) {
                request.setAttribute("idUser", user.getId());
                request.setAttribute("name", name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // Manejar la excepción SQLException
            e.printStackTrace();
            request.setAttribute("message", "Ocurrió un error al procesar la consulta: " + e.getMessage());
        }
    }
}
