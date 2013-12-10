package fj21.tarefas.struts2;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/tarefas")
public class TarefasAction {

	private Tarefa tarefa = new Tarefa();
	private List<Tarefa> tarefas;
	
	@Action(value="home", results= {@Result(name="ok", location="/WEB-INF/views/tarefas/index.jsp")})
	public String index(){
		return "ok";
	}
	
	
	@Action(value="nova", results= {@Result(name="ok", location="/WEB-INF/views/formulario-tarefas.jsp")})
	public String newTarefa(){
		
		return "ok";
	}
	
	@Action(value = "adicionaTarefa", results = { @Result(name = "ok", location = "/WEB-INF/views/tarefas/index.jsp") })
	public String save() throws SQLException {
		new TarefaDAO().adiciona(tarefa);
		System.out.println("Tarefa adicionada");
		return "ok";
	}
	@Action(value="show", results= {@Result(name="ok", location="/WEB-INF/views/visualiza-tarefas.jsp")})
	public String visualiza(){
		
		return "ok";
	}
	@Action(value = "visualizaTarefa", results = { @Result(name = "ok", location = "/WEB-INF/views/visualiza-tarefas.jsp")  })
	public String show() throws SQLException {
		tarefas = new TarefaDAO().getLista();
		return "ok";
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}
