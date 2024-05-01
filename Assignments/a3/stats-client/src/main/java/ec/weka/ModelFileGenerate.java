package ec.weka;

// import weka.core.Instances;
// // import weka.core.converters.ArffLoader;
// import weka.core.converters.ConverterUtils.DataSource;
// import weka.classifiers.functions.LinearRegression;

// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.ObjectOutputStream;
// import java.util.Arrays;
// import java.util.List;

// import java.io.File;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;
import weka.core.SerializationHelper;

public class ModelFileGenerate {
    public static void main(String[] args) throws Exception {
        // List<String> argList = Arrays.asList(args);
        // try {
        // 	 String dataFilePath = argList.get(argList.indexOf("-datafile") + 1);
        //      String modelFilePath = argList.get(argList.indexOf("-modelfile") + 1);

        //      DataSource source = new DataSource(dataFilePath);
        //      Instances data = source.getDataSet();
        //      data.setClassIndex(data.numAttributes() - 1);

        //      LinearRegression model = new LinearRegression();
        //      model.buildClassifier(data);

        //      // Save model to file
        //      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(modelFilePath)))) {
        //          oos.writeObject(model);
        //      }

        //      System.out.println("Linear regression model successfully generated and saved to " + modelFilePath);
		// } catch (Exception e) {
		// 	// TODO: handle exception
		// }
       
        if (args.length != 4) {
            System.out.println("Usage: java ModelFileGenerate -datafile <datafile> -modelfile <modelfile>");
            System.exit(1);
        }
        
        String datafile = null;
        String modelfile = null;
        
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-datafile")) {
                datafile = args[++i];
            } else if (args[i].equals("-modelfile")) {
                modelfile = args[++i];
            } else {
                System.out.println("Invalid argument: " + args[i]);
                System.exit(1);
            }
        }
        
        DataSource source = new DataSource(datafile);
        Instances data = source.getDataSet();
        
        data.setClassIndex(data.numAttributes() - 1);
        
        LinearRegression lr = new LinearRegression();
        
        lr.buildClassifier(data);
        
        SerializationHelper.write(modelfile, lr);
        
        System.out.println("Model file generated: " + modelfile);
        System.out.println("Model summary: \n" + lr);
    }
}
