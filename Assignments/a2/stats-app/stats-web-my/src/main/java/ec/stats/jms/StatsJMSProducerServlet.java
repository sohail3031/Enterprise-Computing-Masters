package ec.stats.jms;

import java.io.IOException;
import javax.annotation.Resource;
import javax.inject.Inject;
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

    @Inject
    JMSContext context;

    @Resource(lookup = "java:/queue/test")
    private Destination queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");

        if ("save".equals(message)) {
            try {
                JMSProducer producer = context.createProducer();
                
                producer.send(queue, message);
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>" + message + " message has been send to the queue object.</p>");
                resp.getWriter().println("</body></html>");
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
