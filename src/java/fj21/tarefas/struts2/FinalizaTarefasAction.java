package fj21.tarefas.struts2;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

public class FinalizaTarefasAction {
	private Long id;
	@Action(value = "finalizaTarefa", results = { @Result(name = "ok", type="httpheader", params={"status","200"})}, interceptorRefs = { @InterceptorRef("login") })
	public String execute() throws SQLException {
		new TarefaDAO().finaliza(id);
		System.out.println("Tarefa removida");
		return "ok";
	}
	
	public void setId(Long id) {
		this.id = id;
		System.out.println("id="+this.id);
	}
}