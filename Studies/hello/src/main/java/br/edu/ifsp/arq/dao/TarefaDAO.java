package br.edu.ifsp.arq.dao;

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

public class TarefaDAO {

    private static TarefaDAO instance;

    // Caminho relativo para o arquivo
    private static final String ARQUIVO = "data/saida.json";

    private TarefaDAO() {
        // Cria o diretório "data" se não existir
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Cria o arquivo "saida.json" se não existir
        File f = new File(ARQUIVO);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static TarefaDAO getInstance() {
        if (instance == null) {
            instance = new TarefaDAO();
        }
        return instance;
    }

    public boolean adicionarTarefa(Tarefa t) {
        Gson gson = new Gson();
        try (FileWriter fw = new FileWriter(ARQUIVO, StandardCharsets.UTF_8, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String json = gson.toJson(t);
            pw.println(json);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Tarefa> getTarefas() {
        File f = new File(ARQUIVO);
        ArrayList<Tarefa> lista = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader fr = new FileReader(f);
             Scanner sc = new Scanner(fr)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                Tarefa t = gson.fromJson(linha, Tarefa.class);
                lista.add(t);
            }
        } catch (FileNotFoundException e) {
            // arquivo pode não existir ainda, retorna lista vazia
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Salvar toda a lista no arquivo sobrescrevendo o conteúdo existente
    private boolean salvarLista(ArrayList<Tarefa> lista) {
        Gson gson = new Gson();
        try (FileWriter fw = new FileWriter(ARQUIVO, StandardCharsets.UTF_8, false);
             PrintWriter pw = new PrintWriter(fw)) {
            for (Tarefa t : lista) {
                String json = gson.toJson(t);
                pw.println(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Editar tarefa com base no id
    public boolean editarTarefa(Tarefa tEditada) {
        ArrayList<Tarefa> lista = getTarefas();
        if (lista == null) {
            return false;
        }
        boolean encontrou = false;
        for (int i = 0; i < lista.size(); i++) {
            Tarefa t = lista.get(i);
            if (t.getId() == tEditada.getId()) {
                lista.set(i, tEditada);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            return false;
        }
        return salvarLista(lista);
    }

    // Excluir tarefa pelo id
    public boolean excluirTarefa(int id) {
        ArrayList<Tarefa> lista = getTarefas();
        if (lista == null) {
            return false;
        }
        boolean removido = lista.removeIf(t -> t.getId() == id);
        if (!removido) {
            return false;
        }
        return salvarLista(lista);
    }
}
