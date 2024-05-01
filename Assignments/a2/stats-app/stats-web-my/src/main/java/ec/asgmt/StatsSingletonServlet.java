package ec.asgmt;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.asgmt.sb.*;

@WebServlet("/add-data")
public class StatsSingletonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StatsSingletonRemote statsSingleton;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String value = req.getParameter("value");

        try {
            double data = Double.parseDouble(value);

            statsSingleton.addData(data);
            statsSingleton.saveModel();
            resp.setContentType("text/html");
            resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
            resp.getWriter().println("<h1>Stats Web Application</h1>");
            resp.getWriter().println("<p>" + value + " added, model saved.</p>");
            resp.getWriter().println("</body></html>");
        } catch (NumberFormatException e) {
            resp.setContentType("text/html");
            resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
            resp.getWriter().println("<h1>Stats Web Application</h1>");
            resp.getWriter().println("<p>Invalid data value.</p>");
            resp.getWriter().println("</body></html>");
        }
    }
}
