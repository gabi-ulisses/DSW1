<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

    <h2 id="formTitle" class="mb-4">Editar Tarefa</h2>

    <form action="editar" method="post" novalidate>
        <input type="hidden" name="id" value="${tarefa.id}" />

        <div class="form-group">
            <label for="nome" class="font-weight-bold">Nome</label>
            <input type="text" id="nome" name="nome" value="${tarefa.nome}" class="form-control" required aria-required="true" aria-describedby="nomeHelp" />
            <small id="nomeHelp" class="form-text text-muted">Informe o nome da tarefa.</small>
        </div>

        <div class="form-group">
            <label for="descricao" class="font-weight-bold">Descrição</label>
            <textarea id="descricao" name="descricao" class="form-control" required aria-required="true" aria-describedby="descricaoHelp">${tarefa.descricao}</textarea>
            <small id="descricaoHelp" class="form-text text-muted">Informe a descrição da tarefa.</small>
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</main>

<c:import url="footer.jsp" />
