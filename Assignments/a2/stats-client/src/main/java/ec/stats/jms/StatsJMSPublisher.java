package ec.stats.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import ec.jms.ContextUtil;

public class StatsJMSPublisher {

    public static void main(String[] args) throws Exception {
    	Connection connection = null;
    	
    	try {
            System.out.println("Create JNDI Context");
            
            Context context = ContextUtil.getInitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
            connection = connectionFactory.createConnection("quickstartUser", "quickstartPwd1!");
            
            System.out.println("Create session");
            
            Session session = connection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            Destination topic = (Destination) context.lookup("jms/topic/test");
//            Destination topic = (Destination) context.lookup("jms/topic/statsQueue");
            
            System.out.println("Start connection");
            
            connection.start();
            
            System.out.println("Create producer");
            
            MessageProducer producer = session.createProducer(topic);
            
            System.out.println("Create a message");
            
            Message msg = session.createTextMessage(args[1]);
            
            System.out.println("Send message");
            
            producer.send(msg);

        } finally {
            if (connection != null) {
                System.out.println("close the connection");
        
                connection.close();
            }
        }
    	
        System.out.println("producer done");
    	
//        // get the initial context
//        InitialContext context = new InitialContext();
//
//        // lookup the connection factory
//        ConnectionFactory factory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
//
//        // lookup the topic object
//        Destination topic = (Destination) context.lookup("jms/topic/statsTopic");
//
//        // create a connection
//        Connection connection = factory.createConnection("username", "password");
//
//        // create a JMS context
//        JMSContext jmsContext = ((ConnectionFactory) connection).createContext();
//
//        // create a JMS producer
//        JMSProducer producer = jmsContext.createProducer();
//
//        // get the message from command line argument
//        String message = args[0];
//
//        // send the message to the topic
//        producer.send(topic, message);
//
//        // close the context
//        jmsContext.close();
    }
}
