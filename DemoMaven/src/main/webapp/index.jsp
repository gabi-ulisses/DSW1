<%@ include file="header.jsp"%>

<%
    // Scriplets: trecho de c�digo Java para demonstrar funcionalidade
    String mensagem = "Bem-vindo � p�gina de cadastro!";
%>

<section>
    <h2>P�gina de Cadastro</h2>
    <p><%= mensagem %></p>
   	<p>
   	    <a href="adicionar_tarefa.jsp">Ir para Cadastro</a>
   	</p>
</section>

<%@ include file="footer.jsp"%>