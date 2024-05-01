package ec.weka;

// import java.io.File;
// import java.io.FileWriter;
// import weka.classifiers.Classifier;
// import weka.classifiers.Evaluation;
// import weka.core.Instances;
// import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;
import java.io.PrintWriter;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.Evaluation;
import weka.core.SerializationHelper;

public class ModelFileTest {

    public static void main(String[] args) throws Exception {
        // String modelFilePath = args[1];
        // String dataFilePath = args[3];
        // String testFilePath = args[5];
        // String outputFilePath = args[7];

        // Classifier model = (Classifier) weka.core.SerializationHelper.read(modelFilePath);

        // DataSource source = new DataSource(dataFilePath);
        // Instances data = source.getDataSet();
        // data.setClassIndex(data.numAttributes() - 1);

        // DataSource testSource = new DataSource(testFilePath);
        // Instances testData = testSource.getDataSet();
        // testData.setClassIndex(testData.numAttributes() - 1);

        // System.out.println("Testing linear regression model...");
        // Evaluation eval = new Evaluation(data);
        // eval.evaluateModel(model, testData);
        // System.out.println(eval.toSummaryString());

        // try (FileWriter writer = new FileWriter(new File(outputFilePath))) {
        //     writer.write(eval.toSummaryString());
        // }
        // System.out.println("Testing result saved to " + outputFilePath);

        if (args.length != 8) {
            System.out.println("Usage: java ModelFileTest -modelfile <modelfile> -datafile <datafile> -testfile <testfile> -outfile <outfile>");
            System.exit(1);
        }
        
        String modelfile = null;
        String datafile = null;
        String testfile = null;
        String outfile = null;
        
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-modelfile")) {
                modelfile = args[++i];
            } else if (args[i].equals("-datafile")) {
                datafile = args[++i];
            } else if (args[i].equals("-testfile")) {
                testfile = args[++i];
            } else if (args[i].equals("-outfile")) {
                outfile = args[++i];
            } else {
                System.out.println("Invalid argument: " + args[i]);
                System.exit(1);
            }
        }
        
        LinearRegression lr = (LinearRegression) SerializationHelper.read(modelfile);
        DataSource source1 = new DataSource(datafile);
        Instances data1 = source1.getDataSet();
        
        data1.setClassIndex(data1.numAttributes() - 1);
        
        DataSource source2 = new DataSource(testfile);
        Instances data2 = source2.getDataSet();
        
        data2.setClassIndex(data2.numAttributes() - 1);
        
        Evaluation eval = new Evaluation(data1);
        
        eval.evaluateModel(lr, data2);
        
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));
        
        PrintWriter writer = new PrintWriter(new File(outfile));
        
        writer.println(eval.toSummaryString("\nResults\n======\n", false));
        writer.close();
    }
}
