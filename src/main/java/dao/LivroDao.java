package dao;

import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Typed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Livro;
import org.hibernate.annotations.Type;

@Stateless
public class LivroDao extends DefaultDao<Livro>{

    public LivroDao() {
        super(Livro.class);
    }

}
