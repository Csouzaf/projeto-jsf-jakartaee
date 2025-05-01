package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;

public abstract class CriteriaDAO<T> {

    @PersistenceContext
    private EntityManager manager;

    private Class <T> clazz;

    public CriteriaDAO(Class <T> clazz) {
        this.clazz = clazz;
    }

    Session session = manager.unwrap(Session.class);
}
