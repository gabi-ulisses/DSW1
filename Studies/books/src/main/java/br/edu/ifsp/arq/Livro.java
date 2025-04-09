package br.edu.ifsp.arq;

import java.util.ArrayList;

public class Livro {
	private int id;
	String titulo;
	String autor;
	ArrayList<String> generos;
	int anoPublicacao;
	
	
	public Livro(String titulo, String autor, ArrayList<String> generos, int anoPublicacao) {
		this.titulo = titulo;
		this.autor = autor;
		this.generos = generos;
		this.anoPublicacao = anoPublicacao;
	}


	public int getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public ArrayList<String> getGeneros() {
		return generos;
	}


	public int getAnoPublicacao() {
		return anoPublicacao;
	}


	@Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Gêneros: " + String.join(", ", generos) + ", Ano: " + anoPublicacao;
    }
	
	
}
