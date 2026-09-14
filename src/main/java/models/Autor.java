package models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="idade")
    private Integer idade;

    @ManyToMany(mappedBy = "autores")
    private List<Editora> editoras = new ArrayList<>();

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();

    public enum Fields {
        EDITORA("editoras");

        public String fields;

        private Fields(String fields){
            this.fields = fields;
        }
    }

    public Autor() {

    }

    public Autor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Editora> getEditoras() {
     return editoras;
    }

    public void setEditoras(List<Editora> editoras){
        this.editoras = editoras;
    }
}
