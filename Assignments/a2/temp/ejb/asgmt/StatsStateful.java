package ec.asgmt;

import javax.ejb.EJB;
import javax.ejb.Stateful;

// Annotate the class as a stateful session bean
@Stateful
// Implement both the local and remote interfaces
public class StatsStateful implements StatsStatefulLocal, StatsStatefulRemote {

  // Inject the StatsSingleton and StatsStateless beans
  @EJB
  private StatsSingletonLocal ssbs;
  @EJB
  private StatsStatelessLocal sbsl;
  @EJB
  private StatsStateless stateless;

  // Override the insertData method
  public void insertData(double value) {
    // Invoke the addData method of the StatsSingleton bean
    ssbs.addData(value);
  }

  // Override the createModel method
  public void createModel() {
    // Invoke the saveModel method of the StatsSingleton bean
    ssbs.saveModel(stateless.loadModel());
  }

  // Override the getStats method
  public String getStats() {
    // Invoke the toString method of the StatsStateless bean
    return sbsl.toString();
  }

  // Optionally, add the getCount method
  public int getCount() {
    // Invoke the getCount method of the StatsSingleton bean
    return ssbs.getCount();
  }
}
