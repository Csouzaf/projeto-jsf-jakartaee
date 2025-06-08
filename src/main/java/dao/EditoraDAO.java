package dao;

import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Editora;
import models.Livro;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class EditoraDAO {

    @PersistenceContext
    private EntityManager manager;

    private static final String EDT = "EDT";
    private static final String PONTO = ".";
    private static final String LV = "LV";
    //private final Session session =  manager.unwrap(Session.class);

    public List<Livro> buscarListaLivrosPorEditoraId(Integer id) {
        Session session =  manager.unwrap(Session.class);

        List<Livro> livrosEditora = new ArrayList<>();
        Livro livro = new Livro();

        DetachedCriteria criteria = DetachedCriteria.forClass(Livro.class, LV)
                .createAlias(Livro.Fields.EDITORA.toString(), EDT)
                .add(Restrictions.eq(LV.concat(PONTO).concat("editora"), id))
                .setProjection(Projections.projectionList()
                        .add(Projections.property(LV.concat(PONTO).concat("id")))
                        .add(Projections.property(LV.concat(PONTO).concat("titulo")))
                        .add(Projections.property(LV.concat(PONTO).concat("descricao")))
                );

        List<Object[]> listaLivrosPorEditora = criteria.getExecutableCriteria(session).list();

        for(Object[] obj : listaLivrosPorEditora) {
            livro.setId((Integer) obj[0]);
            livro.setTitulo((String) obj[1]);
            livro.setDescricao((String) obj[2]);

            livrosEditora.add(livro);
        }
        return livrosEditora;
    }

    public List<String> buscarEditora(String nomeEditora){

        Session session = manager.unwrap(Session.class);
        List<String> nomesEditora = new ArrayList<>();

        if (nomeEditora == null) {

            DetachedCriteria criteria = DetachedCriteria.forClass(Editora.class, EDT)
                    .setProjection(Projections.projectionList()
                                    .add(Projections.property(EDT.concat(PONTO).concat("nome")))

                    );
            return criteria.getExecutableCriteria(session).list();

        } else {

            DetachedCriteria criteria = DetachedCriteria.forClass(Editora.class, EDT)
                    .add(Restrictions.like(EDT.concat(PONTO).concat("nome"), nomeEditora.concat("%")))
                    .setProjection(Projections.projectionList()
                            .add(Projections.property(EDT.concat(PONTO).concat("nome")))
                    );

            return criteria.getExecutableCriteria(session).list();

        }

        //return nomesEditora;
    }

//    public void buscarEditoraPossuiMaisQueUmLivro() {
//
//        Session session = manager.unwrap(Session.class);
//
//        DetachedCriteria criteria = DetachedCriteria.forClass(Editora.class, "edt")
//                .createAlias("livro", "lv")
//
////        select * from editora edt
////        join livro lv on lv.editora_id = edt.id
//        //where lv.
//
//    }

}
