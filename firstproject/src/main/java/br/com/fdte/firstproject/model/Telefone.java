package br.com.fdte.firstproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "numero")
    private String numero;

    @Basic
    @Column(name = "DDD")
    private String DDD;


    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @JsonBackReference
    private Pessoa pessoa;

    /*
    @JoinColumn(name = "id")
    private Spring id_pessoa;


    @Column(name = "id_pessoa")
    private String id_pessoa;

    @ManyToOne
    @OneToMany
    @JoinColumn(name = "id_pessoa")
    @JoinTable(name="telefone",
            joinColumns={@JoinColumn(name="id_pessoa",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="id",
                    referencedColumnName="id_pessoa")})
    private String id_pessoa;
     */


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public Telefone() {
    }


    public Pessoa getPessoa() {
    return pessoa;
  }
  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }


}
