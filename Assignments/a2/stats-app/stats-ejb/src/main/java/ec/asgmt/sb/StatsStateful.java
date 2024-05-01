package ec.asgmt.sb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import ec.stats.StatsSummary;

@Stateful
@LocalBean
public class StatsStateful implements StatsStatefulRemote, StatsStatefulLocal {
	@EJB
    private StatsStatelessLocal sbsl;
    
    @EJB
    private StatsSingletonLocal ssbs;

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
        StatsSummary sm = sbsl.loadModel();

        String sts = 
            "Count: " + sm.getCount() + "<br>\n" +
            "Min: " + sm.getMin() + "<br>\n" +
            "Max: " + sm.getMax() + "<br>\n" +
            "Mean: " + sm.getMean() + "<br>\n" +
            "STD: " + sm.getSTD() + "<br>\n";
        
            return sts;
        // sbsl.loadModel();
        
        // return sbsl.toString();
    }
}
