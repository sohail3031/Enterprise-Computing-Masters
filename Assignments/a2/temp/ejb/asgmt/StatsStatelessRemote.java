package ec.asgmt;

import javax.ejb.Remote;

@Remote
public interface StatsStatelessRemote {
    public int getCount();

    public double getMin();
    
    public double getMax();
    
    public double getMean();
    
    public double getSTD();

    public String toString();
}
