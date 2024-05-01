package ec.asgmt;

import javax.ejb.Local;
import java.io.Serializable;

@Local
public interface StatsStatelessLocal extends Serializable {
	public int getCount();
	public double getMin();
	public double getMax();
	public double getMean();
	public double getSTD();
	public String toString();
	public StatsSummary loadModel();
}
