package Controller;

import dao.AutorDAO;
import dao.AutorDefaultDAO;
import dao.LivroDefaultDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import models.Autor;
import org.hibernate.Session;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
//@RequestScoped
@ViewScoped
public class AutorController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AutorDAO autorDAO;

    @Inject
    private AutorDefaultDAO autorDefaultDao;

    @Inject
    private EditoraController editoraController;

    private Autor autor = new Autor();
    private Autor buscarAutoresPorEditoraId;
    private Integer editoraId;
    private String nomeAutorSelecionado;
    List<String> nomesAutores = new ArrayList<>();

    public List<Autor> getAutores() {
        return autorDefaultDao.buscarTodos();
    }

    @Transactional
    public void salvar() {
        autorDefaultDao.salvar(autor);
    }

    public void buscarAutoresPorNomeEditora(){
        String nomeEditora = editoraController.getNomeEditora();
        if (nomeEditora != null) {
            nomesAutores = autorDAO.listaNomesAutoresPorNomeEditora(nomeEditora);
        } else {
            nomesAutores = new ArrayList<>();
        }

    }



    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getNomeAutorSelecionado(){
        return nomeAutorSelecionado;
    }

    public void setNomeAutorSelecionado(String nomeAutorSelecionado){
        this.nomeAutorSelecionado = nomeAutorSelecionado;
    }

    public List<String> getNomesAutores(){
        return nomesAutores;
    }

    public void setNomesAutores(List<String> nomesAutores){
        this.nomesAutores = nomesAutores;
    }
}
