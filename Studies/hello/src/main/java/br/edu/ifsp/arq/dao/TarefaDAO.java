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
    private static final String ARQUIVO = "/Users/serviceup/Documents/DSW1/Studies/hello/data/saida.json";

    private TarefaDAO() {
        // Extrai o diretório pai do caminho do arquivo
        File f = new File(ARQUIVO);
        File dir = f.getParentFile();  // pega a pasta "data"

        // Cria o diretório "data" se não existir
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Cria o arquivo "saida.json" se não existir
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Caminho real do arquivo: " + f.getAbsolutePath());
    }

    public static TarefaDAO getInstance() {
        if (instance == null) {
            instance = new TarefaDAO();
        }
        return instance;
    }

    // Adicionar tarefa com ID automático incremental
    public boolean adicionarTarefa(Tarefa t) {
        ArrayList<Tarefa> lista = getTarefas();
        if (lista == null) {
            lista = new ArrayList<>();
        }
        // Determinar maior id atual
        int maxId = 0;
        for (Tarefa tarefa : lista) {
            if (tarefa.getId() > maxId) {
                maxId = tarefa.getId();
            }
        }
        t.setId(maxId + 1);
        lista.add(t);
        return salvarLista(lista); // sobrescreve o arquivo inteiro
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
    
    public Tarefa buscarPorId(int id) {
        ArrayList<Tarefa> lista = getTarefas();
        if (lista != null) {
            for (Tarefa t : lista) {
                if (t.getId() == id) {
                    return t;
                }
            }
        }
        return null;
    }

}