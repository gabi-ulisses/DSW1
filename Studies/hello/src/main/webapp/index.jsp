<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>



<div class="container">

	<form action="tarefa" method="POST">
		<div class="form-row">
			<div class="col-sm-12 col-md-6">
				<label for="nome" class="form-text">Nome:</label> 
				<input type="text" class="form-control" name="nome">
			</div>
			<div class="col-sm-12 col-md-6">
				<label for="descricao" class="form-text">Descrição:</label> 
				<input type="text" class="form-control" name="descricao">
			</div>		
		</div>
		
		 

		
		<input type="submit" class="btn btn-primary mt-1" value="Enviar">
	</form>
</div>

<c:import url="footer.jsp"></c:import>