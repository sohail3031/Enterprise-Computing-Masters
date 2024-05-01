package ec.asgmt.sb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateful
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "stats-ejb")
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(String name, String password) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.password = :password", User.class);

        query.setParameter("name", name);
        query.setParameter("password", password);

        return query.getSingleResult();
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);

        return query.getResultList();
    }
}