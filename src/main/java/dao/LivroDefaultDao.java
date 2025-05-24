package dao;

import jakarta.ejb.Stateless;
import models.Livro;

@Stateless
public class LivroDefaultDao extends DefaultDao<Livro>{

    public LivroDefaultDao() {
        super(Livro.class);
    }

}
