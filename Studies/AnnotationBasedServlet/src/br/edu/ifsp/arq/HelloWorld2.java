// Pacote onde a classe está localizada, útil para organização do projeto
package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A anotação @WebServlet mapeia o servlet para a URL "/hello"
// Isso significa que quando acessarmos http://<servidor>/hello, este servlet será executado
@WebServlet("/hello")
public class HelloWorld2 extends HttpServlet {

    // Identificador único para a classe, importante para a serialização
    private static final long serialVersionUID = 1L;

    // Método sobrescrito do HttpServlet para tratar requisições HTTP do tipo GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtém um objeto PrintWriter para escrever a resposta diretamente na saída HTTP
        PrintWriter out = resp.getWriter();
        
        // Escreve a resposta no formato HTML para ser exibida no navegador do cliente
        out.append("<h1>Hello World, de novo!</h1>");
    }
}