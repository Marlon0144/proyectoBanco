
package com.mycompany.backproyectoweb.resources.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycompany.backproyectoweb.resources.Model.dao.*;
import com.mycompany.backproyectoweb.resources.Model.entidades.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/createAccount")
public class servletCreateAccount extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        double interes = Double.parseDouble(request.getParameter("interes"));
        String name = request.getParameter("name");
        
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        
        CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAO();
        
        try {
            // La llamada que puede lanzar SQLException
            cuentaBancariaDAO.addCuentaBancaria(new CuentaBancaria(idUser,saldo,interes));
            
            request.setAttribute("idUser", idUser);
            request.setAttribute("name", name);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Manejar la excepción SQLException
            e.printStackTrace();
            request.setAttribute("message", "Ocurrió un error al procesar la consulta: " + e.getMessage());
        }
    }
}

