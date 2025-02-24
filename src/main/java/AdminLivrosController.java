import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import models.Livro;

@Named
@RequestScoped
public class AdminLivrosController {
    private Livro livro = new Livro();

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void salvar() {
        System.out.println("Salvando livro");
    }
}
