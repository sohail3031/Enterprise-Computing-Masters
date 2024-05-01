package ec.stats;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import ec.asgmt.StatsSingletonRemote;



@WebServlet("/add-data")
public class StatsSingletonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StatsSingletonRemote statsSingleton;
}
