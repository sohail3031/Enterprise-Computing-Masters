package ec.asgmt;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.asgmt.sb.*;

@WebServlet("/get")
public class StatsStatelessServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
	
	@EJB
    private StatsStatelessLocal statsStateless;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String message = req.getParameter("value");

        switch (message) {
            case "count":
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>The count is " + statsStateless.getCount() + ".</p>");
                resp.getWriter().println("</body></html>");
        
                break;
            case "min":
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>The min is " + statsStateless.getMin() + ".</p>");
                resp.getWriter().println("</body></html>");
        
                break;
            case "max":
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>The max is " + statsStateless.getMax() + ".</p>");
                resp.getWriter().println("</body></html>");
        
                break;
            case "mean":
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>The mean is " + statsStateless.getMean() + ".</p>");
                resp.getWriter().println("</body></html>");
        
                break;
            case "std":
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>The std is " + statsStateless.getSTD() + ".</p>");
                resp.getWriter().println("</body></html>");
        
                break;
            case "summary":
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<table border=\"1\">");
                resp.getWriter().println("<tr><th>Statistic</th><th>Value</th></tr>");
                resp.getWriter().println("<tr><td>Count</td><td>" + statsStateless.getCount() + "</td></tr>");
                resp.getWriter().println("<tr><td>Min</td><td>" + statsStateless.getMin() + "</td></tr>");
                resp.getWriter().println("<tr><td>Max</td><td>" + statsStateless.getMax() + "</td></tr>");
                resp.getWriter().println("<tr><td>Mean</td><td>" + statsStateless.getMean() + "</td></tr>");
                resp.getWriter().println("<tr><td>Std</td><td>" + statsStateless.getSTD() + "</td></tr>");
                resp.getWriter().println("</table>");
                resp.getWriter().println("</body></html>");
        
                break;
            default:
                resp.setContentType("text/html");
                resp.getWriter().println("<html><head><title>Stats Web Application</title></head><body>");
                resp.getWriter().println("<h1>Stats Web Application</h1>");
                resp.getWriter().println("<p>Invalid query message.</p>");
                resp.getWriter().println("</body></html>");
        
                break;
        }
    }
}
