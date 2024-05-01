package ec.stats.mdb;

import java.io.FileWriter;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "store", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/test"),
})
public class StatsMDBStoreData implements MessageListener {
    private static final String FILE_PATH = "C:/enterprise/tmp/data/stats.dat"; // the file path
	
//    @EJB
//	StatsStateful statsStateful; // the injected session bean
    // @EJB
	// StatsSingleton statsSingleton;

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String data = textMessage.getText(); // get the data string
                FileWriter fileWriter = new FileWriter(FILE_PATH, true); // create a file writer in append mode

                // StatsSummary statsSummary = (StatsSummary)(TextMessage) message;
            
//            saveStatsSummary(statsSummary);
            
                // statsSingleton.saveModel(statsSummary);
                
                fileWriter.write(data + "\n"); // write the data string to the file with a new line
                fileWriter.close(); // close the file writer
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}