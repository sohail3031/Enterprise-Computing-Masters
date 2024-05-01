package ec.stats.mdb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import ec.lab.StatsSingleton;
import ec.lab.StatsStateless;
import ec.stats.StatsSummary;

@MessageDriven(
    name = "save",activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/test"),
    })
//activationConfig = {
//        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
//        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
// })
public class StatsMDBSaveModel implements MessageListener {
    // Inject your session bean (StatsSummarySessionBean) here
    // For simplicity, let's assume it has a method called saveStatsSummary
	
//	@EJB
//	StatsStateless stateless;
	@EJB
	StatsSingleton statsSingleton;

    // This method is invoked when a message arrives in the queue
    public void onMessage(Message message) {
        try {
            // Parse the message (e.g., extract relevant data)
            // Save the StatsSummary object using your session bean
            // For demonstration purposes, let's assume the message contains relevant data
            StatsSummary statsSummary = (StatsSummary)(TextMessage) message;
            
//            saveStatsSummary(statsSummary);
            
            statsSingleton.saveModel(statsSummary);
//            statsSummarySessionBean.saveStatsSummary(statsSummary);

            // Optionally, you can log or perform additional processing
        } catch (Exception e) {
            // Handle exceptions (e.g., logging, retry logic, etc.)
        	e.printStackTrace();
        }
    }
    
//    private void saveStatsSummary(StatsSummary summary) {
//    	try {
//            File dir = new File("C:/enterprise/tmp/model/");
//            
//            if (!dir.exists()) {
//                Files.createDirectories(dir.toPath());
//            }
//            
//            File file = new File("C:/enterprise/tmp/model/stats.bin");
//            FileOutputStream fos = new FileOutputStream(file);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            
//            oos.writeObject(summary);
//            oos.close();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // Other utility methods (e.g., parsing message content) go here
    // ...

//    private StatsSummary extractStatsSummaryFromMessage(Message message) {
        // Extract relevant data from the message and create a StatsSummary object
        // For example:
        // - Deserialize the message content
        // - Extract relevant fields (e.g., timestamp, values, etc.)
        // - Create a new StatsSummary instance
        // Return the created StatsSummary object
//    }
}
