package Controller;

import dao.LivroDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import models.Autor;
import models.Livro;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosController {

    @Inject
    private LivroDao livroDao;

    private String livroSelecionado;
    private List<String> listarLivros = new ArrayList<>();
    private Livro livro = new Livro();

    public List<String> getlistarLivros(){

        List<Livro> livros = livroDao.buscarTodos();

        for (Livro livro : livros) {
            listarLivros.add(livro.getTitulo());
        }

         return listarLivros;
    }

    @Transactional
    public void salvar() {
        livroDao.salvar(livro);
    }

    public boolean excluir(Livro livro) {
        if (livro.getId() != null && livro.getId() > 0) {
            livroDao.excluir(livro);
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

//    public List<String> getListarLivros() {
//        return listarLivros;
//    }
//
//    public void setListarLivros(List<String> listarLivros) {
//        this.listarLivros = listarLivros;
//    }

}
