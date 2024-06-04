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

@WebServlet("/operacionRetirar")
public class servletOpRetirar extends HttpServlet {
    private CuentaBancariaDAO cuentaBancariaDAO;

    @Override
    public void init() {
        cuentaBancariaDAO = new CuentaBancariaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibe
        int numberAccount = Integer.parseInt(request.getParameter("numberAccount"));
        int montoRetirar = Integer.parseInt(request.getParameter("montoRetirar"));
        double costoOp = montoRetirar*0.01;
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        //Opera
        try{
            if(saldo >= montoRetirar){
                cuentaBancariaDAO.updateSaldo(numberAccount, saldo - montoRetirar);
                saldo = (saldo - montoRetirar) - costoOp;
                
                //Setea
                request.setAttribute("numberAccount",numberAccount);
                request.setAttribute("saldo",saldo);
                request.setAttribute("cost",costoOp);
                request.setAttribute("message","Operacion Realizado Con exito");
                
                //Manda
                RequestDispatcher dispatcher = request.getRequestDispatcher("/retirar.jsp");
                dispatcher.forward(request, response);
            }else{
                //Setea
                request.setAttribute("saldo",saldo);
                request.setAttribute("numberAccount",numberAccount);
                request.setAttribute("message","SaldoInsuficiente");
                
                //Manda
                RequestDispatcher dispatcher = request.getRequestDispatcher("/retirar.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Ocurrió un error al procesar la consulta: " + e.getMessage());
        }
        
        
    }
}
