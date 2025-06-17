<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Tarefas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">>
</head>
<body>
    <header class="bg-primary text-white p-3 mb-4">
        <div class="container">
            <h1 class="h3">Gestão de Tarefas</h1>
            <nav>
                <ul class="nav">
                    <li class="nav-item"><a href="index.jsp" class="nav-link text-white">Criar Tarefa</a></li>
                    <li class="nav-item"><a href="tarefa" class="nav-link text-white">Ver Tarefas</a></li>
                </ul>
            </nav>
        </div>
        <c:if test="${not empty mensagem}">
            <div class=" ${classe} " role="alert">
                        ${mensagem}
            </div>
        </c:if>
    </header>
