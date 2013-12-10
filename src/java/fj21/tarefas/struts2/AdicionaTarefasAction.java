package fj21.tarefas.struts2;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;


@Namespace(value="/")
public class AdicionaTarefasAction {
	private Tarefa tarefa;

	@Action(value = "adicionaTarefa", results = { @Result(name = "ok", location = "/formulario-tarefas.jsp") })
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