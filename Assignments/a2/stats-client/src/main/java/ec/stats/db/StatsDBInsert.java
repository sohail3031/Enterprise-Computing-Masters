package ec.stats.db;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class StatsDBInsert {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection con = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASS);
            String table = getArgValue(args, "-table");
            
            if (table == null) {
                throw new IllegalArgumentException("Missing -table argument");
            }
            
            switch (table) {
                case "ecuser":
                    String name = getArgValue(args, "-name");
                    String password = getArgValue(args, "-password");
                    String role = getArgValue(args, "-role");
            
                    if (name == null || password == null || role == null) {
                        throw new IllegalArgumentException("Missing arguments for ecuser table");
                    }
                    
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO ecuser (name, password, role) VALUES (?, ?, ?)");
                    
                    pstmt.setString(1, name);
                    pstmt.setString(2, password);
                    pstmt.setInt(3, Integer.parseInt(role));
                    pstmt.executeUpdate();
                    pstmt.close();
                    
                    break;
                case "ecmodel":
                    String modelfile = getArgValue(args, "-modelfile");
                    
                    if (modelfile == null) {
                        throw new IllegalArgumentException("Missing -modelfile argument");
                    }
                    
                    File file = new File(modelfile);
//                    FileInputStream fis = new FileInputStream(file);
//                    byte[] object = fis.readAllBytes();
                    int size = (int) file.length();
                    byte[] object = new byte[size];
                    FileInputStream fis = new FileInputStream(file);
                    
                    fis.read(object);
                    fis.close();
                    fis.close();
                    String filename = file.getName();
                    String modelname = filename.substring(0, filename.lastIndexOf("."));
                    String classname = new String(Arrays.copyOfRange(object, 0, 255)).trim();
                    PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO ecmodel (name, object, classname) VALUES (?, ?, ?)");
                    
                    pstmt1.setString(1, modelname);
                    pstmt1.setBytes(2, object);
                    pstmt1.setString(3, classname);
                    pstmt1.executeUpdate();
                    pstmt1.close();
                    
                    break;
                default:
                    throw new IllegalArgumentException("Invalid table name: " + table);
            }
            
            con.close();
            
            System.out.println("Record inserted successfully");
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
