package com.mycompany.backproyectoweb.resources.Controller;

import com.mycompany.backproyectoweb.resources.Model.dao.*;
import com.mycompany.backproyectoweb.resources.Model.entidades.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/retirar")
public class servletRetirar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibe
        int numberAccount = Integer.parseInt(request.getParameter("numberAccount"));
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        //Setea
        request.setAttribute("numberAccount",numberAccount);
        request.setAttribute("saldo",saldo);
        
        //Manda
        RequestDispatcher dispatcher = request.getRequestDispatcher("/retirar.jsp");
        dispatcher.forward(request, response);
        
    }
}
