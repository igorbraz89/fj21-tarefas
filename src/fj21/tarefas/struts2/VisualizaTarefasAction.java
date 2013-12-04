package fj21.tarefas.struts2;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class VisualizaTarefasAction {
	private List <Tarefa> tarefas;
	@Action(value = "visualizaTarefa", results = { @Result(name = "ok", location = "/visualiza-tarefas.jsp") })
	public String execute() throws SQLException {
		tarefas=new TarefaDAO().getLista();
		return "ok";
	}
	
	public List <Tarefa> getTarefas() {
		return tarefas;
	}
	
}