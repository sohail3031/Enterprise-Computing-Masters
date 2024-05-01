package ec.asgmt;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.asgmt.sb.*;

@WebServlet("/insert-data")
public class StatsStatefulServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
	@EJB
    private StatsStatefulRemote statsStateful;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String value = req.getParameter("value");

        try {
            double data = Double.parseDouble(value);

            statsStateful.insertData(data);
            statsStateful.createModel();

            String model = statsStateful.getStats();

            resp.setContentType("text/html");
            resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
            resp.getWriter().println("<h1>Stats Web Application</h1>");
            resp.getWriter().println("<p>Model: " + model + "</p>");
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
