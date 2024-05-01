package ec.asgmt;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Local(StatsSingletonLocal.class)
@Remote(StatsSingletonRemote.class)
public class StatsSingleton implements StatsSingletonLocal, StatsSingletonRemote {
	private static final long serialVersionUID = 1L;
	private List<Double> data = new ArrayList<>();
    private int count = 0;
    private StatsSummary summary = new StatsSummary();

    @Override
    public void addData(double value) {
        data.add(value);
        
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void stats() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        double mean = 0;
        double variance = 0;
        double std = 0;
        
        for (Double d : data) {
            if (d < min) {
                min = d;
            }
            if (d > max) {
                max = d;
            }
            sum += d;
        }
        
        mean = sum / count;
        
        for (Double d : data) {
            variance += Math.pow(d - mean, 2);
        }
        
        variance = variance / count;
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
            if (!dir.exists()) {
                Files.createDirectories(dir.toPath());
            }
//            File file = new File("C:/enterprise/tmp/model/stats.bin");
            File file = new File("C:/Masters/Enterprise Computing/tmp/model/stats.bin");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(summary);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
