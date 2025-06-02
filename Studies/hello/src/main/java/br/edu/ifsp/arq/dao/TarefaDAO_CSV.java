package br.edu.ifsp.arq.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.arq.model.Tarefa;

public class TarefaDAO_CSV {

	private static TarefaDAO_CSV instance;


	private TarefaDAO_CSV() {
	
	}

	public static TarefaDAO_CSV getInstance() {

		if (instance == null) {
			instance = new TarefaDAO_CSV();
		}

		return instance;
	}

	public boolean adicionarTarefa(Tarefa t) {

		try {
			FileWriter fw = new FileWriter("/home/aluno/Downloads/saida.csv", StandardCharsets.UTF_8, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(t);
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public ArrayList<Tarefa> getTarefas() {
		File f = new File("/home/aluno/Downloads/saida.csv");
		FileReader fr;
		ArrayList<Tarefa> lista = null;
		try {
			fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			lista = new ArrayList<Tarefa>();
			while (sc.hasNextLine()) {
				String linha = sc.nextLine();
				String campos[] = linha.split(";");
				Tarefa t = new Tarefa(Integer.parseInt(campos[0]), campos[1], campos[2]);
				lista.add(t);
			}

			sc.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return lista;
	}

}
