<%@ include file="header.jsp" %>

<div class="container">
    <h2>Editar Tarefa</h2>

    <form action="tarefa" method="post">
        <input type="hidden" name="acao" value="editar">
        <input type="hidden" name="id" value="${tarefa.id}">
        
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${tarefa.nome}" required>
        </div>

        <div class="mb-3">
            <label for="descricao" class="form-label">Descrição:</label>
            <textarea class="form-control" id="descricao" name="descricao" required>${tarefa.descricao}</textarea>
        </div>

        <button type="submit" class="btn btn-warning">Atualizar Tarefa</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
