package br.edu.ifsp.arq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.arq.dao.TarefaDAO_CSV;
import br.edu.ifsp.arq.model.Tarefa;

@WebServlet("/editar")
public class EditarTarefaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TarefaDAO_CSV dao;

    @Override
    public void init() throws ServletException {
        dao = TarefaDAO_CSV.getInstance();
    }

    // Mostra o formulário de edição com os dados atuais da tarefa
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            request.setAttribute("mensagem", "ID inválido para edição.");
            request.setAttribute("classe", "alert alert-danger");
            request.setAttribute("lista", dao.getTarefas());
            getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Tarefa tarefa = dao.buscarPorId(id);
            if (tarefa == null) {
                request.setAttribute("mensagem", "Tarefa não encontrada.");
                request.setAttribute("classe", "alert alert-warning");
                request.setAttribute("lista", dao.getTarefas());
                getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
                return;
            }
            request.setAttribute("tarefa", tarefa);
            getServletContext().getRequestDispatcher("/form-editar.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "ID inválido para edição.");
            request.setAttribute("classe", "alert alert-danger");
            request.setAttribute("lista", dao.getTarefas());
            getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
        }
    }

    // Recebe os dados do formulário de edição e atualiza a tarefa
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String msg = "";
        String classe = "";

        if (idParam == null || idParam.trim().isEmpty()) {
            msg = "ID inválido para edição.";
            classe = "alert alert-danger";
        } else if (nome == null || nome.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
            msg = "Nome e descrição não podem ser vazios.";
            classe = "alert alert-danger";
        } else {
            try {
                int id = Integer.parseInt(idParam);
                Tarefa tarefaAtualizada = new Tarefa(id, nome, descricao);
                boolean atualizado = dao.editarTarefa(tarefaAtualizada);

                if (atualizado) {
                    msg = "Tarefa atualizada com sucesso.";
                    classe = "alert alert-success";
                } else {
                    msg = "Tarefa não encontrada para atualização.";
                    classe = "alert alert-warning";
                }
            } catch (NumberFormatException e) {
                msg = "ID inválido para edição.";
                classe = "alert alert-danger";
            }
        }

        request.setAttribute("mensagem", msg);
        request.setAttribute("classe", classe);
        request.setAttribute("lista", dao.getTarefas());
        getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
    }
}
