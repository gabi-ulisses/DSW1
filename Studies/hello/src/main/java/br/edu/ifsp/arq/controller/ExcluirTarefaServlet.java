package br.edu.ifsp.arq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.arq.dao.TarefaDAO_CSV;

@WebServlet("/excluir")
public class ExcluirTarefaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TarefaDAO_CSV dao;

    @Override
    public void init() throws ServletException {
        dao = TarefaDAO_CSV.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String msg;
        String classe;

        try {
            if (idParam == null || idParam.trim().isEmpty()) {
                msg = "ID inválido para exclusão";
                classe = "alert alert-danger";
            } else {
                int id = Integer.parseInt(idParam);
                boolean excluiu = dao.excluirTarefa(id);
                if (excluiu) {
                    msg = "Tarefa excluída com sucesso";
                    classe = "alert alert-success";
                } else {
                    msg = "Tarefa não encontrada";
                    classe = "alert alert-warning";
                }
            }
        } catch (NumberFormatException e) {
            msg = "ID inválido";
            classe = "alert alert-danger";
        }

        request.setAttribute("mensagem", msg);
        request.setAttribute("classe", classe);
        request.setAttribute("lista", dao.getTarefas());

        getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
    }
}
