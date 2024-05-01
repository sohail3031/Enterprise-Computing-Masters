package ec.asgmt.sb;

import javax.ejb.Remote;

import ec.stats.StatsSummary;

@Remote
public interface StatsSingletonRemote {
    public void addData(double value);

    public int getCount();

    public StatsSummary stats();

    public void saveModel();
}
