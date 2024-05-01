package ec.asgmt;

import javax.ejb.Local;

import ec.stats.StatsSummary;

@Local
public interface StatsSingletonLocal {
    public void addData(double value);

    public int getCount();

    public void stats();

    public void saveModel(StatsSummary summary);
}
