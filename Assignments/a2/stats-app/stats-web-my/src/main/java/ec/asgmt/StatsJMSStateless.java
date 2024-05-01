package ec.asgmt;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;

@Stateless
public class StatsJMSStateless implements StatsJMSStatelessLocal {

    @Inject
    JMSContext context;

    @Resource(lookup = "java:/queue/test")
    private Destination queue;

    @Resource(lookup = "java:/topic/test")
    private Destination topic;

    @Override
    public void produce(String message) {
        try {
            JMSProducer producer = context.createProducer();
        
            producer.send(queue, message);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void publish(double data) {
        try {
            JMSProducer producer = context.createProducer();
    
            producer.send(topic, data);
        }  catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}