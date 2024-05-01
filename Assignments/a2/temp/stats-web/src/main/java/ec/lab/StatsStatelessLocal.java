package ec.lab;

import javax.ejb.Local;

@Local
public interface StatsStatelessLocal {
	public int getCount();
	public double getMin();
	public double getMax();
	public double getMean();
	public double getSTD();
	public String toString();
	public StatsSummary loadModel();
}