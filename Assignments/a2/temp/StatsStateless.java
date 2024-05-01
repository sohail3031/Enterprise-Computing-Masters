package ec.asgmt;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Stateless
@LocalBean
public class StatsStateless implements StatsStatelessLocal {
	private StatsSummary sm = null;
	@EJB
    private StatsSingleton ssbs;

    @Override
    public StatsSummary loadModel() {
        try {
            File file = new File("C:/enterprise/tmp/model/stats.bin");
            
            File parent = file.getParentFile();
            
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                sm = (StatsSummary) ois.readObject();
                
                ois.close();
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        return sm;
    }

    @Override
    public int getCount() {
    	return ssbs.getCount();
//        if (sm == null) {
//            sm = loadModel();
//        }
//        
//        if (sm != null) {
//            return sm.getCount();
//        } else {
//            return 0;
//        }
    }

    @Override
    public double getMin() {
    	return ssbs.getMin();
//        if (sm == null) {
//            sm = loadModel();
//        }
//        
//        if (sm != null) {
//            return sm.getMin();
//        } else {
//            return 0;
//        }
    }

    @Override
    public double getMax() {
    	return ssbs.getMax();
//        if (sm == null) {
//            sm = loadModel();
//        }
//        
//        if (sm != null) {
//            return sm.getMax();
//        } else {
//            return 0;
//        }
    }

    @Override
    public double getMean() {
    	return ssbs.getMean();
//        if (sm == null) {
//            sm = loadModel();
//        }
//        
//        if (sm != null) {
//            return sm.getMean();
//        } else {
//            return 0;
//        }
    }

    @Override
    public double getSTD() {
    	return ssbs.getSTD();
//        if (sm == null) {
//            sm = loadModel();
//        }
//        
//        if (sm != null) {
//            return sm.getSTD();
//        } else {
//            return 0;
//        }
    }

    @Override
    public String toString() {
        if (sm == null) {
            sm = loadModel();
            
    		return null;
        }
        
        if (sm != null) {
            return sm.toString();
        } else {
            return "";
        }
    }
}
