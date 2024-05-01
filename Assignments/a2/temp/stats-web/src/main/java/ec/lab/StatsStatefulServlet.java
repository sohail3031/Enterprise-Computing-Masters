package ec.lab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/insert-data")
public class StatsStatefulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private StatsStateful statsStateful;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String value = request.getParameter("value");
        
        statsStateful.insertData(Double.parseDouble(value));
        statsStateful.createModel();
        
        int count = statsStateful.getCount();
        double min = statsStateful.getMin();
        double max = statsStateful.getMax();
        double mean = statsStateful.getMean();
        double std = statsStateful.getSTD();
        
        out.println("<html><body>");
        out.println("<h1>Statistics of the array list</h1>");
        out.println("<p>Count: " + count + "</p>");
        out.println("<p>Min: " + min + "</p>");
        out.println("<p>Max: " + max + "</p>");
        out.println("<p>Mean: " + mean + "</p>");
        out.println("<p>Std: " + std + "</p>");
        out.println("</body></html>");
    }
}
