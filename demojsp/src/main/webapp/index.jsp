<%@ include file="header.jsp"%>

<%
    // Scriplets: trecho de código Java para demonstrar funcionalidade
    String mensagem = "Bem-vindo à página de cadastro!";
%>

<section>
    <h2>Página de Cadastro</h2>
    <p><%= mensagem %></p>
   	<p>
   	    <a href="adicionar_tarefa.jsp">Ir para Cadastro</a>
   	</p>
</section>

<%@ include file="footer.jsp"%>