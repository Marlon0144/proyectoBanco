package com.mycompany.backproyectoweb.resources.Model.dao;

import static com.mycompany.backproyectoweb.resources.DataBaseConnection.getConnection;
import com.mycompany.backproyectoweb.resources.Model.entidades.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Insertar un nuevo usuario
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user (firstName, lastName, emailAddress, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmailAddress());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
        }
    }

    // Actualizar un usuario existente
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET firstName = ?, lastName = ?, emailAddress = ?, password = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmailAddress());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getId());
            stmt.executeUpdate();
        }
    }

    public User getUserbyNameAndPassword(String name, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE firstName = ? AND password = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("password"));
                }
            }
        }
        return null;
    }
    
    
    // Eliminar un usuario
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    
    
    // Obtener un usuario por id
    public User getUser(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("emailAddress"),
                        rs.getString("password")
                    );
                }
            }
        }
        return null;
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("emailAddress"),
                    rs.getString("password")
                ));
            }
        }
        return users;
    }
    
    public int countUsers() throws SQLException {
    String sql = "SELECT COUNT(*) AS count FROM user";
    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
            return rs.getInt("count");
        }
    }
    return 0;
}
}
