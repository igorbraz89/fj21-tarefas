package fj21.tarefas.struts2;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
@ParentPackage("default")
public class AdicionaTarefasAction {
	private Tarefa tarefa;
	@Action(value = "adicionaTarefa", results = { @Result(name = "ok", location = "/visualiza-tarefas.jsp")}, interceptorRefs = { @InterceptorRef("login") })
	public String execute() throws SQLException {
		new TarefaDAO().adiciona(tarefa);
		System.out.println("Tarefa adicionada");
		return "ok";
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}