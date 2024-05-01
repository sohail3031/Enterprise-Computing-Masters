package ec.stats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatsDBDelete {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection con = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASS);
            String table = getArgValue(args, "-table");
            String name = getArgValue(args, "-name");
            
            if (table == null || name == null) {
                throw new IllegalArgumentException("Missing -table or -name argument");
            }
            
            switch (table) {
                case "ecuser":
                    PreparedStatement pstmt = con.prepareStatement("DELETE FROM ecuser WHERE name = ?");
            
                    pstmt.setString(1, name);
                    pstmt.executeUpdate();
                    pstmt.close();
                    
                    break;
                case "ecmodel":
                    PreparedStatement pstmt1 = con.prepareStatement("DELETE FROM ecmodel WHERE name = ?");
                    
                    pstmt1.setString(1, name);
                    pstmt1.executeUpdate();
                    pstmt1.close();
                    
                    break;
                default:
                    throw new IllegalArgumentException("Invalid table name: " + table);
            }
            
            con.close();
            
            System.out.println("Record deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static String getArgValue(String[] args, String argName) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals(argName)) {
                return args[i + 1];
            }
        }
    
        return null;
    }
}
