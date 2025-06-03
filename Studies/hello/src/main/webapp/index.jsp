<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

    <h1 id="pageTitle" class="mb-4">Cadastro de Tarefa</h1>

    <form action="tarefa" method="POST" novalidate>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" class="form-control" value="${param.nome}" required />
            </div>
            <div class="form-group col-md-6">
                <label for="descricao">Descrição</label>
                <input type="text" id="descricao" name="descricao" class="form-control" value="${param.descricao}" required />
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Enviar</button>
    </form>
</main>

<c:import url="footer.jsp" />
