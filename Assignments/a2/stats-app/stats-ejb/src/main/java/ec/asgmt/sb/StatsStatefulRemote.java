package ec.asgmt.sb;

import javax.ejb.Remote;

@Remote
public interface StatsStatefulRemote {
    public void insertData(double a);
    
    public void createModel();
    
    public String getStats();
}