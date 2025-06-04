<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h2>Lista de Tarefas</h2>

    <c:if test="${not empty mensagem}">
        <div class="alert ${classe}" role="alert">
            ${mensagem}
        </div>
    </c:if>

    <div class="row">
        <!-- Verifica se a lista de tarefas não está vazia -->
        <c:forEach var="tarefa" items="${tarefas}">
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${tarefa.nome}</h5>
                        <p class="card-text">${tarefa.descricao}</p>
                        <a href="form-editar.jsp?id=${tarefa.id}" class="btn btn-warning">Editar</a>
                        <a href="tarefa?acao=excluir&id=${tarefa.id}" class="btn btn-danger">Excluir</a>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!-- Caso não haja tarefas -->
        <c:if test="${empty tarefas}">
            <div class="alert alert-warning" role="alert">
                Nenhuma tarefa encontrada.
            </div>
        </c:if>
    </div>
</div>

<%@ include file="footer.jsp" %>
