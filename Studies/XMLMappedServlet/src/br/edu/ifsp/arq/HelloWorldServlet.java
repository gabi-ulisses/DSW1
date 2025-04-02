// Este servlet é responsável por responder a requisições HTTP e gerar uma resposta HTML simples.

package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A classe HelloWorldServlet estende HttpServlet para lidar com requisições HTTP.
public class HelloWorldServlet extends HttpServlet {

    // serialVersionUID é usado para verificar a compatibilidade de versões da classe durante a serialização.
    private static final long serialVersionUID = 1L;

    // Método sobrescrito do HttpServlet, chamado para processar requisições HTTP GET.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtém um objeto PrintWriter, que será usado para enviar a resposta ao cliente.
        PrintWriter out = resp.getWriter();
        
        // Escreve no fluxo de saída (PrintWriter) uma resposta HTML simples.
        // Aqui, o conteúdo será renderizado no navegador do cliente como uma mensagem na página.
        out.print("<h1> Hello World! </h1>");
    }
}