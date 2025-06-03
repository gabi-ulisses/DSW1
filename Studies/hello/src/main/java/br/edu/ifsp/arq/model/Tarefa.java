package br.edu.ifsp.arq.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String descricao;

    public Tarefa(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Tarefa(String nome, String descricao) {
        this(0, nome, descricao); // id será atribuído pelo DAO
    }

    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // toString para CSV (id;nome;descricao)
    @Override
    public String toString() {
        return id + ";" + nome + ";" + descricao;
    }
}
