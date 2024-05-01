package ec.lab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/get")
public class StatsStatelessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private StatsStateless statsStateless;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String message = request.getParameter("value");

        out.println("<html><body>");
        
        switch (message) {
            case "count":
                out.println("<h1>" + message + ": " + String.valueOf(statsStateless.getCount()) + "</h1>");
                
                break;
            case "min":
                out.println("<h1>" + message + ": " + String.valueOf(statsStateless.getMin()) + "</h1>");
                
                break;
            case "max":
                out.println("<h1>" + message + ": " + String.valueOf(statsStateless.getMax()) + "</h1>");
                
                break;
            case "mean":
                out.println("<h1>" + message + ": " + String.valueOf(statsStateless.getMean()) + "</h1>");
                
                break;
            case "std":
                out.println("<h1>" + message + ": " + String.valueOf(statsStateless.getSTD()) + "</h1>");
                
                break;
            case "summary":
                out.println("<h1>" + message + ": " + "</h1><br/>");
                out.println("<h1>" + "Count: " + String.valueOf(statsStateless.getCount()) + "</h1><br/>");
                out.println("<h1>" + "Minimum: " + String.valueOf(statsStateless.getMin()) + "</h1><br/>");
                out.println("<h1>" + "Maximum: " + String.valueOf(statsStateless.getMax()) + "</h1><br/>");
                out.println("<h1>" + "Mean: " + String.valueOf(statsStateless.getMean()) + ": " + "</h1><br/>");
                out.println("<h1>" + "Standard Deviation: " + String.valueOf(statsStateless.getSTD()) + "</h1><br/>");
                
                break;
            default:
                out.println("<h1>" + message + ": Invalid message </h1>");
                
                break;
        }
        
        out.println("</body></html>");
    }
}
