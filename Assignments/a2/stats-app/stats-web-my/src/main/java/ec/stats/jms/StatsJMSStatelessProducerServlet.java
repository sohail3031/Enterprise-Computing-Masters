package ec.stats.jms;

import ec.asgmt.StatsJMSStatelessLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sbproducer")
public class StatsJMSStatelessProducerServlet extends HttpServlet {

    @EJB
    private StatsJMSStatelessLocal statsJMSStateless;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String message = req.getParameter("message");

        statsJMSStateless.produce(message);

        resp.setContentType("text/html");
        resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
        resp.getWriter().println("<h1>Stats Web Application</h1>");
        resp.getWriter().println("<p>" + message + " message has been send to the queue object.</p>");
        resp.getWriter().println("</body></html>");
    }
}