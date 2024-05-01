package ec.asgmt;

import javax.ejb.Local;

@Local
public interface StatsStatefulLocal {
    public void insertData(double value);

    public void createModel();

    public String getStats();
}
