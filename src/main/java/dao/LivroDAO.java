package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Livro;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@Stateless
public class LivroDAO {

    @PersistenceContext
    EntityManager manager;

    private final String EDT = "EDT";
    private final String LV = "LV";
    private final String PONTO = "PONTO";


    public List<String> buscarLivrosPorEditoraId(Integer id){
        Session session = manager.unwrap(Session.class);

        DetachedCriteria criteria = DetachedCriteria.forClass(Livro.class, LV)
                .createAlias(Livro.Fields.EDITORA.name(), LV)
                .add(Restrictions.eq(EDT.concat(PONTO).concat("id"), id))
                .setProjection(Projections.property(
                        LV.concat(PONTO).concat("nome")
                ));

        return criteria.getExecutableCriteria(session).list();
    }

}
