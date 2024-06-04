
package com.mycompany.backproyectoweb.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/banco";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            // Cargar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el driver de MariaDB", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Conexión establecida exitosamente.");
            } else {
                System.out.println("Error al establecer la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
