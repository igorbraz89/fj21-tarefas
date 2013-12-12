<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="topo.jsp"%>
<script type="text/javascript">
	function finalizaAgora(id){		
		$.ajax({
			  type: "POST",
			  url: "finalizaTarefa?id="+id,
			  data: "",
			  success: function(data) {
				  location.reload();
			  }
			});
	}
	
</script>
<%@include file="menu.jsp"%>
<br />
<div id="centro">
<table border="0">
	<tr align="center" bgcolor=#add8e6>
		<th>&nbsp;&nbsp;&nbsp;</th>
		<th>ID</th>
		<th>Finalizado</th>
		<th>Descri&ccedil;&atilde;o</th>
		<th>Data de Finaliza&ccedil;&atilde;o</th>
		<th>&nbsp;&nbsp;&nbsp;</th>
		<th>&nbsp;&nbsp;&nbsp;</th>
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
			<c:choose>
				<c:when test="${tarefa.finalizado eq false}">
					<td><input TYPE="BUTTON" NAME="ok" value="finalizar"
						onclick="finalizaAgora(${tarefa.id})"></input></td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>

			<td bgcolor=#add8e6 align="center">
				<form action="removerTarefa" method="post">
					<input type="hidden" name="tarefa.id" value="${tarefa.id}">
					<input type="submit" style="color: red" value=" X ">
				</form>
			</td>
			<td bgcolor=#add8e6 align="center">
				<form action="edit" method="get">
					<input type="hidden" name="tarefa.id" value="${tarefa.id}">
					<input type="submit" style="color: blue" value="Edit">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
</div>
<%@include file="rodape.jsp"%>