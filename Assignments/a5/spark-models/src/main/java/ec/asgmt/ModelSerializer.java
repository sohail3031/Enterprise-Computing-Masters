package ec.asgmt;

import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ModelSerializer {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("Model Serializer").master("local").getOrCreate();
        LinearRegressionModel model = trainModel(spark);

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            
            oos.writeObject(model);
        
            byte[] modelBytes = bos.toByteArray();

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS spark_model (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), object MEDIUMBLOB, classname VARCHAR(255), date TIMESTAMP)");

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO spark_model (name, object, classname, date) VALUES (?, ?, ?, NOW())");

            stmt.setString(1, "spark_model");
            stmt.setBytes(2, modelBytes);
            stmt.setString(3, model.getClass().getName());
            stmt.executeUpdate();

            // try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM spark_model")) {
            //     // preparedStatement.setString(1, "spark_model");
            //     ResultSet resultSet = preparedStatement.executeQuery();

            //     while (resultSet.next()) {
            //         long id = resultSet.getLong("id");
            //         String modelName = resultSet.getString("name");
            //         byte[] bytes = resultSet.getBytes("object");
            //         String className = resultSet.getString("classname");
            //         Timestamp  timestamp = resultSet.getTimestamp("date");
            //         StringBuilder hexString = new StringBuilder();
                    
            //         for (byte b : bytes) {
            //             hexString.append(String.format("%02X ", b));
            //         }
                    
            //         System.out.println("ID: " + id + ", Name: " + modelName + ", object: " + hexString.toString() + ", Class Name: " + className + ", Time Stamp: " + timestamp);
            //     }
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static LinearRegressionModel trainModel(SparkSession spark) {
        Dataset<Row> trainingData = spark.read().option("inferSchema", "true").option("header", "false").option("delimiter", ",").csv("C:\\enterprise\\workspace\\a5\\spark-models\\src\\main\\java\\ec\\housing.data");
        VectorAssembler assembler = new VectorAssembler().setInputCols(new String[]{"_c0", "_c1", "_c2", "_c3", "_c4", "_c5", "_c6", "_c7", "_c8", "_c9", "_c10", "_c11", "_c12"}).setOutputCol("features");
        Dataset<Row> transformedTrainingData = assembler.transform(trainingData).withColumnRenamed("_c13", "label");
        LinearRegression lr = new LinearRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8).setFeaturesCol("features").setLabelCol("label");
        LinearRegressionModel model = lr.fit(transformedTrainingData);
    
        return model;
    }    

    // private static LinearRegressionModel trainModel(SparkSession spark) {
    //     Dataset<Row> trainingData = spark.read().option("inferSchema", "true").option("header", "false").option("delimiter", ",").csv("C:\\enterprise\\workspace\\a5\\spark-models\\src\\main\\java\\ec\\housing.data");
    //     VectorAssembler assembler = new VectorAssembler().setInputCols(new String[]{"_c0", "_c1", "_c2", "_c3", "_c4", "_c5", "_c6", "_c7", "_c8", "_c9", "_c10", "_c11", "_c12"}).setOutputCol("features");
    //     Dataset<Row> transformedTrainingData = assembler.transform(trainingData).withColumnRenamed("_c13", "label");
    //     LinearRegression lr = new LinearRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8).setFeaturesCol("features").setLabelCol("label");
    //     LinearRegressionModel model = lr.fit(transformedTrainingData);
    
    //     return model;
    // }
}
