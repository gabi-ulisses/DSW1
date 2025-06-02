package br.edu.ifsp.arq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.dao.TarefaDAO;

@WebServlet("/excluir")
public class ExcluirTarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TarefaDAO dao;

    public ExcluirTarefaServlet() {
        dao = TarefaDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        dao.excluirTarefa(id);

        // Atualiza a lista
        getServletContext().setAttribute("lista", dao.getTarefas());
        response.sendRedirect("resposta.jsp");
    }
}