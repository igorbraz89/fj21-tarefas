<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="topo.jsp"%>
	<br />
	<div id="centro">
		<form action="login" method="post">
	Login: 								<input type="text" name="usuario.login" /><br />
	Senha:								<input type="password" name="usuario.senha" /><br /> 
	<input type="submit" value="Entrar">
										
		</form>
	</div>
<%@include file="rodape.jsp"%>