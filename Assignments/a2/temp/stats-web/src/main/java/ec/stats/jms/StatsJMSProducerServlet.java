package ec.stats.jms;

import java.io.IOException;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/producer")
public class StatsJMSProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jms/MyConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/queue/test")
    private Destination queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the message parameter from the HTTP query
        String message = req.getParameter("message");

        // check if the message value is "save"
        if ("save".equals(message)) {
            // create a JMS context
            try (JMSContext context = connectionFactory.createContext()) {
                // create a JMS producer
                JMSProducer producer = context.createProducer();
                // send the message to the queue
                producer.send(queue, message);
            }
        }
    }
}
