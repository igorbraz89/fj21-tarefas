<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="topo.jsp"%>
<%@include file="menu.jsp"%>
<br />
<br />
<h3>VISUALIZA TAREFAS</h3>
<form action="visualizaTarefa" method="post">
	<input type="hidden" name="ok"> <input type="submit"
		value="Visualizar">
</form>
<br />
<table border="0">
	<tr align="center" bgcolor=#add8e6>
		<th>&nbsp;&nbsp;&nbsp;</th>
		<th>ID</th>
		<th>Finalizado</th>
		<th>Descri&ccedil;&atilde;o</th>
		<th>Data de Finaliza&ccedil;&atilde;o</th>
		<th>&nbsp;&nbsp;&nbsp;</th>
	</tr>
	<c:forEach items="${tarefas}" var="tarefa">
		<tr>
			<td bgcolor=#add8e6></td>
			<td align="center">${tarefa.id}</td>
			<c:if test="${tarefa.finalizado eq false}">
				<td align="center">N&atilde;o</td>
			</c:if>
			<c:if test="${tarefa.finalizado}">
				<td align="center">Sim</td>
			</c:if>
			<td align="center">${tarefa.descricao}</td>
			<td align="center"><fmt:formatDate
					value="${tarefa.dataFinalizado}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
			<td bgcolor=#add8e6></td>

		</tr>

	</c:forEach>
</table>
<%@include file="rodape.jsp"%>