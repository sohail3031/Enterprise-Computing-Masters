package ec.asgmt;

import javax.ejb.Local;

@Local
public interface StatsJMSStatelessLocal {
    public void produce(String message);

    public void publish(double data);
}