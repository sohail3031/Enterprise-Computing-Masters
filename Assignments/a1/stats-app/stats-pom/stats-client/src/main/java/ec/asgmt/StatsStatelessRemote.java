package ec.asgmt;

import javax.ejb.Remote;
import java.io.Serializable;

@Remote
public interface StatsStatelessRemote extends Serializable {
    public int getCount();
    public double getMin();
    public double getMax();
    public double getMean();
    public double getSTD();
    public String toString();
}
