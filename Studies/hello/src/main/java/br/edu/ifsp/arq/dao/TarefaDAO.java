package br.edu.ifsp.arq.dao;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import br.edu.ifsp.arq.model.Tarefa;

/**
 * Classe responsável por acessar e manipular os dados das tarefas (DAO - Data Access Object).
 * Utiliza arquivos JSON para persistência local das tarefas.
 */
public class TarefaDAO {

	private static TarefaDAO instance; // Instância singleton
	private String caminhoArquivo;

	// Construtor privado para implementar o padrão Singleton
	private TarefaDAO() {
	}
	
	/**
	 * Configura o caminho do arquivo JSON onde as tarefas serão armazenadas.
	 * Deve ser chamado antes de operações que acessam o arquivo.
	 */
	public void setCaminhoArquivo(String caminho) {
	    this.caminhoArquivo = caminho;
	}

	/**
	 * Retorna a instância única do DAO (padrão Singleton).
	 */
	public static TarefaDAO getInstance() {
		if (instance == null) {
			instance = new TarefaDAO();
		}
		return instance;
	}

	/**
	 * Adiciona uma nova tarefa ao arquivo JSON.
	 * A tarefa é convertida em uma linha JSON e anexada ao final do arquivo.
	 *
	 * @param t Objeto Tarefa a ser adicionado
	 * @return true se a tarefa for salva com sucesso, false em caso de erro
	 */
	public boolean adicionarTarefa(Tarefa t) {
		Gson gson = new Gson();

		try {
			// Abre o arquivo para escrita no modo append (adicionar no final)
			FileWriter fw = new FileWriter(caminhoArquivo, StandardCharsets.UTF_8, true);
			PrintWriter pw = new PrintWriter(fw);

			// Converte o objeto Tarefa para JSON e escreve no arquivo
			String json = gson.toJson(t);
			pw.println(json);

			// Fecha os recursos
			pw.close();
			fw.close();

		} catch (IOException e) {
			// Em caso de erro, imprime a stack trace e retorna false
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Lê todas as tarefas armazenadas no arquivo JSON e as retorna como uma lista.
	 * Cada linha do arquivo representa uma tarefa em formato JSON.
	 *
	 * @return Lista de tarefas lidas ou null em caso de erro
	 */
	public ArrayList<Tarefa> getTarefas() {
		File f = new File(caminhoArquivo);
		FileReader fr;
		Gson gson = new Gson();
		ArrayList<Tarefa> lista = null;

		try {
			fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			lista = new ArrayList<Tarefa>();

			// Lê linha por linha e converte cada JSON em objeto Tarefa
			while (sc.hasNextLine()) {
				String linha = sc.nextLine();
				Tarefa t = gson.fromJson(linha, Tarefa.class);
				lista.add(t);
			}

			// Fecha os recursos
			sc.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// Arquivo ainda não existe (possivelmente a primeira execução)
			e.printStackTrace();
			return null;

		} catch (IOException e) {
			// Erro durante leitura
			e.printStackTrace();
			return null;
		}

		return lista;
	}
	
	/**
	 * Salva a lista completa de tarefas no arquivo, sobrescrevendo seu conteúdo.
	 * @param tarefas Lista de tarefas a salvar
	 */
	private void salvarLista(List<Tarefa> tarefas) {
	    try (PrintWriter pw = new PrintWriter(caminhoArquivo, StandardCharsets.UTF_8)) {
	        Gson gson = new Gson();
	        for (Tarefa t : tarefas) {
	            pw.println(gson.toJson(t));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Remove uma tarefa pelo seu ID.
	 * @param id ID da tarefa a remover
	 * @return true se a tarefa foi removida com sucesso, false caso contrário
	 */
	public boolean excluirTarefa(int id) {
	    ArrayList<Tarefa> tarefas = getTarefas();
	    if (tarefas == null) return false;
	    boolean removido = tarefas.removeIf(t -> t.getId() == id);
	    if (removido) {
	        salvarLista(tarefas);
	    }
	    return removido;
	}

	/**
	 * Atualiza uma tarefa existente.
	 * @param t Tarefa atualizada
	 * @return true se a tarefa foi atualizada, false se não foi encontrada
	 */
	public boolean atualizarTarefa(Tarefa t) {
	    ArrayList<Tarefa> tarefas = getTarefas();
	    if (tarefas == null) return false;
	    for (int i = 0; i < tarefas.size(); i++) {
	        if (tarefas.get(i).getId() == t.getId()) {
	            tarefas.set(i, t);
	            salvarLista(tarefas);
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 * Busca uma tarefa pelo seu ID.
	 * @param id ID da tarefa
	 * @return Tarefa encontrada ou null se não encontrada
	 */
	public Tarefa buscarPorId(int id) {
	    ArrayList<Tarefa> tarefas = getTarefas();
	    if (tarefas == null) return null;
	    for (Tarefa t : tarefas) {
	        if (t.getId() == id) return t;
	    }
	    return null;
	}

}