package ec.asgmt;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@LocalBean
//@Local(StatsStatelessLocal.class)
//@Remote(StatsStatefulRemote.class)
public class StatsStateful implements StatsStatefulRemote, StatsStatefulLocal {
	private static final long serialVersionUID = 1L;

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
}
