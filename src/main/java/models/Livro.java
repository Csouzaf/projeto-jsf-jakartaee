package models;

import jakarta.persistence.*;


import java.math.BigDecimal;

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
