package dao;

import jakarta.ejb.Stateless;
import models.Editora;

@Stateless
public class EditoraDefaultDAO extends DefaultDao<Editora>{

    public EditoraDefaultDAO() {
        super(Editora.class);
    }
}
