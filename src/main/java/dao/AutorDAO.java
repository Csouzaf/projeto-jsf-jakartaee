package dao;

import jakarta.ejb.Stateless;
import models.Autor;

@Stateless
public class AutorDAO extends DefaultDao<Autor> {
    public AutorDAO() {
        super(Autor.class);
    }
}
