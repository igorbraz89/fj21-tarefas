package fj21.tarefas.struts2;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

public class AutorizadorAction {
	private Usuario usuario;
	@Action(value = "login", results = { @Result(name = "ok", location = "/visualiza-tarefas.jsp"),
										 @Result(name = "naoLogado", location = "/login.jsp")
	})
	public String login() throws SQLException {
		if (new UsuarioDAO().existeUsuario(this.usuario)){
			ActionContext.getContext().getSession().put("usuarioLogado",this.usuario);
			return "ok";
		}else{
		return "invalido";
		}
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}