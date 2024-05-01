package ec.asgmt;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class StatsStateful implements StatsStatefulLocal {	
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

    @Override
    public int getCount() {
        return ssbs.getCount();
    }

	@Override
	public double getMin() {
		return ssbs.getMin();
//		return sbsl.getMin();
	}

	@Override
	public double getMax() {
		return ssbs.getMax();
//		return sbsl.getMax();
	}

	@Override
	public double getMean() {
		return ssbs.getMean();
//		return sbsl.getMean();
	}

	@Override
	public double getSTD() {
		return ssbs.getSTD();
//		return sbsl.getSTD();
	}
}
