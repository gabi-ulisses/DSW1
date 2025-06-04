<%@ include file="header.jsp" %>

<div class="container">
    <h2>Criar Nova Tarefa</h2>
    <form action="tarefa" method="post">
        <input type="hidden" name="acao" value="adicionar">
        
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>

        <div class="mb-3">
            <label for="descricao" class="form-label">Descrição:</label>
            <textarea class="form-control" id="descricao" name="descricao" required></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Criar Tarefa</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
