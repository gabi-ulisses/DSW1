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
 * Servlet implementation class ReadLivroServlet
 */
@WebServlet("/listar-livros")
public class ReadLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadLivroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura o tipo de conteúdo da resposta como HTML com codificação UTF-8
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Início do HTML gerado dinamicamente
        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'><head><title>Lista de Livros</title></head><body>");
        out.println("<h1>Livros Cadastrados</h1>");

        // Criação da tabela para listar os livros
        out.println("<table border='1'>");
        out.println("<tr><th>Título</th><th>Autor</th><th>Ações</th></tr>");

        // Recupera a lista de livros do contexto da aplicação
        ArrayList<Livro> livros = (ArrayList<Livro>) getServletContext().getAttribute("livros");

        // Verifica se há livros na lista e os exibe
        if (livros != null && !livros.isEmpty()) {
            for (Livro livro : livros) {
                out.println("<tr>");
                out.println("<td>" + livro.getTitulo() + "</td>");
                out.println("<td>" + livro.getAutor() + "</td>");
                out.println("<td>");
                out.println("<a href='/editar-livro?id=" + livro.getId() + "'>Editar</a> | ");
                out.println("<a href='/excluir-livro?id=" + livro.getId() + "'>Excluir</a>");
                out.println("</td>");
                out.println("</tr>");
            }
        } else {
            // Exibe uma mensagem caso não haja livros cadastrados
            out.println("<tr><td colspan='3'>Nenhum livro cadastrado.</td></tr>");
        }

        out.println("</table>");

        // Link para adicionar um novo livro
        out.println("<a href='/form-livro'>Adicionar Novo Livro</a>");

        // Finaliza o HTML
        out.println("</body></html>");
    }



}
