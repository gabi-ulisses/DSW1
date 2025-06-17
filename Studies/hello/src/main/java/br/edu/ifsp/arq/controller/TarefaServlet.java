package br.edu.ifsp.arq.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.arq.dao.TarefaDAO;
import br.edu.ifsp.arq.model.Tarefa;

@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TarefaDAO dao;

    @Override
    public void init() throws ServletException {
        
        // Passo 1: Pega o diretório "home" do usuário que está rodando o servidor.
        // Isso é portável: funciona em Windows, Linux, Mac, etc.
        String userHome = System.getProperty("user.home");

        // Passo 2: Constrói o caminho completo de forma segura.
        // File.separator garante que a barra ("/" ou "\") correta será usada.
        String caminhoArquivo = userHome + File.separator + "gabiulisses-eclipse-workspace/hello/src/main/webapp/data" + File.separator + "saida.json";

        System.out.println("DEBUG: O caminho do arquivo de dados foi construído dinamicamente para: " + caminhoArquivo);
        
        // Passo 3: O resto do código permanece idêntico.
        // O DAO já está pronto para receber este caminho e criar as pastas necessárias.
        TarefaDAO.init(caminhoArquivo);
        this.dao = TarefaDAO.getInstance();
    }

    public TarefaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String acao = request.getParameter("acao");
        String destino = "/resposta.jsp";

        if ("carregar".equals(acao)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Tarefa tarefa = dao.getTarefaPorId(id);

                if (tarefa != null) {
                    request.setAttribute("tarefa", tarefa);
                    destino = "/editar.jsp"; // Se encontrou, o destino é a página de edição
                } else {
                    request.setAttribute("mensagem", "Tarefa não encontrada");
                    request.setAttribute("classe", "alert alert-danger");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensagem", "ID inválido. A tarefa não pode ser carregada.");
                request.setAttribute("classe", "alert alert-danger");
            }
        }
        
        if (!destino.equals("/editar.jsp")) {
            request.setAttribute("lista", dao.getTarefas());
        }
        
        request.getRequestDispatcher(destino).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String acao = request.getParameter("acao");
        String msg = "";
        String classe = "";

        if ("adicionar".equals(acao)) {
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()) {
                msg = "Nome e descrição não podem ser vazios";
                classe = "alert alert-danger";
            } else {
                Tarefa t = new Tarefa(nome, descricao);
                if (dao.adicionarTarefa(t)) {
                    msg = "Tarefa adicionada com sucesso";
                    classe = "alert alert-success";
                } else {
                    msg = "Erro ao adicionar tarefa";
                    classe = "alert alert-danger";
                }
            }
        } else if ("editar".equals(acao)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");

                if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()) {
                    msg = "Nome e descrição são obrigatórios para edição.";
                    classe = "alert alert-danger";
                } else {
                    Tarefa t = new Tarefa(id, nome, descricao);
                    if (dao.editarTarefa(t)) {
                        msg = "Tarefa editada com sucesso";
                        classe = "alert alert-success";
                    } else {
                        msg = "Erro ao editar a tarefa";
                        classe = "alert alert-danger";
                    }
                }
            } catch (NumberFormatException e) {
                msg = "ID inválido. A tarefa não pode ser editada.";
                classe = "alert alert-danger";
            }
        } else if ("excluir".equals(acao)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                if (dao.excluirTarefa(id)) {
                    msg = "Tarefa excluída com sucesso";
                    classe = "alert alert-success";
                } else {
                    msg = "Erro ao excluir a tarefa";
                    classe = "alert alert-danger";
                }
            } catch (NumberFormatException e) {
                msg = "ID inválido. A tarefa não pode ser excluída.";
                classe = "alert alert-danger";
            }
        } else {
            msg = "Ação inválida";
            classe = "alert alert-danger";
        }

        request.setAttribute("mensagem", msg);
        request.setAttribute("classe", classe);
        request.setAttribute("lista", dao.getTarefas());
        request.getRequestDispatcher("/resposta.jsp").forward(request, response);
    }
}