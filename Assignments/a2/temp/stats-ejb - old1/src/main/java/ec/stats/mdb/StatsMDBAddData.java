package ec.stats.mdb;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import ec.lab.SBSingleton;
import ec.lab.StatsSingleton;

//@MessageDriven(mappedName = "jms/DataTopic")
@MessageDriven(mappedName = "jms/AddTopic")
public class StatsMDBAddData implements MessageListener {

	@EJB
	SBSingleton statsSingleton; // the injected session bean

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String data = textMessage.getText(); // get the data string
                double value = Double.parseDouble(data); // convert to double
                
                statsSingleton.addData(value); // invoke the session bean method
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
