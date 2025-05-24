package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Autor;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class AutorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private List<Integer> listaInteiros = new ArrayList<>();

    public List<Integer> buscarAutoresId(){

        Session session = entityManager.unwrap(Session.class);

        DetachedCriteria critera = DetachedCriteria.forClass(Autor.class, "AUT")
                .setProjection(Projections.property("id"));

        return critera.getExecutableCriteria(session).list();
    }
}
