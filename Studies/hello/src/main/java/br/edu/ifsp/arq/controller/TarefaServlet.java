package br.edu.ifsp.arq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.arq.dao.TarefaDAO_CSV;
import br.edu.ifsp.arq.model.Tarefa;

@WebServlet("/tarefa")
public class CreateTarefaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TarefaDAO_CSV dao;

    @Override
    public void init() throws ServletException {
        dao = TarefaDAO_CSV.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String msg = "";
        String classe = "";

        if (nome == null || nome.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
            msg = "Nome e descrição não podem ser vazios";
            classe = "alert alert-danger";
        } else {
            Tarefa t = new Tarefa(nome, descricao);
            if (dao.adicionarTarefa(t)) {
                msg = "Tarefa adicionada com sucesso";
                classe = "alert alert-success";
            } else {
                msg = "Erro ao adicionar tarefa";
                classe = "alert alert-danger";
            }
        }

        request.setAttribute("mensagem", msg);
        request.setAttribute("classe", classe);
        request.setAttribute("lista", dao.getTarefas());

        getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
    }
}
