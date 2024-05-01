package ec.asgmt.sb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import ec.stats.StatsSummary;

@Singleton
@LocalBean
// @Local(StatsSingletonLocal.class)
// @Remote(StatsSingletonRemote.class)
public class StatsSingleton implements StatsSingletonRemote, StatsSingletonLocal {
    public static final Logger LOGGER = Logger.getLogger(StatsSingleton.class.getName());

  	private List<Double> data = new ArrayList<>();
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private double mean = 0, variance = 0, std = 0;

    @Override
    public void addData(double value) {
        data.add(value);

        if (data.size() == 1) {
          min = max = mean = value;
          variance = std = 0;
        } else {
          min = Math.min(value, min);
          max = Math.max(value, max);

          double old_mean = mean;
          mean = (mean * (data.size() - 1) + value);
          double old_variance = variance;
          variance = old_variance + (value - old_mean) * (value - mean);
          std = Math.sqrt(variance / data.size());
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public StatsSummary stats() {
        StatsSummary summary = new StatsSummary();
        double sum = 0;
        double mean = 0, variance = 0, std = 0;
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
        
        for (Double d : data) {
            if (d < min) {
                min = d;
            }

            if (d > max) {
                max = d;
            }

            sum += d;
        }
        
        mean = sum / data.size();
        
        for (Double d : data) {
            // variance += Math.pow(d - mean, 2);
            variance = variance + (d - mean) * (d - mean);
        }
        
        // variance = variance / data.size();
        std = Math.sqrt(variance / data.size());
        
        summary.setCount(data.size());
        summary.setMin(min);
        summary.setMax(max);
        summary.setMean(mean);
        summary.setSTD(std);

        return summary;
    }

    @Override
    public void saveModel() {
        StatsSummary statsSummary = new StatsSummary();
        
        statsSummary.setCount(data.size());
        statsSummary.setMin(min);
        statsSummary.setMax(max);
        statsSummary.setMean(mean);
        statsSummary.setSTD(std);

        try {
            File dir = new File("C:/enterprise/tmp/model/");

            if (!dir.exists()) {
                Files.createDirectories(dir.toPath());
            }
            
            File file = new File("C:/enterprise/tmp/model/stats.bin");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(statsSummary);
            oos.close();
            fos.close();

            LOGGER.info("Model Saved: " + statsSummary.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  // private double[] data;

  // @Override
  // // Implement the addData method to add a value to the data set
  // public void addData(double value) {
  //   // If the data array is null, initialize it with a single element
  //   if (data == null) {
  //     data = new double[]{value};
  //   } else {
  //     // Otherwise, create a new array with one more element than the original array
  //     double[] newData = new double[data.length + 1];
  //     // Copy the original array elements to the new array
  //     System.arraycopy(data, 0, newData, 0, data.length);
  //     // Add the new value to the last position of the new array
  //     newData[data.length] = value;
  //     // Assign the new array to the data array
  //     data = newData;
  //   }
  // }

  // @Override
  // // Implement the getCount method to return the number of data elements
  // public int getCount() {
  //   // If the data array is null, return zero
  //   if (data == null) {
  //     return 0;
  //   } else {
  //     // Otherwise, return the length of the data array
  //     return data.length;
  //   }
  // }

  // @Override
  // // Implement the stats method to compute the descriptive statistics
  // public void stats() {
  //   // If the data array is not null and has at least one element
  //   if (data != null && data.length > 0) {
  //     // Sort the data array in ascending order
  //     Arrays.sort(data);
  //     // Create a new StatsSummary object
  //     StatsSummary summary = new StatsSummary();
  //     // Set the count attribute to the length of the data array
  //     summary.setCount(data.length);
  //     // Set the min attribute to the first element of the data array
  //     summary.setMin(data[0]);
  //     // Set the max attribute to the last element of the data array
  //     summary.setMax(data[data.length - 1]);
  //     // Declare a variable to store the sum of the data values
  //     double sum = 0;
  //     // Loop through the data array and add each value to the sum
  //     for (double value : data) {
  //       sum += value;
  //     }
  //     // Calculate the mean by dividing the sum by the count
  //     double mean = sum / summary.getCount();
  //     // Set the mean attribute to the calculated value
  //     summary.setMean(mean);
  //     // Declare a variable to store the sum of the squared deviations from the mean
  //     double sumOfSquares = 0;
  //     // Loop through the data array and add the squared deviation of each value from the mean to the sum of squares
  //     for (double value : data) {
  //       sumOfSquares += Math.pow(value - mean, 2);
  //     }
  //     // Calculate the standard deviation by taking the square root of the sum of squares divided by the count
  //     double std = Math.sqrt(sumOfSquares / summary.getCount());
  //     // Set the std attribute to the calculated value
  //     summary.setSTD(std);
  //     // Call the saveModel method to save the summary object to a file
  //     saveModel(summary);
  //   }
  // }

  // @Override
  // // Implement the saveModel method to save the serializable object to a file
  // public void saveModel(StatsSummary summary) {
  //   try {
  //     // Create a FileOutputStream object to write to the file stats.bin in the specified directory
  //     FileOutputStream fos = new FileOutputStream("C:/enterprise/tmp/model/stats.bin");
  //     // Create an ObjectOutputStream object to write the object to the file
  //     ObjectOutputStream oos = new ObjectOutputStream(fos);
  //     // Write the summary object to the file
  //     oos.writeObject(summary);
  //     // Close the ObjectOutputStream and the FileOutputStream
  //     oos.close();
  //     fos.close();
  //   } catch (Exception e) {
  //     // Handle any exception that may occur
  //     e.printStackTrace();
  //   }
  // }
}
