package ec.asgmt;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import ec.stats.StatsSummary;

@Singleton
// Specify the local and remote interfaces for the bean
@Local(StatsSingletonLocal.class)
@Remote(StatsSingletonRemote.class)
public class StatsSingleton implements StatsSingletonLocal {
     // Declare an array of double values to store the data set
  private double[] data;

  @Override
  // Implement the addData method to add a value to the data set
  public void addData(double value) {
    // If the data array is null, initialize it with a single element
    if (data == null) {
      data = new double[]{value};
    } else {
      // Otherwise, create a new array with one more element than the original array
      double[] newData = new double[data.length + 1];
      // Copy the original array elements to the new array
      System.arraycopy(data, 0, newData, 0, data.length);
      // Add the new value to the last position of the new array
      newData[data.length] = value;
      // Assign the new array to the data array
      data = newData;
    }
  }

  @Override
  // Implement the getCount method to return the number of data elements
  public int getCount() {
    // If the data array is null, return zero
    if (data == null) {
      return 0;
    } else {
      // Otherwise, return the length of the data array
      return data.length;
    }
  }

  @Override
  // Implement the stats method to compute the descriptive statistics
  public void stats() {
    // If the data array is not null and has at least one element
    if (data != null && data.length > 0) {
      // Sort the data array in ascending order
      Arrays.sort(data);
      // Create a new StatsSummary object
      StatsSummary summary = new StatsSummary();
      // Set the count attribute to the length of the data array
      summary.setCount(data.length);
      // Set the min attribute to the first element of the data array
      summary.setMin(data[0]);
      // Set the max attribute to the last element of the data array
      summary.setMax(data[data.length - 1]);
      // Declare a variable to store the sum of the data values
      double sum = 0;
      // Loop through the data array and add each value to the sum
      for (double value : data) {
        sum += value;
      }
      // Calculate the mean by dividing the sum by the count
      double mean = sum / summary.getCount();
      // Set the mean attribute to the calculated value
      summary.setMean(mean);
      // Declare a variable to store the sum of the squared deviations from the mean
      double sumOfSquares = 0;
      // Loop through the data array and add the squared deviation of each value from the mean to the sum of squares
      for (double value : data) {
        sumOfSquares += Math.pow(value - mean, 2);
      }
      // Calculate the standard deviation by taking the square root of the sum of squares divided by the count
      double std = Math.sqrt(sumOfSquares / summary.getCount());
      // Set the std attribute to the calculated value
      summary.setSTD(std);
      // Call the saveModel method to save the summary object to a file
      saveModel(summary);
    }
  }

  @Override
  // Implement the saveModel method to save the serializable object to a file
  public void saveModel(StatsSummary summary) {
    try {
      // Create a FileOutputStream object to write to the file stats.bin in the specified directory
      FileOutputStream fos = new FileOutputStream("C:/enterprise/tmp/model/stats.bin");
      // Create an ObjectOutputStream object to write the object to the file
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      // Write the summary object to the file
      oos.writeObject(summary);
      // Close the ObjectOutputStream and the FileOutputStream
      oos.close();
      fos.close();
    } catch (Exception e) {
      // Handle any exception that may occur
      e.printStackTrace();
    }
  }
}
