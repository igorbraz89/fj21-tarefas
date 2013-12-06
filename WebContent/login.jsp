<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="topo.jsp"%>
	<%@include file="menu.jsp"%>
	<br />
	<div id="centro">
		<form action="login" method="post">
	Login: 								<input type="text" name="usario.login" /><br />
	Senha:								<input type="text" name="usuario.senha" /><br /> 
	<input type="submit" value="Entrar">
										
		</form>
	</div>
<%@include file="rodape.jsp"%>