package br.edu.ifsp.arq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.dao.TarefaDAO;
import br.edu.ifsp.arq.model.Tarefa;

@WebServlet("/editar")
public class EditarTarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TarefaDAO dao;

    public EditarTarefaServlet() {
        dao = TarefaDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Tarefa tarefa = dao.buscarPorId(id);

        request.setAttribute("tarefa", tarefa);
        request.getRequestDispatcher("/form-editar.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");

        dao.atualizarTarefa(new Tarefa(id, nome, descricao));

        getServletContext().setAttribute("lista", dao.getTarefas());
        response.sendRedirect("resposta.jsp");
    }
}
