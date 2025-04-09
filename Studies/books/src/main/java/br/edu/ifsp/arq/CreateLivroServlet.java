package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateLivroServlet
 */
@WebServlet("/criar-livro")
public class CreateLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String titulo = req.getParameter("titulo"); 
        String autor = req.getParameter("autor"); 
        String[] generos = req.getParameterValues("genero"); 
        int anoPublicacao = Integer.parseInt("2024"); 
        
        ArrayList<String> listaGeneros = new ArrayList<>();
        if (generos != null) {
            for (String g : generos) {
                listaGeneros.add(g);
            }
        }
        
        Livro livro = new Livro(titulo, autor, listaGeneros, anoPublicacao);
        
        ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista");
        
        if (listaLivros == null) {
            listaLivros = new ArrayList<>();
        }
        
        listaLivros.add(livro);
        
        getServletContext().setAttribute("lista", listaLivros);
                
        String url = "/listar-livros";
		
		getServletContext().getRequestDispatcher(url).forward(req, resp);
		/*
        PrintWriter out = resp.getWriter();
        
        out.append("<!DOCTYPE html>");
        out.append("<html lang=\"pt-br\">");
        out.append("<head><title>Livro Criado</title></head>");
        out.append("<body>");
        out.append("<h1>Livro criado com sucesso!</h1>");
        out.append("<h2>Detalhes do Livro:</h2>");
        out.append("<ul>");
        out.append("<li><strong>Título:</strong> " + titulo + "</li>");
        out.append("<li><strong>Autor:</strong> " + autor + "</li>");
        out.append("<li><strong>Gêneros:</strong> " + String.join(", ", listaGeneros) + "</li>");
        out.append("<li><strong>Ano de Publicação:</strong> " + anoPublicacao + "</li>");
        out.append("</ul>");
        out.append("</body>");
        out.append("</html>");*/
    }
}