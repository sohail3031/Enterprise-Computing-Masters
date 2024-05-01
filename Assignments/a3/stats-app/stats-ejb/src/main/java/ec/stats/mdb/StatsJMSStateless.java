package ec.stats.mdb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;

@Stateless
public class StatsJMSStateless implements StatsJMSStatelessLocal {

    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/queue/test")
    private Queue queue;
  
    @Resource(lookup = "java:/topic/test")
    private Topic topic;

    @Override
    public void produce(String message) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void publish(String data) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(topic, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
