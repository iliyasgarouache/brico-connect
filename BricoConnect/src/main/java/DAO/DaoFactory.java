package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private static String url = "jdbc:mysql://localhost:3306/bricoconnect";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    static {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Handle the error appropriately, for now, throw a RuntimeException
            throw new RuntimeException("Error loading MySQL JDBC driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // If the connection is not initialized or is closed, create a new one
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
