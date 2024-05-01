package ec.asgmt;

import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface StatsStatefulRemote extends Serializable {
    public void insertData(double a);
    public void createModel();
    public String getStats();
}