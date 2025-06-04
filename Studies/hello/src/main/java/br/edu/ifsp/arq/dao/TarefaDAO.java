package br.edu.ifsp.arq.dao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import br.edu.ifsp.arq.model.Tarefa;

public class TarefaDAO_CSV {

    private static final String CAMINHO_ARQUIVO = "data/tarefas.csv";
    private static TarefaDAO_CSV instance;

    private TarefaDAO_CSV() {
        File pasta = new File("data");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    public static synchronized TarefaDAO_CSV getInstance() {
        if (instance == null) {
            instance = new TarefaDAO_CSV();
        }
        return instance;
    }

    // Gera novo ID único baseado no maior ID atual + 1
    private int gerarNovoId() {
        int maxId = 0;
        List<Tarefa> tarefas = getTarefas();

        if (tarefas != null) {
            for (Tarefa t : tarefas) {
                if (t.getId() > maxId) maxId = t.getId();
            }
        }
        return maxId + 1;
    }

    public synchronized boolean adicionarTarefa(Tarefa t) {
        t.setId(gerarNovoId());

        try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, StandardCharsets.UTF_8, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(t);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public synchronized List<Tarefa> getTarefas() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        List<Tarefa> lista = new ArrayList<>();

        if (!arquivo.exists()) return lista;

        try (FileReader fr = new FileReader(arquivo);
             Scanner sc = new Scanner(fr)) {

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] campos = linha.split(";");
                if (campos.length >= 3) {
                    int id = Integer.parseInt(campos[0]);
                    String nome = campos[1];
                    String descricao = campos[2];
                    lista.add(new Tarefa(id, nome, descricao));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

	public boolean editarTarefa(Tarefa t) {
    List<Tarefa> tarefas = getTarefas();
    boolean encontrado = false;

    for (int i = 0; i < tarefas.size(); i++) {
        if (tarefas.get(i).getId() == t.getId()) {
            tarefas.set(i, t);  // substitui a tarefa antiga pela atualizada
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        return false;  // não encontrou tarefa com esse ID
    }

    // salva toda a lista atualizada no CSV
    return salvarListaNoCSV(tarefas);
}


    public synchronized boolean excluirTarefa(int id) {
        List<Tarefa> tarefas = getTarefas();
        boolean removido = tarefas.removeIf(t -> t.getId() == id);
        if (!removido) return false;
        return salvarListaNoCSV(tarefas);
    }

    private boolean salvarListaNoCSV(List<Tarefa> tarefas) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CAMINHO_ARQUIVO, StandardCharsets.UTF_8, false))) {
            for (Tarefa t : tarefas) {
                pw.println(t);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

	public Tarefa buscarPorId(int id) {
    List<Tarefa> tarefas = getTarefas();
    if (tarefas == null) {
        return null;
    }

    for (Tarefa t : tarefas) {
        if (t.getId() == id) {
            return t;
        }
    }
    return null; // não encontrou
}

}
