package ec.stats.jms;

import ec.asgmt.User;
import ec.asgmt.UserDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @EJB
    private UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = userDao.getUser(name, password);

        if (user != null) {
            int role = user.getRole();

            switch (role) {
                case 1:
                    resp.sendRedirect("admin.html");

                    break;
                case 2:
                    resp.sendRedirect("developer.html");
                    
                    break;
                case 3:
                    resp.sendRedirect("user.html");
                    
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid role");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid user name or password");
        }
    }
}