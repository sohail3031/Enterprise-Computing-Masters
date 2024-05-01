package ec.asgmt.sb;

import javax.ejb.Local;

@Local
public interface StatsStatefulLocal {
    public void insertData(double a);
    
    public void createModel();
    
    public String getStats();
}