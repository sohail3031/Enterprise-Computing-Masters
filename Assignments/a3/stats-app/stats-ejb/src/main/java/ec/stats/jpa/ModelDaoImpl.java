package ec.stats.jpa;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateful
public class ModelDaoImpl implements ModelDao {
    @PersistenceContext(unitName = "stats-ejb")
    private EntityManager entityManager;

    @Override
    public void saveModel(Model model) {
        entityManager.persist(model);
    }

    @Override
    public Model getModel(String modelname) {
        TypedQuery<Model> query = entityManager.createQuery("SELECT m FROM Model m WHERE m.name = :modelname", Model.class);

        query.setParameter("modelname", modelname);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
