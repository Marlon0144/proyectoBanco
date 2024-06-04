package com.mycompany.backproyectoweb.resources.test.testCuentaBancariaDAO;
import com.mycompany.backproyectoweb.resources.Model.dao.CuentaBancariaDAO;
import com.mycompany.backproyectoweb.resources.Model.entidades.CuentaBancaria;
import java.sql.SQLException;

public class TestCuentaBancariaDAO_insert {
    public static void main(String[] args) {
        CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAO();
        
        //Creacion de cuentas
        CuentaBancaria cuenta1 = new CuentaBancaria(10,900);
        CuentaBancaria cuenta2 = new CuentaBancaria(11,800);
        CuentaBancaria cuenta3 = new CuentaBancaria(10,1000);
        
        
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
        //Insertar en la base de datos
        try{
            cuentaBancariaDAO.addCuentaBancaria(cuenta1);
            cuentaBancariaDAO.addCuentaBancaria(cuenta2);
            cuentaBancariaDAO.addCuentaBancaria(cuenta3);
            System.out.println("Cuentas añadidas exitosamente");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
}
