package ec.lab;

//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.ejb.EJB;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/add-data")
//public class StatsSingletonServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    
////	@EJB
////    private StatsSingletonLocal ssbs;
//	@EJB
//    private StatsSingleton ssbs = new StatsSingleton();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        res.setContentType("text/html");
//        
//        PrintWriter pw = res.getWriter();
//        
//        try {
//            // get the data value from the query parameter
//            double value = Double.parseDouble(req.getParameter("value"));
//            
//            // add the data value to the StatsSingleton bean
//            ssbs.addData(value);
//            // save the model
//            ssbs.saveModel();
//            // write the HTML response
//            pw.println("<html><body>");
//            pw.println("<h1>" + value + " added, model saved</h1>");
//            pw.println("</body></html>");
//        } catch (NumberFormatException e) {
//            // handle the invalid input
//            pw.println("<html><body>");
//            pw.println("<h1>Invalid input</h1>");
//            pw.println("</body></html>");
//        }
//        
//        pw.close();
//    }
//}


import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add-data")
public class StatsSingletonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private StatsSingleton statsSingleton;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String value = request.getParameter("value");
        
        statsSingleton.addData(Double.parseDouble(value));
        statsSingleton.stats();
        statsSingleton.saveModel();
        out.println("<html><body>");
        out.println("<h1>" + value + " added, model saved</h1>");
        out.println("</body></html>");
    }
}
