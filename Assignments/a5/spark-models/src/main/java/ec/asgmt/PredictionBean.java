package ec.asgmt;

import javax.ejb.Stateless;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.ml.regression.LinearRegressionModel;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Stateless
public class PredictionBean {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";

    public double predict(double[] features) {
        LinearRegressionModel model = loadModelFromDatabase();

        return model.predict(Vectors.dense(features));
    }

    private LinearRegressionModel loadModelFromDatabase() {
        LinearRegressionModel model = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = connection.prepareStatement("SELECT object FROM spark_model");
            
            // stmt.setString(1, "spark_model");
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                byte[] modelBytes = rs.getBytes("object");
                ByteArrayInputStream bis = new ByteArrayInputStream(modelBytes);
                ObjectInputStream ois = new ObjectInputStream(bis);
                model = (LinearRegressionModel) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    // public static void main(String[] args) {
    //     double result = predict(new double[]{0.08829,  12.50,   7.870,  0,  0.5240,  6.0120,  66.60,  5.5605,   5,  311.0,  15.20, 395.60,  12.43});

    //     System.out.println(result);
    // }
}
