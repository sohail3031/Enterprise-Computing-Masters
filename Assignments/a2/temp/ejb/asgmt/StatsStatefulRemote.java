package ec.asgmt;

import javax.ejb.Remote;

@Remote
public interface StatsStatefulRemote {
    public void insertData(double value);

    public void createModel();

    public String getStats();
}
