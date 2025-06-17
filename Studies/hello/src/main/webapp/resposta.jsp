<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

<style>
  /* Container m�ximo centralizado com espa�amento */
  .container {
    max-width: 1200px;
    margin: 3rem auto;
    padding: 0 1rem;
    font-family: 'Poppins', sans-serif;
    color: #6b7280;
  }

  h2 {
    font-weight: 700;
    font-size: 48px;
    color: #111827;
    margin-bottom: 2rem;
  }

  .alert {
    border-radius: 0.75rem;
    padding: 1rem 1.5rem;
    margin-bottom: 2rem;
    font-weight: 600;
    font-size: 1.125rem;
  }
  .alert-success {
    background-color: #d1fae5;
    color: #065f46;
  }
  .alert-danger {
    background-color: #fee2e2;
    color: #991b1b;
  }
  .alert-warning {
    background-color: #fef3c7;
    color: #92400e;
  }

  /* Grid responsivo para cards */
  .task-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
    gap: 1.5rem;
  }

  /* Cards */
  .task-card {
    background: #ffffff;
    border-radius: 0.75rem;
    box-shadow: 0 1px 3px rgb(0 0 0 / 0.1);
    padding: 1.5rem;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    transition: box-shadow 0.3s ease;
  }
  .task-card:hover {
    box-shadow: 0 6px 12px rgb(0 0 0 / 0.15);
  }

  .task-title {
    font-weight: 600;
    font-size: 20px;
    color: #111827;
    margin-bottom: 0.5rem;
  }
  .task-desc {
    font-size: 16px;
    color: #6b7280;
    margin-bottom: 1rem;
    flex-grow: 1;
  }

  /* Bot�es e formulários na linha */
  .task-actions {
    display: flex;
    gap: 0.75rem;
  }

  a.btn, button.btn {
    border-radius: 0.75rem;
    font-weight: 600;
    padding: 0.5rem 1rem;
    text-decoration: none;
    cursor: pointer;
    transition: background-color 0.3s ease;
    border: none;
    font-family: inherit;
  }

  a.btn-warning {
    background-color: #fbbf24;
    color: #92400e;
  }
  a.btn-warning:hover {
    background-color: #f59e0b;
  }

  button.btn-danger {
    background-color: #ef4444;
    color: white;
  }
  button.btn-danger:hover {
    background-color: #dc2626;
  }

  /* Estilo para o formulário inline */
  form {
    margin: 0; /* Remove margens do formulário */
  }
</style>

<div class="container">
  <h2>Lista de Tarefas</h2>

  <c:choose>
    <c:when test="${empty lista}">
      <div class="alert alert-warning" role="alert">
        Nenhuma tarefa encontrada.
      </div>
    </c:when>
    <c:otherwise>
      <div class="task-grid">
        <c:forEach var="tarefa" items="${lista}">
          <div class="task-card" tabindex="0">
            <div class="task-title">${tarefa.nome}</div>
            <div class="task-desc">${tarefa.descricao}</div>
            <div class="task-actions">
			  <a class="btn btn-warning" href="tarefa?acao=carregar&id=${tarefa.id}">Editar</a>
			
			  <form action="tarefa" method="post" onsubmit="return confirm('Confirma exclusão?');">
			    <input type="hidden" name="acao" value="excluir" />
			    <input type="hidden" name="id" value="${tarefa.id}" />
			    <button type="submit" class="btn btn-danger">Excluir</button>
			  </form>
			</div>
          </div>
        </c:forEach>
      </div>
    </c:otherwise>
  </c:choose>
</div>

<c:import url="footer.jsp" />
