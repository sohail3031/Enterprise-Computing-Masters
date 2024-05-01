package ec.asgmt;

import javax.ejb.Local;
import java.io.Serializable;

@Local
public interface StatsSingletonLocal extends Serializable {
	public void addData(double value);
	public int getCount();
	public void stats();
	public void saveModel();
}