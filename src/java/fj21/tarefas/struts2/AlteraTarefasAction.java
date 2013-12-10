package fj21.tarefas.struts2;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
@Namespace(value="/")
public class AlteraTarefasAction {
	private Tarefa tarefa;

	@Action(value = "alteraTarefa", results = { @Result(name = "ok", location = "/altera-tarefas.jsp") })
	public String execute() throws SQLException {
		new TarefaDAO().altera(tarefa);
		System.out.println("Tarefa alterada");
		return "ok";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}