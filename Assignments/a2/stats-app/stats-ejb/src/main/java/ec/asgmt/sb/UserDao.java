package ec.asgmt.sb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface UserDao {
    public void addUser(User user);

    public User getUser(String name, String password);

    public List<User> getAllUser();
}