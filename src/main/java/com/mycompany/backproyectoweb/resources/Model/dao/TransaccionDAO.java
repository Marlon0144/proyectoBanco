package com.mycompany.backproyectoweb.resources.Model.dao;

import static com.mycompany.backproyectoweb.resources.DataBaseConnection.getConnection;
import com.mycompany.backproyectoweb.resources.Model.entidades.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {
    // Insertar una nueva transacción
    public void addTransaccion(Transaccion transaccion) throws SQLException {
        String sql = "INSERT INTO transaccion (idUserAccountLocal, numberAccountLocal, numberAccountTarget,monto) VALUES (? , ? , ? ,? )";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaccion.getIdUserAccountLocal());
            stmt.setInt(2, transaccion.getNumberAccountLocal());
            stmt.setInt(3, transaccion.getNumberAccountTarget());
            stmt.setInt(4, transaccion.getMonto());
            stmt.executeUpdate();
        }
    }

    // Actualizar una transacción existente
    public void updateTransaccion(Transaccion transaccion) throws SQLException {
        String sql = "UPDATE transaccion SET numberAccountLocal = ?, numberAccountTarget = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaccion.getNumberAccountLocal());
            stmt.setInt(2, transaccion.getNumberAccountTarget());
            stmt.setInt(3, transaccion.getId());
            stmt.executeUpdate();
        }
    }

    // Eliminar una transacción
    public void deleteTransaccion(int id) throws SQLException {
        String sql = "DELETE FROM transaccion WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Obtener una transacción por id
    public Transaccion getTransaccion(int id) throws SQLException {
        String sql = "SELECT * FROM transaccion WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaccion(
                        rs.getInt("idUserAccountLocal"),
                        rs.getInt("monto"),
                        rs.getInt("numberAccountLocal"),
                        rs.getInt("numberAccountTarget")
                    );
                }
            }
        }
        return null;
    }

    // Obtener todas las transacciones
    public List<Transaccion> getAllTransacciones() throws SQLException {
        List<Transaccion> transacciones = new ArrayList<>();
        String sql = "SELECT * FROM transaccion";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                transacciones.add(new Transaccion(
                    rs.getInt("idUserAccountLocal"),
                    rs.getInt("numberAccountLocal"),
                    rs.getInt("monto"),
                    rs.getInt("numberAccountTarget")
                    
                ));
            }
        }
        return transacciones;
    }
    
    public List<Transaccion> getTransaccionesByUserAccountLocal(int idUserAccountLocal) throws SQLException {
        List<Transaccion> transacciones = new ArrayList<>();
        String sql = "SELECT * FROM transaccion WHERE idUserAccountLocal = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUserAccountLocal);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    transacciones.add(new Transaccion(
                        rs.getInt("id"),
                        rs.getInt("idUserAccountLocal"),
                        rs.getInt("monto"),
                        rs.getInt("numberAccountLocal"),
                        rs.getInt("numberAccountTarget")
                    ));
                }
            }
        }
        return transacciones;
    }
}
