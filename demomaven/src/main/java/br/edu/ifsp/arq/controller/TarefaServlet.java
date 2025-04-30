package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.dao.TarefaDAO;
import br.edu.ifsp.arq.model.Tarefa;

/**
 * Servlet implementation class TarefaServlet
 */
@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TarefaDAO dao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TarefaServlet() {
		super();
		dao = TarefaDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String msg = "";
		
		if (nome.isEmpty() || descricao.isEmpty()) {
			msg = "Nome e descrição não podem ser vazios";	
//			getServletContext().setAttribute("mensagem", msg);
			request.setAttribute("mensagem", msg);
			request.setAttribute("class", "alert alert-danger");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		} else {
					
			Tarefa t = new Tarefa(nome, descricao);

			if(dao.adicionarTarefa(t)) {
				msg = "Tarefa adicionada com sucesso!";
				request.setAttribute("mensagem", msg);
				request.setAttribute("class", "alert alert-success");

			}
			
			getServletContext().setAttribute("lista", dao.getTarefas());

			getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
		}
	}

}
