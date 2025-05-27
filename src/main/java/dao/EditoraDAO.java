package dao;

import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Editora;
import models.Livro;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.List;

@Stateless
public class EditoraDAO {

    @PersistenceContext
    private EntityManager manager;


    public void buscarListaLivrosPorEditoraId() {

        Session session = manager.unwrap(Session.class);

        DetachedCriteria criteria = DetachedCriteria.forClass(Livro.class, "LV")
                .createAlias("editora", "EDT")
                .setProjection(Projections.projectionList()
                        .add(Projections.property("LV.titulo"))
                        .add(Projections.property("LV.descricao"))
                );

        List<Object[]> listaLivrosPorEditora = criteria.getExecutableCriteria(session).list();

        for(Object[] obj : listaLivrosPorEditora) {
            String nome = (String) obj[0];
            String email = (String) obj[1];
        }

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
