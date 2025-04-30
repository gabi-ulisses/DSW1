<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>
	
	<div class="container">
	    <form action="tarefa" method="POST">
	        <div class="row">
	            <div class="col-12 col-md-6">
	                <label for="nome" class="form-text">Nome:</label>
	                <input type="text" class="form-control" name="nome">
	            </div>
	            <div class="col-12 col-md-6">
	                <label for="descricao" class="form-text">Descrição:</label>
	                <input type="text" class="form-control" name="descricao">               
	            </div>
	        </div>
	        <div class="d-flex justify-content-center mt-3">
	            <input type="submit" class="btn btn-primary" value="Enviar">
	        </div>
	    </form>
	</div>

<c:import url="footer.jsp"></c:import>
