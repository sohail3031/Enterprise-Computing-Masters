package ec.lab;

import javax.ejb.Local;

import ec.stats.StatsSummary;

import java.io.Serializable;

@Local
public interface StatsStatelessLocal {
	public int getCount();
	public double getMin();
	public double getMax();
	public double getMean();
	public double getSTD();
	public String toString();
}
