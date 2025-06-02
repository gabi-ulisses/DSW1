<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

<h2>Editar Tarefa</h2>
<form action="editar" method="post">
    <input type="hidden" name="id" value="${tarefa.id}" />
    
    <div class="mb-3">
        <label>Nome</label>
        <input type="text" name="nome" value="${tarefa.nome}" class="form-control" required />
    </div>
    <div class="mb-3">
        <label>Descrição</label>
        <textarea name="descricao" class="form-control" required>${tarefa.descricao}</textarea>
    </div>
    <button type="submit" class="btn btn-primary">Salvar</button>
</form>

<c:import url="footer.jsp" />