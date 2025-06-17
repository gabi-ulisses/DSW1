package br.edu.ifsp.arq.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String descricao;

    public Tarefa(int id, String nome, String descricao) {
       this.id = id;
       setNome(nome);       
       setDescricao(descricao); 
    }

    public Tarefa(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }

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
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da tarefa não pode ser nulo ou em branco.");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ser nula ou em branco.");
        }
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + descricao;
    }
}