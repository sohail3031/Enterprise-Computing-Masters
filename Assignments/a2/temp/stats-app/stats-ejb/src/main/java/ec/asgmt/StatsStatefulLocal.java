package ec.asgmt;

import java.io.Serializable;

import javax.ejb.Local;

@Local
public interface StatsStatefulLocal extends Serializable {
    public void insertData(double a);
    public void createModel();
    public String getStats();
}