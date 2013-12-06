<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.3.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarefas Caelum</title>
<link href="estilo.css" rel="stylesheet" type="text/css" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
	<div id="geral">
		<div id="topo">
			<image
				src="http://blog.giran.com.br/wp-content/uploads/2012/06/Captura-de-Tela-2012-06-18-%C3%A0s-11.24.34.png"
				style="width:220px;height:100px;" align="left"> <br>
			</image>
			<br> <br>
			<%
				String mensagem = "Bem vindo ao sistema de gerenciamento de tarefas";
			%>
			<%=mensagem%><br /><br /><br /><br /><br />
		<div align="right"><a href="http://localhost:8080/fj21-tarefas/login.jsp" >Login</a></div>
		</div>