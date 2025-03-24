import dao.DefaultDao;
import dao.LivroDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import models.Autor;
import models.Livro;

import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosController {

    @Inject
    private LivroDao livroDao;

    private Livro livro = new Livro();

    @Transactional
    public void salvar() {
        livroDao.salvar(livro);
    }


    public List<Autor> getAutores() {
        return Arrays.asList()
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
}
