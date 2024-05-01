package ec.lab;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Singleton
@LocalBean
public class StatsSingleton implements StatsSingletonLocal {
	private static final long serialVersionUID = 1L;
	private List<Double> data = new ArrayList<>();
    private int count = 0;
    private StatsSummary summary = new StatsSummary();

    @Override
    public void addData(double value) {
        data.add(value);
        
        count += 1;
    }

    @Override
    public int getCount() {
        return count;
    }
    
    public double getMin() {
    	double min = Double.MAX_VALUE;
    	
    	for (Double d : data) {
    		if (d < min) {
                min = d;
            }
    	}
    	
    	return min;
    }
    
    public double getMax() {
    	double max = Double.MIN_VALUE;
    	
    	for (Double d : data) {
    		if (d > max) {
                max = d;
            }
    	}
    	
    	return max;
    }
    
    public double getMean() {
    	double sum = 0, mean = 0, total = 0;
    	
    	for (Double d : data) {
    		sum += d;
    		total++;
    	}
    	
    	mean = sum / total;
    	
    	return mean;
    }
    
    public double getSTD() {
    	double std = 0, variance = 0, mean = 0, total = 0;
    	
    	for (Double d : data) {
            variance += Math.pow(d - mean, 2);
            total++;
        }
        
        variance = variance / total;
        std = Math.sqrt(variance);
        
        return std;
    }

    @Override
    public void stats() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        double mean = 0;
        double variance = 0;
        double std = 0;
        double total = 0;
        
        for (Double d : data) {
            if (d < min) {
                min = d;
            }
            
            if (d > max) {
                max = d;
            }
            
            sum += d;
            total++;
        }
        
        mean = sum / total;
        
        for (Double d : data) {
            variance += Math.pow(d - mean, 2);
        }
        
        variance = variance / total;
        std = Math.sqrt(variance);
        
        summary.setCount(count);
        summary.setMin(min);
        summary.setMax(max);
        summary.setMean(mean);
        summary.setSTD(std);
    }

    @Override
    public void saveModel() {
        try {
            File dir = new File("C:/enterprise/tmp/model/");
            
            try {
                File parent = dir.getParentFile();
                
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }
                
                boolean created = dir.createNewFile();
                
                if (created) {
                    System.out.println("File created: " + dir.getName());
                } else {
                    System.out.println("File already exists: " + dir.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if (!dir.exists()) {
                Files.createDirectories(dir.toPath());
            }
            
            File file = new File("C:/enterprise/tmp/model/stats.bin");
            
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(summary);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
