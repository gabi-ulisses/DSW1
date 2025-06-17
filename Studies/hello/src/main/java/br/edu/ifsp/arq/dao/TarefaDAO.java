package br.edu.ifsp.arq.dao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import br.edu.ifsp.arq.model.Tarefa;

public class TarefaDAO {

    private static TarefaDAO instance;
    private String caminho; 

    private TarefaDAO(String caminho) {
        this.caminho = caminho;
        
        File f = new File(caminho);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs(); 
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método de inicialização: será chamado UMA VEZ pelo Servlet
    public static void init(String caminho) {
        if (instance == null) {
            instance = new TarefaDAO(caminho);
        }
    }

    public static TarefaDAO getInstance() {
        if (instance == null) {
            throw new IllegalStateException("TarefaDAO não foi inicializado. Chame o método init() primeiro.");
        }
        return instance;
    }


    private int gerarIdUnico() {
        List<Tarefa> lista = getTarefas();
        int maiorId = 0;
        for (Tarefa t : lista) {
            if (t.getId() > maiorId) {
                maiorId = t.getId();
            }
        }
        return maiorId + 1;
    }

public boolean adicionarTarefa(Tarefa t) {
    FileWriter fw = null;
    PrintWriter pw = null;
    Gson gson = new Gson();
    
    try {
        // O 'true' no final significa que vamos adicionar ao fim do arquivo (append)
        fw = new FileWriter(caminho, StandardCharsets.UTF_8, true);
        pw = new PrintWriter(fw);
        
        t.setId(gerarIdUnico());
        String json = gson.toJson(t);

        System.out.println("--- INICIANDO DEBUG DA ESCRITA ---");
        System.out.println("DEBUG: Tentando escrever no arquivo: " + caminho);
        System.out.println("DEBUG: Conteúdo a ser escrito: " + json);

        pw.println(json);
        
        // Força a "descarga" dos dados para o arquivo físico
        pw.flush(); 

        // Verificação explícita de erro silencioso
        if (pw.checkError()) {
            System.err.println("ERRO GRAVE: PrintWriter encontrou um erro silencioso ao escrever no arquivo. Verifique as permissões da pasta e do arquivo!");
            return false;
        }

        System.out.println("DEBUG: A escrita no arquivo foi concluída sem erros aparentes.");
        return true;

    } catch (IOException e) {
        System.err.println("ERRO GRAVE: Ocorreu uma IOException. O arquivo ou diretório pode não ser acessível.");
        e.printStackTrace(); // Imprime o erro completo no console
        return false;
    } finally {
        // O bloco 'finally' garante que os recursos sempre serão fechados
        System.out.println("DEBUG: Fechando o arquivo.");
        if (pw != null) {
            pw.close();
        }
        // O PrintWriter já fecha o FileWriter, então não precisamos fechar fw explicitamente aqui.
    }
}

    public List<Tarefa> getTarefas() {
        File arquivo = new File(caminho);
        Scanner sc = null;
        List<Tarefa> ls = new ArrayList<>();
        Gson gson = new Gson();
        try {
            if (!arquivo.exists()) {
                return ls;
            }
            sc = new Scanner(arquivo, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if(linha.trim().isEmpty()) continue; // Ignora linhas em branco
                Tarefa t = gson.fromJson(linha, Tarefa.class);
                if (t != null) {
                    ls.add(t);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ls;
    }

    public boolean editarTarefa(Tarefa tarefaEditada) {
        try {
            List<Tarefa> lista = getTarefas();
            boolean encontrado = false;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == tarefaEditada.getId()) {
                    lista.set(i, tarefaEditada);
                    encontrado = true;
                    break;
                }
            }
            return encontrado && salvarTarefasNoArquivo(lista);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluirTarefa(int id) {
        try {
            List<Tarefa> lista = getTarefas();
            boolean removido = lista.removeIf(t -> t.getId() == id);
            return removido && salvarTarefasNoArquivo(lista);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean salvarTarefasNoArquivo(List<Tarefa> lista) throws IOException {
        try (FileWriter fw = new FileWriter(caminho, StandardCharsets.UTF_8, false);
             PrintWriter pw = new PrintWriter(fw)) {
            Gson gson = new Gson();
            for (Tarefa t : lista) {
                String json = gson.toJson(t);
                pw.println(json);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Tarefa getTarefaPorId(int id) {
        return getTarefas().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }
}