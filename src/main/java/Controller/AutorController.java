package Controller;

import dao.AutorDAO;
import dao.AutorDefaultDAO;
import dao.LivroDefaultDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import models.Autor;

import java.util.List;

@Named
@RequestScoped
public class AutorController {

    @Inject
    private AutorDAO autorDAO;

    @Inject
    private AutorDefaultDAO autorDefaultDao;

    private Autor autor = new Autor();

    public List<Autor> getAutores() {
        return autorDefaultDao.buscarTodos();
    }

    @Transactional
    public void salvar() {
        autorDefaultDao.salvar(autor);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
