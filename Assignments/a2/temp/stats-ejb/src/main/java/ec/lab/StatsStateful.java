package ec.lab;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;


@Stateful
@LocalBean
public class StatsStateful implements StatsStatefulRemote, StatsStatefulLocal {
	@EJB
    private StatsStateless sbsl;
    
    @EJB
    private StatsSingleton ssbs;

    @Override
    public void insertData(double a) {
        ssbs.addData(a);
    }

    @Override
    public void createModel() {
        ssbs.saveModel();
    }

    @Override
    public String getStats() {
        sbsl.loadModel();
        
        return sbsl.toString();
    }

//    @Override
//    public int getCount() {
//        return ssbs.getCount();
//    }
}
