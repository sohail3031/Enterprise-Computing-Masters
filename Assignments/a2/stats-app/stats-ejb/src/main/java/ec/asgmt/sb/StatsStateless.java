package ec.asgmt.sb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.stats.StatsSummary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

@Stateless
@LocalBean
// @Local(StatsStatelessLocal.class)
// @Remote(StatsStatelessRemote.class)
public class StatsStateless implements StatsStatelessLocal, StatsStatelessRemote {
    public static final Logger LOGGER = Logger.getLogger(StatsStateless.class.getName());

	private StatsSummary sm = null;

    @EJB
    private StatsSingletonLocal singletonLocal;

    public StatsSummary loadModel() {
        StatsSummary summary = null;

        try {
           File file = new File("C:/enterprise/tmp/model/stats.bin");

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                summary = (StatsSummary) ois.readObject();
                
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        LOGGER.info("Model read: \n" + summary.toString());
        
        return summary;
    }

    @Override
    public int getCount() {
        if (sm == null) {
            sm = loadModel();
        }

        if (sm != null) {
            return sm.getCount();
        } else {
            return 0;
        }
    }

    @Override
    public double getMin() {
        if (sm == null) {
            sm = loadModel();
        }

        if (sm != null) {
            return sm.getMin();
        } else {
            return 0;
        }
    }

    @Override
    public double getMax() {
        if (sm == null) {
            sm = loadModel();
        }

        if (sm != null) {
            return sm.getMax();
        } else {
            return 0;
        }
    }

    @Override
    public double getMean() {
        if (sm == null) {
            sm = loadModel();
        }
        
        if (sm != null) {
            return sm.getMean();
        } else {
            return 0;
        }
    }

    @Override
    public double getSTD() {
        if (sm == null) {
            sm = loadModel();
        }
        
        if (sm != null) {
            return sm.getSTD();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (sm == null) {
            sm = loadModel();
        }
        
        if (sm != null) {
            return sm.toString();
        } else {
            return "\nFailed to load model!!\n";
        }
    }
}
