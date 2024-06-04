
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

@WebServlet("/cuentas")
public class servletCuentas extends HttpServlet {
    private CuentaBancariaDAO cuentaBancariaDAO;

    @Override
    public void init() {
        cuentaBancariaDAO = new CuentaBancariaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int idUser = Integer.parseInt( request.getParameter("idUser") );
                
                
        try {
            // La llamada que puede lanzar SQLException
            List<CuentaBancaria> cuentas = cuentaBancariaDAO.getCuentasBancariasByUserId(idUser);

            if (cuentas != null) {
                request.setAttribute("cuentas", cuentas);
                request.setAttribute("idUser", idUser);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/cuentas.jsp");
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
