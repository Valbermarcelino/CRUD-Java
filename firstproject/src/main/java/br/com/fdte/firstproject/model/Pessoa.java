package br.com.fdte.firstproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "nome")
    private String nome;

    @Basic
    @Column(name = "email")
    private String email;


    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Telefone> telefones;



    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public List<Telefone> getTelefones() {
        return telefones;
    }
    public void setTelefones(List<Telefone> telefones) {
    this.telefones = telefones;
    }
}
