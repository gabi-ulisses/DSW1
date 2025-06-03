<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

    <h1 id="pageTitle" class="mb-4">Lista de Tarefas</h1>

    <c:choose>
        <c:when test="${not empty lista}">
            <table class="table table-striped table-hover" aria-describedby="tabelaDescricao">
                <caption id="tabelaDescricao" class="sr-only">
                    Tabela com as tarefas cadastradas e opções para editar e excluir
                </caption>
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="t" items="${lista}">
                        <tr>
                            <th scope="row">${t.id}</th>
                            <td>${t.nome}</td>
                            <td>${t.descricao}</td>
                            <td>
                                <a href="editar?id=${t.id}" class="btn btn-warning btn-sm" aria-label="Editar tarefa ${t.nome}">Editar</a>
                                <a href="excluir?id=${t.id}" class="btn btn-danger btn-sm" aria-label="Excluir tarefa ${t.nome}" onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning" role="alert">Não há tarefas cadastradas.</div>
        </c:otherwise>
    </c:choose>
</main>

<c:import url="footer.jsp" />
