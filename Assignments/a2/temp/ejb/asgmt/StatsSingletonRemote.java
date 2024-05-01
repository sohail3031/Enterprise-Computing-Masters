package ec.asgmt;

import javax.ejb.Remote;

import ec.stats.StatsSummary;

@Remote
public interface StatsSingletonRemote {
    public void addData(double value);

    public int getCount();

    public void stats();

    public void saveModel(StatsSummary summary);
}
