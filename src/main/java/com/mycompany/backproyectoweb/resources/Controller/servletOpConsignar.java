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

@WebServlet("/operacionConsignar")
public class servletOpConsignar extends HttpServlet {
    private CuentaBancariaDAO cuentaBancariaDAO;
    private TransaccionDAO transaccionDAO;

    @Override
    public void init() {
        cuentaBancariaDAO = new CuentaBancariaDAO();
        transaccionDAO = new TransaccionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibe
        int numberAccountR = Integer.parseInt(request.getParameter("numberAccountR"));
        int montoConsignar = Integer.parseInt(request.getParameter("montoConsignar"));
        double costoOp = montoConsignar * 0.01;
        
        int numberAccount = Integer.parseInt(request.getParameter("numberAccount"));
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        //Opera
        try{
            double saldoR = cuentaBancariaDAO.getSaldoByNumeroCuenta(numberAccountR);
            int idUser = cuentaBancariaDAO.getIdUserByNumeroCuenta(numberAccount);
            
            if(saldo >= montoConsignar){
                
                if(numberAccount != numberAccountR){
                    
                    saldo = (saldo - montoConsignar) - costoOp;
                    saldoR = saldoR + montoConsignar;
                    cuentaBancariaDAO.updateSaldo(numberAccountR, saldoR);
                    cuentaBancariaDAO.updateSaldo(numberAccount, saldo);
                    transaccionDAO.addTransaccion(new Transaccion(idUser,montoConsignar,numberAccount,numberAccountR));


                    //Setea
                    request.setAttribute("numberAccount",numberAccount);
                    request.setAttribute("costoOp",costoOp);
                    request.setAttribute("saldo",saldo);
                    request.setAttribute("message","Operacion Realizada con extito");

                    //Manda
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/consignar.jsp");
                    dispatcher.forward(request, response);
                }else{
                    //Setea
                    request.setAttribute("numberAccount",numberAccount);
                    request.setAttribute("saldo",saldo);
                    request.setAttribute("message","No puedes consignar a la misma Cuenta");

                    //Manda
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/consignar.jsp");
                    dispatcher.forward(request, response);
                }
                
                
                
            }else{
                //Setea
                request.setAttribute("saldo",saldo);
                request.setAttribute("numberAccount",numberAccount);
                request.setAttribute("message","SaldoInsuficiente");
                
                //Manda
                RequestDispatcher dispatcher = request.getRequestDispatcher("/consignar.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Ocurrió un error al procesar la consulta: " + e.getMessage());
        }
        
        //Setea
        request.setAttribute("numberAccount",numberAccountR);
        request.setAttribute("saldo",saldo);
        
        //Envia
        RequestDispatcher dispatcher = request.getRequestDispatcher("/consignar.jsp");
        dispatcher.forward(request, response);
        
    }
}
