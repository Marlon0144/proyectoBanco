package com.mycompany.backproyectoweb.resources.test.testCuentaBancariaDAO;

import com.mycompany.backproyectoweb.resources.Model.dao.CuentaBancariaDAO;
import com.mycompany.backproyectoweb.resources.Model.entidades.CuentaBancaria;
import java.sql.SQLException;
import java.util.List;

public class TestCuentaBancariadDAO_obtain {
    public static void main(String[] args) {
        CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAO();
        
        try{
            
            List<CuentaBancaria> cuentas = cuentaBancariaDAO.getCuentasBancariasByUserId(11);
            System.out.println(cuentas);
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
