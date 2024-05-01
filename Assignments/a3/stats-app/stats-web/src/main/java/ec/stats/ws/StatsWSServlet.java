package ec.stats.ws;

// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.xml.namespace.QName;
// import javax.xml.ws.Service;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.net.URL;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


// @WebServlet("/statsws")
public class StatsWSServlet extends HttpServlet {
    // private static final long serialVersionUID = 1L;

	// protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     response.setContentType("text/html");
    //     PrintWriter out = response.getWriter();

    //     try {
    //         URL url = new URL("http://localhost:8080/stats-ws/StatsWSImpl?wsdl");
    //         QName qname = new QName("http://ws.stats.ec/", "StatsWSImplService");
    //         Service service = Service.create(url, qname);
    //         StatsWS statsWS = service.getPort(StatsWS.class);

    //         out.println("<html><body>");
    //         out.println("<h1>Statistics Summary Information</h1>");
    //         out.println("<p>Count: " + statsWS.getCount() + "</p>");
    //         out.println("<p>Min: " + statsWS.getMin() + "</p>");
    //         out.println("<p>Max: " + statsWS.getMax() + "</p>");
    //         out.println("<p>Mean: " + statsWS.getMean() + "</p>");
    //         out.println("<p>Standard Deviation: " + statsWS.getSTD() + "</p>");
    //         out.println("</body></html>");
    //     } catch (Exception e) {
    //         out.println("<html><body>");
    //         out.println("<h1>Error</h1>");
    //         out.println("<p>" + e.getMessage() + "</p>");
    //         out.println("</body></html>");
    //     }
    // }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to HTML
        response.setContentType("text/html");
        // Get the output writer
        PrintWriter out = response.getWriter();
        try {
            // Create a URL object for the WSDL of the web service
            URL url = new URL("http://localhost:8080/stats-ws/StatsWSImpl?wsdl");
            // Create a QName object for the service name
            QName qname = new QName("http://ws.stats.ec/", "StatsWSImplService");
            // Create a Service object using the URL and QName
            Service service = Service.create(url, qname);
            // Get the port for the web service interface
            StatsWS statsWS = service.getPort(StatsWS.class);
            // Invoke the web service methods and generate the HTML content
            out.println("<html>");
            out.println("<head><title>Stats Web Service Client</title></head>");
            out.println("<body>");
            out.println("<h1>Stats Web Service Client</h1>");
            out.println("<p>Count: " + statsWS.getCount() + "</p>");
            out.println("<p>Min: " + statsWS.getMin() + "</p>");
            out.println("<p>Max: " + statsWS.getMax() + "</p>");
            out.println("<p>Mean: " + statsWS.getMean() + "</p>");
            out.println("<p>STD: " + statsWS.getSTD() + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            // Handle any exceptions
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            // Close the output writer
            out.close();
        }
    }
}
