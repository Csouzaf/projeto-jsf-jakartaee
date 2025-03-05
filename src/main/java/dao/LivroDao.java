package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.Livro;

public class LivroDao {

    @PersistenceContext
    private EntityManager manager;


    public void salvar(Livro livro) {

        manager.persist(livro);
    }

}
