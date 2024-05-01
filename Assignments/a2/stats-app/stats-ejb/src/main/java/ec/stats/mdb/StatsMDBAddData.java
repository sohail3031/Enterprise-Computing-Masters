package ec.stats.mdb;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import ec.asgmt.sb.StatsSingleton;

import javax.ejb.ActivationConfigProperty;

//@MessageDriven(mappedName = "jms/DataTopic")
@MessageDriven(name = "add", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/test"),
})
public class StatsMDBAddData implements MessageListener {
	@EJB
	StatsSingleton statsStateful; // the injected session bean

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String data = textMessage.getText(); // get the data string
                double value = Double.parseDouble(data); // convert to double
                
                statsStateful.addData(value); // invoke the session bean method
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
