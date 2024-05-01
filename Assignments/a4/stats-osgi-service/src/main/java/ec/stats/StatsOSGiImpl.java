package ec.stats;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StatsOSGiImpl implements StatsOSGi {
	private StatsSummary ss;
	
	public StatsOSGiImpl() {
		ss = loadModel();
	}
	
	private StatsSummary loadModel() {
		StatsSummary summary = null;
        
		try {
          File file = new File("C:/enterprise/tmp/model/stats.bin");
            
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                summary = (StatsSummary) ois.readObject();
                ss = summary;
                
                ois.close();
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return summary;
    }

	public int getCount() {
		if (ss == null) {
			ss = loadModel();
        }
		
        if (ss != null) {
            return ss.getCount();
        } else {
            return 0;
        }
	}

	public double getMin() {
		if (ss == null) {
			ss = loadModel();
        }
		
        if (ss != null) {
            return ss.getMin();
        } else {
            return 0;
        }
	}

	public double getMax() {
		if (ss == null) {
			ss = loadModel();
        }
		
        if (ss != null) {
            return ss.getMax();
        } else {
            return 0;
        }
	}

	public double getMean() {
		if (ss == null) {
			ss = loadModel();
        }
		
        if (ss != null) {
            return ss.getMean();
        } else {
            return 0;
        }
	}

	public double getSTD() {
		if (ss == null) {
			ss = loadModel();
        }
        
        if (ss != null) {
            return ss.getSTD();
        } else {
            return 0;
        }
	}
    
	public String toString() {
        if (ss == null) {
        	ss = loadModel();
            
    		return null;
        }
        
        if (ss != null) {
            return ss.toString();
        } else {
            return "";
        }
    }
}