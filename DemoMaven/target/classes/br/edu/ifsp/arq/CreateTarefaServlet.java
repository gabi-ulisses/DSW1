package br.edu.ifsp.arq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tarefa")
public class CreateTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateTarefaServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		  Tarefa t = new Tarefa(nome, descricao);
		  
		  request.setAttribute("tarefa", t);

	      String url = "/obrigado.jsp"; // Ao inves da url do servlet agora iremos passar a requisição para a página.

	      getServletContext().getRequestDispatcher(url).forward(request, response);

	}

}
