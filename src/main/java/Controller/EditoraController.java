package Controller;

import dao.EditoraDAO;
import dao.EditoraDefaultDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import models.Autor;
import models.Editora;
import models.Livro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class EditoraController {

    @Inject
    private EditoraDAO editoraDAO;

    @Inject
    private EditoraDefaultDAO editoraDefaultDAO;

    private String nomeEditora;
    private Editora editora = new Editora();
    private Integer editoraId;
    private List<Livro> buscarLivrosPorEditoraId = new ArrayList<>();
    private List<Integer> listaAutoresId = new ArrayList<>();
    private List<String> buscarEditora = new ArrayList<>();

    public List<Livro> getBuscarLivrosPorEditoraId() {
        List<Livro> livorsPorEditora = editoraDAO.buscarListaLivrosPorEditoraId(this.editoraId);
        buscarLivrosPorEditoraId.addAll(livorsPorEditora);
        return buscarLivrosPorEditoraId;
    }

    @Transactional
    public void salvar(){
        for(Integer autorId : listaAutoresId) {
            editora.getAutores().add(new Autor(autorId));
        }
        Date date = new Date();
        editora.setCriadoEm(date);
        editoraDefaultDAO.salvar(editora);

    }

    public List<String> getBuscarEditora() {
        List<String> editoras = editoraDAO.buscarEditora(nomeEditora);
        return editoras;
    }



    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Integer getEditoraId(){
        return editoraId;
    }

    public void setEditoraId(Integer editoraId){
        this.editoraId = editoraId;
    }

    public List<Integer> getListaAutoresId() {
        return listaAutoresId;
    }

    public void setListaAutoresId(List<Integer> listaAutoresId) {
        this.listaAutoresId = listaAutoresId;
    }

    public String getNomeEditora(){
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
}
