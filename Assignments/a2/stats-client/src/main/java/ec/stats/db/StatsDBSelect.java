package ec.stats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatsDBSelect {
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
                    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ecuser WHERE name = ?");
            
                    pstmt.setString(1, name);
                    
                    ResultSet rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        System.out.println("id: " + rs.getInt("id"));
                        System.out.println("name: " + rs.getString("name"));
                        System.out.println("password: " + rs.getString("password"));
                        System.out.println("role: " + rs.getInt("role"));
                    } else {
                        System.out.println("No record found");
                    }
                    
                    rs.close();
                    pstmt.close();
                    
                    break;
                case "ecmodel":
                    PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM ecmodel WHERE name = ?");
                    
                    pstmt1.setString(1, name);
                    
                    ResultSet rs1 = pstmt1.executeQuery();
                    
                    if (rs1.next()) {
                        System.out.println("id: " + rs1.getInt("id"));
                        System.out.println("name: " + rs1.getString("name"));
                        System.out.println("object: " + rs1.getBytes("object"));
                        System.out.println("classname: " + rs1.getString("classname"));
                        System.out.println("date: " + rs1.getTimestamp("date"));
                    } else {
                        System.out.println("No record found");
                    }
                    
                    rs1.close();
                    pstmt1.close();
                    
                    break;
                default:
                    throw new IllegalArgumentException("Invalid table name: " + table);
            }
            
            con.close();
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