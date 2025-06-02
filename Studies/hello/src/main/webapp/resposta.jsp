<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"></c:import>
	
<c:choose>
	<c:when test="${lista.size() > 0 }">
	
	<table class="table table-striped">
  		<thead>
    		<tr>
	      		<th scope="col">#</th>
	      		<th scope="col">Nome</th>
	      		<th scope="col">Descricao</th>      
    		</tr>
  		</thead>
  		<tbody>
  		
  		<c:forEach var="t" items="${lista}">
		    <tr>
		      <th scope="row">${t.id}</th>
		      <td>${t.nome}</td>
		      <td>${t.descricao}</td>
		      <td>
		        <a href="editar?id=${t.id}" class="btn btn-warning btn-sm">Editar</a>
		        <a href="excluir?id=${t.id}" class="btn btn-danger btn-sm" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
		      </td>
		    </tr>
		</c:forEach>
     
  		</tbody>
	</table>
	
		
	</c:when>
	<c:otherwise>	
		<div class="alert alert-danger" role="alert">
  			Não há dados cadastrados
		</div>		
	</c:otherwise>
</c:choose>

<c:import url="footer.jsp"></c:import>