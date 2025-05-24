package Controller;

import dao.AutorDAO;
import dao.AutorDefaultDAO;
import dao.LivroDefaultDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import models.Autor;
import models.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class AdminLivrosController {

    @Inject
    private LivroDefaultDao livroDefaultDao;

    @Inject
    private AutorDefaultDAO autorDefaultDAO;

    @Inject
    private AutorDAO autorDAO;

    private String livroSelecionado;
    private List<String> listarLivros = new ArrayList<>();
    private List<Autor> listarLivrosAutores = new ArrayList<>();
    private Livro livro = new Livro();
    private String[] listaAutores;
    private Integer[] listaAutoresId;
    private List<Integer> buscarAutoresId = new ArrayList<>();

    public List<String> getlistarLivros(){

        List<Livro> livros = livroDefaultDao.buscarTodos();

        for (Livro livro : livros) {
            listarLivros.add(livro.getTitulo());
        }
         return listarLivros;
    }

    public List<Autor> getListarLivrosAutores() {
        List<Autor> autores = autorDefaultDAO.buscarTodos();

        if (autores == null) {
            return null;
        }
        listarLivrosAutores.addAll(autores);

        return listarLivrosAutores;
    }

    public List<Integer> buscarIdAutores() {
        buscarAutoresId = autorDAO.buscarAutoresId();

        if (buscarAutoresId == null) {
            return null;
        }

        return buscarAutoresId;
    }


    public List<String> buscarNomeLivroPorId(Integer id) {


        return null;
    }


    @Transactional
    public void salvar() {

        for(Integer autorId : listaAutoresId) {
            livro.getAutor().add(new Autor(autorId));
        }
        livroDefaultDao.salvar(livro);
    }

    public boolean excluir(Livro livro) {
        if (livro.getId() != null && livro.getId() > 0) {
            livroDefaultDao.excluir(livro);
            return true;
        }
        return false;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getLivroSelecionado() {
        return livroSelecionado;
    }

    public void setLivroSelecionado(String livroSelecionado) {
        this.livroSelecionado = livroSelecionado;
    }

    public String[] getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(String[] listaAutores) {
        this.listaAutores = listaAutores;
    }

    public Integer[] getListaAutoresId() {
        return listaAutoresId;
    }

    public void setListaAutoresId(Integer[] listaAutoresId) {
        this.listaAutoresId = listaAutoresId;
    }


//    public List<String> getListarLivros() {
//        return listarLivros;
//    }
//
//    public void setListarLivros(List<String> listarLivros) {
//        this.listarLivros = listarLivros;
//    }

}
