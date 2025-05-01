package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public abstract class DefaultDao<T>  {

    @PersistenceContext
    private EntityManager manager;

    private Class<T> entityClass;

    public DefaultDao (Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void salvar(T entity) {
        manager.persist(entity);
    }

    public void excluir(T entity) {
        manager.remove(entity);
    }

    public List<T> buscarTodos () {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

        Session session = manager.unwrap(Session.class);

        return criteria
                .getExecutableCriteria(session)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();

//        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
//        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
//        Root<T> root = criteriaQuery.from(entityClass);
//        criteriaQuery.select(root);
//        return manager.createQuery(criteriaQuery).getResultList();

    }


}
