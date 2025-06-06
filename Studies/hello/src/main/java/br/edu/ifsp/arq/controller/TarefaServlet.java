package br.edu.ifsp.arq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.dao.TarefaDAO;
import br.edu.ifsp.arq.model.Tarefa;

@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TarefaDAO dao;

    public TarefaServlet() {
        super();
        dao = TarefaDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if ("carregar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Tarefa tarefa = dao.buscarPorId(id);

            if (tarefa != null) {
                request.setAttribute("tarefa", tarefa);
                request.getRequestDispatcher("/form-editar.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Tarefa não encontrada");
                request.setAttribute("classe", "alert alert-danger");
                request.getRequestDispatcher("/resposta.jsp").forward(request, response);
            }

        } else {
            // Comportamento padrão: listar tarefas
            request.setAttribute("lista", dao.getTarefas());
            request.getRequestDispatcher("/resposta.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("POST recebido! Ação: " + request.getParameter("acao"));

        String acao = request.getParameter("acao");
        String msg = "";

        if ("adicionar".equals(acao)) {
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            if (nome == null || nome.isEmpty() || descricao == null || descricao.isEmpty()) {
                msg = "Nome e descrição não podem ser vazios";
                request.setAttribute("mensagem", msg);
                request.setAttribute("classe", "alert alert-danger");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                Tarefa t = new Tarefa(nome, descricao);
                if (dao.adicionarTarefa(t)) {
                    msg = "Tarefa adicionada com sucesso";
                    request.setAttribute("mensagem", msg);
                    request.setAttribute("classe", "alert alert-success");
                }
                request.setAttribute("lista", dao.getTarefas());
                request.getRequestDispatcher("/resposta.jsp").forward(request, response);
            }
        } else if ("editar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            if (nome == null || nome.isEmpty() || descricao == null || descricao.isEmpty()) {
                msg = "Nome e descrição não podem ser vazios";
                request.setAttribute("mensagem", msg);
                request.setAttribute("classe", "alert alert-danger");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                Tarefa t = new Tarefa(id, nome, descricao);
                if (dao.editarTarefa(t)) {
                    msg = "Tarefa editada com sucesso";
                    request.setAttribute("mensagem", msg);
                    request.setAttribute("classe", "alert alert-success");
                } else {
                    msg = "Erro ao editar a tarefa";
                    request.setAttribute("mensagem", msg);
                    request.setAttribute("classe", "alert alert-danger");
                }
                request.setAttribute("lista", dao.getTarefas());
                request.getRequestDispatcher("/resposta.jsp").forward(request, response);
            }
        } else if ("excluir".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (dao.excluirTarefa(id)) {
                msg = "Tarefa excluída com sucesso";
                request.setAttribute("mensagem", msg);
                request.setAttribute("classe", "alert alert-success");
            } else {
                msg = "Erro ao excluir a tarefa";
                request.setAttribute("mensagem", msg);
                request.setAttribute("classe", "alert alert-danger");
            }
            request.setAttribute("lista", dao.getTarefas());
            request.getRequestDispatcher("/resposta.jsp").forward(request, response);
        }
    }
}