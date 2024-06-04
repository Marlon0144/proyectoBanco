package com.mycompany.backproyectoweb.resources.Model.dao;

import static com.mycompany.backproyectoweb.resources.DataBaseConnection.getConnection;
import com.mycompany.backproyectoweb.resources.Model.entidades.CuentaBancaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaDAO {
    // Insertar una nueva cuenta bancaria
    public void addCuentaBancaria(CuentaBancaria cuenta) throws SQLException {
        String sql = "INSERT INTO cuentabancaria (idUser, saldo, interes) VALUES ( ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cuenta.getIdUser());
            stmt.setDouble(2, cuenta.getSaldo());
            stmt.setDouble(3, cuenta.getInteres());
            stmt.executeUpdate();
        }
    }
    
    public void updateSaldo(int numberAccount, double nuevoSaldo) throws SQLException {
        String sql = "UPDATE cuentabancaria SET saldo = ? WHERE numberAccount = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuevoSaldo);
            stmt.setInt(2, numberAccount);
            stmt.executeUpdate();
        }
    }
    
    public void updateInteres(int numberAccount, Double nuevoInteres) throws SQLException {
        String sql = "UPDATE cuentabancaria SET interes = ? WHERE numberAccount = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuevoInteres);
            stmt.setInt(2, numberAccount);
            stmt.executeUpdate();
        }
    }
    
    
    // Actualizar una cuenta bancaria existente
    public void updateCuentaBancaria(CuentaBancaria cuenta) throws SQLException {
        String sql = "UPDATE cuentabancaria SET saldo = ?, interes = ? WHERE numberAccount = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, cuenta.getSaldo());
            stmt.setDouble(2, cuenta.getInteres());
            stmt.setInt(3, cuenta.getNumberAccount());
            stmt.executeUpdate();
        }
    }

    // Eliminar una cuenta bancaria
    public void deleteCuentaBancaria(int numberAccount) throws SQLException {
        String sql = "DELETE FROM cuentabancaria WHERE numberAccount = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numberAccount);
            stmt.executeUpdate();    
        }
    }

    // Obtener una cuenta bancaria por número de cuenta
    public CuentaBancaria getCuentaBancaria(int numberAccount) throws SQLException {
        String sql = "SELECT * FROM cuentabancaria WHERE numberAccount = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numberAccount);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CuentaBancaria(
                        rs.getInt("idUser"),
                        rs.getInt("saldo"),
                        rs.getDouble("interes")
                    );
                }
            }
        }
        return null;
    }

    // Obtener todas las cuentas bancarias de un usuario
    public List<CuentaBancaria> getCuentasBancariasByUserId(int userId) throws SQLException {
        List<CuentaBancaria> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM cuentabancaria WHERE idUser = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cuentas.add(new CuentaBancaria(
                        rs.getInt("numberAccount"),
                        rs.getInt("idUser"),
                        rs.getDouble("saldo"),
                        rs.getDouble("interes")
                    ));
                }
            }
        }
        return cuentas;
    }

    public double getSaldoByNumeroCuenta(int numberAccount) throws SQLException {
    String sql = "SELECT saldo FROM cuentabancaria WHERE numberAccount = ?";
    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, numberAccount);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("saldo");
            }
        }
    }
    return -1; // Retorna -1 si la cuenta no existe o si ocurre un error
    }
    
    public int getIdUserByNumeroCuenta(int numberAccount) throws SQLException {
        String sql = "SELECT idUser FROM cuentabancaria WHERE numberAccount = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numberAccount);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idUser");
                }
            }
        }
        return -1; // Retorna -1 si la cuenta no existe o si ocurre un error
    }
}
