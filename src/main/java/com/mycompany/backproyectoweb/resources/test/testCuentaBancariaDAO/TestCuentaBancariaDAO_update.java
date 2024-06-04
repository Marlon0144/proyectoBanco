
package com.mycompany.backproyectoweb.resources.test.testCuentaBancariaDAO;

import com.mycompany.backproyectoweb.resources.Model.dao.CuentaBancariaDAO;
import java.sql.SQLException;

public class TestCuentaBancariaDAO_update {
    public static void main(String[] args) {
        CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAO();
        
        try{

            cuentaBancariaDAO.updateSaldo(110, 800);
            cuentaBancariaDAO.updateSaldo(211, 50);
            cuentaBancariaDAO.updateSaldo(312, 25);
            System.out.println("Saldo actualizdo correctamente");
            
            cuentaBancariaDAO.updateInteres(110, 0.1);
            cuentaBancariaDAO.updateInteres(211, 0.9);
            cuentaBancariaDAO.updateInteres(312, 0.5);
            System.out.println("interes actualizado correctamente");
            
            
            
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
