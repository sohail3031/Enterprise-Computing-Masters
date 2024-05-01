package ec.asgmt.sb;

import javax.ejb.Local;

import ec.stats.StatsSummary;

@Local
public interface StatsSingletonLocal {
    public void addData(double value);

    public int getCount();

    public StatsSummary stats();

    public void saveModel();
}
