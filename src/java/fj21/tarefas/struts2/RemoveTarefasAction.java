package fj21.tarefas.struts2;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class RemoveTarefasAction {
	private Tarefa tarefa;
	@Action(value = "removerTarefa", results = { @Result(name = "remove", location = "/visualiza-tarefas.jsp")})
	public String execute() throws SQLException {
		new TarefaDAO().remove(tarefa);
		System.out.println("Tarefa removida");
		return "remove";
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}