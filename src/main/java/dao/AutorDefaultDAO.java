package dao;

import jakarta.ejb.Stateless;
import models.Autor;

@Stateless
public class AutorDefaultDAO extends DefaultDao<Autor> {
    public AutorDefaultDAO() {
        super(Autor.class);
    }
}
