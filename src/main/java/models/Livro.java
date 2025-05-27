package models;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String descricao;

    private BigDecimal preco;

    private Integer numeroPaginas;

    @ManyToMany
    private List<Autor> autores = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "editora_id")
    private Editora editora;

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Autor> getAutor() {
        return autores;
    }

    public void setAutor(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}
