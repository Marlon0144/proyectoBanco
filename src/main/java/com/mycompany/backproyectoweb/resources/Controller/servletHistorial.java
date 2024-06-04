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

@WebServlet("/historial")
public class servletHistorial extends HttpServlet {
    private CuentaBancariaDAO cuentaBancariaDAO;
    private TransaccionDAO transaccionDAO;

    @Override
    public void init() {
        cuentaBancariaDAO = new CuentaBancariaDAO();
        transaccionDAO = new TransaccionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibe
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        
        //Opera
        try{
            List<Transaccion> transacciones = transaccionDAO.getTransaccionesByUserAccountLocal(idUser);
            
            //Setea
            request.setAttribute("transacciones",transacciones);
            
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Ocurrió un error al procesar la consulta: " + e.getMessage());
        }
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/historial.jsp");
        dispatcher.forward(request, response);
        
    }
}
