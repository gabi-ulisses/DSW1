// Pacote onde a classe está localizada, útil para organização do projeto
package br.ifsp.edu.arq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A classe Usuario é uma implementação de HttpServlet.
 * Ela é responsável por tratar requisições HTTP e gerar respostas específicas.
 */
public class Usuario extends HttpServlet {
    // Identificador único usado para garantir a compatibilidade na serialização da classe
    private static final long serialVersionUID = 1L;

    /**
     * Construtor padrão da classe.
     * Chama o construtor da classe pai (HttpServlet) para inicializar corretamente.
     */
    public Usuario() {
        super();
        // Este construtor ainda não tem nenhuma lógica adicional implementada.
    }

    /**
     * Método chamado ao receber uma requisição HTTP do tipo GET.
     * Aqui, o servlet escreve na resposta a mensagem "Served at:" seguida do contexto da aplicação.
     * 
     * @param request Contém informações da requisição feita pelo cliente.
     * @param response Usado para enviar uma resposta ao cliente.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Escreve na resposta o caminho do contexto da aplicação.
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * Método chamado ao receber uma requisição HTTP do tipo POST.
     * Neste caso, delega o tratamento ao método doGet, fazendo com que POST seja tratado da mesma forma que GET.
     * 
     * @param request Contém informações da requisição feita pelo cliente.
     * @param response Usado para enviar uma resposta ao cliente.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redireciona a requisição POST para o método doGet.
        doGet(request, response);
    }
}
