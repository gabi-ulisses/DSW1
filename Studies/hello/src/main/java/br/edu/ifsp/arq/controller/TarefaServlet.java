package br.edu.ifsp.arq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.dao.TarefaDAO;
import br.edu.ifsp.arq.model.Tarefa;

/**
 * Servlet responsável por processar requisições relacionadas a tarefas.
 * Recebe dados de formulários via POST, valida os campos, salva a tarefa
 * usando o DAO e redireciona o usuário para a página de resposta.
 */
@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private TarefaDAO dao;

    public TarefaServlet() {
        super();
        // Pode deixar vazio, inicializa no init()
    }

    @Override
    public void init() throws ServletException {
        super.init();
        dao = TarefaDAO.getInstance();
        String caminho = getServletContext().getRealPath("/WEB-INF/data/saida.json");
        dao.setCaminhoArquivo(caminho);
    }

	/**
	 * Método chamado quando uma requisição GET é feita à URL /tarefa.
	 * Aqui, apenas retorna uma resposta simples (pode ser expandido futuramente).
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Método chamado quando uma requisição POST é feita à URL /tarefa.
	 * Lê os dados do formulário (nome e descrição), valida, salva a tarefa
	 * e redireciona para a página adequada com mensagens de sucesso ou erro.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtém a sessão do usuário (caso precise armazenar dados por usuário no futuro)
		HttpSession s = request.getSession();	
		
		// Captura os parâmetros do formulário
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String msg = "";
		
		// Validação: campos obrigatórios
		if (nome.isEmpty() || descricao.isEmpty()) {
			
			// Define mensagem de erro e redireciona de volta para o formulário
			msg = "Nome e descrição não podem ser vazios";
			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-danger"); // classe CSS para estilizar o alerta
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		} else {
			// Cria a tarefa com os dados do formulário
			Tarefa t = new Tarefa(nome, descricao);

			// Tenta salvar a tarefa via DAO
			if (dao.adicionarTarefa(t)) {
				msg = "Tarefa adicionada com sucesso";
				request.setAttribute("mensagem", msg);
				request.setAttribute("classe", "alert alert-success");
			}

			// Atualiza o contexto da aplicação com a lista atualizada de tarefas
			request.setAttribute("lista", dao.getTarefas());

			// Redireciona para a página de resposta
			getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
		}
	}
}