package ec.stats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatsDBDrop {
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
            
            stmt.executeUpdate("DROP TABLE ecuser");
            stmt.executeUpdate("DROP TABLE ecmodel");
            stmt.close();
            con.close();
            
            System.out.println("Tables dropped successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally { // finally block used to close resources
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
