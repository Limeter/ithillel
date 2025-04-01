package homework35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

public class MySQLStarter {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS Dragons (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "color VARCHAR(50), " +
                    "element VARCHAR(50))");

            stmt.execute("INSERT INTO Dragons (name, age, color, element) VALUES " +
                    "('Smaug', 500, 'Red', 'Fire'), " +
                    "('Toothless', 150, 'Black', 'Night Fury')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM Dragons");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Color: " + rs.getString("color") +
                        ", Element: " + rs.getString("element"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
