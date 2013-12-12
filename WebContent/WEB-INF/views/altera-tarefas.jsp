<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="topo.jsp"%>
	<%@include file="menu.jsp"%>
	<br />
	<div id="centro">
		<form action="update" method="post">
										<input type="hidden" name="tarefa.id" value="${tarefa.id}">	
	Evento finalizado?:					<input type="checkbox" name="tarefa.finalizado" value="true" /><br /> 
	Data de Finaliza&ccedil;&atilde;o:	<input type="date"
										name="tarefa.dataFinalizado" /><br /> Descri&ccedil;&atilde;o:<br />
										<textarea name="tarefa.descricao" rows="5" cols="100"></textarea>
										<br /> <input type="submit" value="Adicionar">
		</form>
	</div>
<%@include file="rodape.jsp"%>