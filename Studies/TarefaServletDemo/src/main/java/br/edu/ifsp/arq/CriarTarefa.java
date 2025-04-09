package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Define o endpoint do servlet
@WebServlet("/criar-tarefa")
public class CriarTarefa extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Método POST para criar uma nova tarefa
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtém os dados da tarefa enviados no formulário
        String nomeTarefa = req.getParameter("nome"); // Nome da tarefa
        String descricao = req.getParameter("descricao"); // Descrição da tarefa
        String periodos[] = req.getParameterValues("periodo"); // Períodos selecionados no formulário

        // Cria uma lista para armazenar os períodos associados à tarefa
        ArrayList<String> listaPeriodos = new ArrayList<>();
        if (periodos != null) {
            for (String p : periodos) {
                listaPeriodos.add(p); // Adiciona cada período à lista
            }
        }

        // Cria um objeto Tarefa com os dados fornecidos
        Tarefa novaTarefa = new Tarefa(nomeTarefa, descricao, listaPeriodos);

        // Recupera a lista de tarefas armazenada no contexto da aplicação
        ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) getServletContext().getAttribute("lista");

        // Inicializa a lista de tarefas se ela ainda não existir
        if (listaTarefas == null) {
            listaTarefas = new ArrayList<>();
        }

        // Adiciona a nova tarefa à lista de tarefas
        listaTarefas.add(novaTarefa);

        // Atualiza o contexto da aplicação com a lista de tarefas atualizada
        getServletContext().setAttribute("lista", listaTarefas);

        // Envia uma resposta ao cliente para confirmar a criação da tarefa
        PrintWriter out = resp.getWriter();
        out.append("<h1>Tarefa criada com sucesso!</h1>");
        out.append("<h2>Nome da Tarefa: " + nomeTarefa + "</h2>");
        out.append("<h2>Descrição: " + descricao + "</h2>");
        out.append("<h2>Períodos: " + String.join(", ", listaPeriodos) + "</h2>");
    }
}
