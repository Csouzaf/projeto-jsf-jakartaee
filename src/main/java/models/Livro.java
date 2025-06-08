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

    public enum Fields {

        TITULO("titulo"),
        DESCRICAO("descricao"),
        PRECO("preco"),
        NUMERO_PAGINAS("numero_paginas"),
        AUTORES("autor"),
        EDITORA("editora");



        private String fields;

        private Fields(String fields){
            this.fields = fields;
        }

        @Override
        public String toString() {
            return fields;
        }
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


}


