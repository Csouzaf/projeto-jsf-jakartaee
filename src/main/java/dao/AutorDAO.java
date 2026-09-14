package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Autor;
import models.Editora;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Stateless
public class AutorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final String AUT = "AUT", PONTO = ".", EDA = "EDA",
            LV = "LV", EDT = "EDT";


    private List<Integer> listaInteiros = new ArrayList<>();

    public List<Integer> buscarAutoresId(){

        Session session = entityManager.unwrap(Session.class);

        DetachedCriteria critera = DetachedCriteria.forClass(Autor.class, AUT)
                .setProjection(Projections.property("id"));

        return critera.getExecutableCriteria(session).list();
    }



    public List<String> listaNomesAutoresPorNomeEditora(String nomeEditora){

        Session session = entityManager.unwrap(Session.class);

        DetachedCriteria criteria = DetachedCriteria.forClass(Autor.class, AUT)
                .createAlias(AUT.concat(PONTO).concat(Autor.Fields.EDITORA.toString()), EDA)
            //    .createAlias(Editora.Fields.ID.name(), EDT)
                .add(Restrictions.like(EDT.concat(PONTO).concat("nome"), nomeEditora.concat("%")))
                .setProjection(Projections.projectionList()
                        .add(Projections.property(AUT.concat(PONTO).concat("nome"))));

        
        return criteria.getExecutableCriteria(session).list();
    }
}
