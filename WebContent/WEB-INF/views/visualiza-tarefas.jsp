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
	function Imprime(){	
		print();
	}
</script>
<%@include file="menu.jsp"%>
<br />
<br />
<br />
<form action="visualizaTarefa" method="post">
	<input type="submit" value="Visualizar">
</form>
<br />
<form action="removerTarefa" method="post">
	<input type="hidden" name="remove"> ID: <input type="text"
		name="tarefa.id"> <input type="submit" value="Remover">
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
			<td bgcolor=#add8e6></td>
		</tr>
	</c:forEach>
</table>
<input TYPE="BUTTON" NAME="ok" value="Imprimir" onclick="Imprime()"></input>
<%@include file="rodape.jsp"%>