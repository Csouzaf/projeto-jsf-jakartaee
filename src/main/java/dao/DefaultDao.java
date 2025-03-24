package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class DefaultDao<T> {

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


}
