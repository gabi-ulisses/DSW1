package br.edu.ifsp.arq.dao;

import java.util.ArrayList;

import br.edu.ifsp.arq.model.Tarefa;

public class TarefaDAO {

	private static TarefaDAO instance;
	private ArrayList<Tarefa> listaDeTarefas;
	
	private TarefaDAO() {
		this.listaDeTarefas = new ArrayList<Tarefa>();
	}
	
	public static TarefaDAO getInstance(){
		if(instance == null) {
			instance = new TarefaDAO();
		}
		
		return instance;
	}
	
	public boolean adicionarTarefa(Tarefa t) {
		return this.listaDeTarefas.add(t);
	}
	
	public ArrayList<Tarefa> getTarefas(){
		return this.listaDeTarefas;
	}
}
