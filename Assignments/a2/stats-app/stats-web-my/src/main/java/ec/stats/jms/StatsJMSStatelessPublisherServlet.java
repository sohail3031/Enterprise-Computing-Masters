package ec.stats.jms;

import ec.asgmt.StatsJMSStatelessLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sbpublisher")
public class StatsJMSStatelessPublisherServlet extends HttpServlet {

    @EJB
    private StatsJMSStatelessLocal statsJMSStateless;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String data = req.getParameter("message");

        try {
            double value = Double.parseDouble(data);
            
            statsJMSStateless.publish(value);
            resp.setContentType("text/html");
            resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
            resp.getWriter().println("<h1>Stats Web Application</h1>");
            resp.getWriter().println("<p>" + data + " message has been send to the topic object.</p>");
            resp.getWriter().println("</body></html>");
        } catch (Exception e) {
            resp.setContentType("text/html");
            resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
            resp.getWriter().println("<h1>Stats Web Application</h1>");
            resp.getWriter().println("<p>" + data + " is invalid!.</p>");
            resp.getWriter().println("</body></html>");
        }
    }
}