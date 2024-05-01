package ec.lab;

import javax.ejb.Remote;
import java.io.Serializable;

@Remote
public interface StatsStatelessRemote {
    public int getCount();
    public double getMin();
    public double getMax();
    public double getMean();
    public double getSTD();
    public String toString();
}
