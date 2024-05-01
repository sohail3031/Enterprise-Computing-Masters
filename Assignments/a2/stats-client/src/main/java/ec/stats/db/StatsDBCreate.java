package ec.stats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatsDBCreate {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection con = null;
    private static Statement stmt = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();
            
            stmt.executeUpdate("CREATE TABLE ecuser (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), password VARCHAR(255), role INT)");
            stmt.executeUpdate("CREATE TABLE ecmodel (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), object MEDIUMBLOB, classname VARCHAR(255), date TIMESTAMP)");
            stmt.close();
            con.close();
            
            System.out.println("Tables created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            try {
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
