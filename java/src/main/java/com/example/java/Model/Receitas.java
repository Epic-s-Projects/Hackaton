package com.example.java.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Receitas implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReceita;
    @ManyToOne
    @JoinColumn(name = "nomeUsuario", referencedColumnName = "nome")
    private Usuario nome;
    private String nomeReceita;
    private String ingredientes;
    private String descricao;
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public long getIdReceita() {
        return idReceita;
    }
    public void setIdReceita(long idReceita) {
        this.idReceita = idReceita;
    }
    public Usuario getNome() {
        return nome;
    }
    public void setNome(Usuario nome) {
        this.nome = nome;
    }
    public String getNomeReceita() {
        return nomeReceita;
    }
    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
