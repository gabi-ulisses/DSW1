package br.edu.ifsp.arq;

import java.io.Serializable;

public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static int contador = 0;
	
	private int id;
	private String nome;
	private String descricao;
	
	public Tarefa() {
		this.id = contador++;
	}
	
	public Tarefa(String nome, String descricao) {
		this(); // Chama o construtor vazio
		this.nome = nome;
		this.descricao = descricao;
	}


	public int getId() {
		return id;
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
	
	
	
	

	
	
}
