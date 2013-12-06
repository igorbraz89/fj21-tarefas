package fj21.tarefas.struts2;
import java.sql.SQLException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class AutorizadorAction {
	private Long id;
	@Action(value = "finalizaTarefa", results = { @Result(name = "ok", type="httpheader", params={"status","200"}) })
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