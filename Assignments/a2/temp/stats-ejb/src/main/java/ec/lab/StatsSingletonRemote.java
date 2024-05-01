package ec.lab;

import javax.ejb.Remote;

import java.io.Serializable;

@Remote
public interface StatsSingletonRemote extends Serializable {
	public void addData(double value);
	public int getCount();
	public void stats();
	public void saveModel();
}