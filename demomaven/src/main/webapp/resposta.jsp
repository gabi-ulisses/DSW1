<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"></c:import>

	<h2>Obrigado</h2>

	<c:choose>
		<c:when test="${lista.size() > 0 }">
			<c:forEach var="t" items="${lista}">
				<h3>${t.nome}- ${t.descricao}</h3>
			</c:forEach>
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>

<c:import url="footer.jsp"></c:import>
