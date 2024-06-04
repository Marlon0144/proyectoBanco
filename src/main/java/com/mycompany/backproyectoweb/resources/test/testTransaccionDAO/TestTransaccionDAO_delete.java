package com.mycompany.backproyectoweb.resources.test.testTransaccionDAO;

import com.mycompany.backproyectoweb.resources.Model.dao.TransaccionDAO;
import java.sql.SQLException;

public class TestTransaccionDAO_delete {
    public static void main(String[] args) {
        TransaccionDAO transaccionDAO = new TransaccionDAO();
        
        //Eliminar en la base de datos
        try{
            transaccionDAO.deleteTransaccion(2);
            transaccionDAO.deleteTransaccion(3);
            transaccionDAO.deleteTransaccion(4);
            System.out.println("Transacciones realizadas exitosamente");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
