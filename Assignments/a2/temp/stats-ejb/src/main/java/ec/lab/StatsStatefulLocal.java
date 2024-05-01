package ec.lab;

import javax.ejb.Local;

@Local
public interface StatsStatefulLocal {
    public void insertData(double a);
    public void createModel();
    public String getStats();
//    public int getCount();
}