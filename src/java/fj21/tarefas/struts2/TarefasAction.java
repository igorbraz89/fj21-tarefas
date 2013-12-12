package fj21.tarefas.struts2;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
/*------------------
 * index()
 * save()
 * update()
 * list()
 * delete()
 * finaliza()
 * ------------------
 * novaTarefaController
 * updateTarefaController
 * ------------------*/
@Namespace("/tarefas")
public class TarefasAction {

	private Tarefa tarefa = new Tarefa();
	private List<Tarefa> tarefas;
	private Long id;

	@Action(value = "home", results = { @Result(name = "ok", location = "/WEB-INF/views/tarefas/index.jsp") })
	public String index() {
		System.out.println("Redirect para Home");
		return "ok";
	}

	@Action(value = "create", results = { @Result(name = "ok", location = "/WEB-INF/views/formulario-tarefas.jsp") })
	public String create() {
		System.out.println("<create> Abre formulário");
		return "ok";
	}

	@Action(value = "save", results = { @Result(name = "ok", type="redirect", location = "/tarefas/list") })
	public String save() throws SQLException {
		new TarefaDAO().adiciona(tarefa);
		System.out.println("<save> Tarefa adicionada");
		return "ok";
	}

	@Action(value = "list", results = { @Result(name = "ok", location = "/WEB-INF/views/visualiza-tarefas.jsp") })
	public String list() throws SQLException {
		tarefas = new TarefaDAO().getLista();
		System.out.println("<list> Lista criada");
		return "ok";
	}

	@Action(value = "edit", results = { @Result(name = "ok", location = "/WEB-INF/views/altera-tarefas.jsp") })
	public String updateTarefaController() {
		System.out.println("<edit> Abre formulário");
		return "ok";
	}

	@Action(value = "update", results = { @Result(name = "ok", type="redirect", location = "/tarefas/list") })
	public String update() throws SQLException {
		new TarefaDAO().altera(tarefa);
		System.out.println("Tarefa alterada");
		return "ok";
	}

	@Action(value = "finalizaTarefa", results = { @Result(name = "ok", type = "httpheader", params = {
			"status", "200" }) })
	public String finaliza() throws SQLException {
		new TarefaDAO().finaliza(id);
		System.out.println("Tarefa finalizada");
		return "ok";
	}

	@Action(value = "removerTarefa", results = { @Result(name = "remove",type="redirect", location = "/tarefas/list") })
	public String delete() throws SQLException {
		new TarefaDAO().remove(tarefa);
		System.out.println("Tarefa removida");
		return "remove";
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

	public void setId(Long id) {
		this.id = id;
		System.out.println("id=" + this.id);
	}
}
