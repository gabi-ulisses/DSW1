package br.edu.ifsp.arq.dao;

import java.util.ArrayList;

import br.edu.ifsp.arq.model.Tarefa;

public class TarefaDAO2 {

	private static ArrayList<Tarefa> listaDeTarefa = new ArrayList<Tarefa>();
	
	public TarefaDAO2() {}
	
	public boolean adicionarTarefa(Tarefa t) {
		return this.listaDeTarefa.add(t);
	}
	
	public ArrayList<Tarefa> getTarefas(){
		return this.listaDeTarefa;
	}
}
