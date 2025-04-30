package br.edu.ifsp.arq.model;

import java.io.Serializable;

public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private String nome;
	private static int proximo_id = 0;
	private int id;
	
	public Tarefa() {
		this.id = ++proximo_id;
	}
	
	public Tarefa(String n, String d) {
		this();
		this.descricao = d;
		this.nome = n;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
