
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

@WebServlet("/cuenta")
public class servletCuenta extends HttpServlet {
    private CuentaBancariaDAO cuentaBancariaDAO;

    @Override
    public void init() {
        cuentaBancariaDAO = new CuentaBancariaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int numberAccount = Integer.parseInt( request.getParameter("numberAccount") );
        double saldo = Double.parseDouble( request.getParameter("saldo") );  
        double interes = Double.parseDouble( request.getParameter("interes") );
                
        request.setAttribute("numberAccount", numberAccount);
        request.setAttribute("saldo", saldo);
        request.setAttribute("interes", interes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cuentaI.jsp");
        dispatcher.forward(request, response);
        
    }
}
