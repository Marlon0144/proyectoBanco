package com.mycompany.backproyectoweb.resources.test.testTransaccionDAO;

import com.mycompany.backproyectoweb.resources.Model.dao.TransaccionDAO;
import com.mycompany.backproyectoweb.resources.Model.entidades.Transaccion;
import java.sql.SQLException;

public class TestTransaccionDAO_insert {
    public static void main(String[] args) {
        TransaccionDAO transaccionDAO = new TransaccionDAO();
        
        //Creacion de transacciones
        Transaccion transaccion1 = new Transaccion(11,115,116,100);
        Transaccion transaccion2 = new Transaccion(11,118,117,200);
        Transaccion transaccion3 = new Transaccion(11,116,117,300);
        
        //Insertar en la base de datos
        try{
            transaccionDAO.addTransaccion(transaccion1);
            transaccionDAO.addTransaccion(transaccion2);
            transaccionDAO.addTransaccion(transaccion3);
            System.out.println("Transacciones realizadas exitosamente");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
