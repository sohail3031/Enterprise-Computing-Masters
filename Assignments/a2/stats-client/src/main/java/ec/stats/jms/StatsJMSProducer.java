package ec.stats.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

import ec.jms.ContextUtil;

public class StatsJMSProducer {

    public static void main(String[] args) throws NamingException, JMSException {
    	Connection connection = null;
    	
    	try {
            System.out.println("Create JNDI Context");
            
            Context context = ContextUtil.getInitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
            connection = connectionFactory.createConnection("quickstartUser", "quickstartPwd1!");
            
            System.out.println("Create session");
            
            Session session = connection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            Destination queue = (Destination) context.lookup("jms/queue/test");
//            Destination queue = (Destination) context.lookup("jms/queue/statsQueue");
            
            System.out.println("Start connection");
            
            connection.start();
            
            System.out.println("Create producer");
            
            MessageProducer producer = session.createProducer(queue);
            
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
    	
    	
        // get the initial context
//        InitialContext context = new InitialContext();
//
//        // lookup the connection factory
//        ConnectionFactory factory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
//
//        // lookup the queue object
//        Destination queue = (Destination) context.lookup("jms/queue/statsQueue");
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
//        // send the message to the queue
//        producer.send(queue, message);
//
//        // close the context
//        jmsContext.close();
    }
}
