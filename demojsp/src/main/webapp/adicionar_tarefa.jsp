<%@ include file="header.jsp" %>
<header>
		<h1>Formulário de Tarefa</h1>
</header>
<main>
		<form action="tarefa" method="POST">
		
			
		
				<label for="nomeTarefa">Nome da Tarefa:</label> <input type="text"
					id="nomeTarefa" name="nome">

				<label for="descricaoTarefa">Descrição da Tarefa:</label>
				<textarea id="descricaoTarefa" name="descricao" rows="3"></textarea>
				
			
			
			<input type="submit" value="Enviar">
		</form>
	</main>
<%@ include file="footer.jsp"%>
