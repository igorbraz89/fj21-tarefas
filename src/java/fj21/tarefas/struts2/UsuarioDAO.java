package fj21.tarefas.struts2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	private Connection connection;
	public UsuarioDAO() {

	}
	public boolean existeUsuario(Usuario usuario) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		// cria um preparedStatement
		PreparedStatement stmt = this.connection
				.prepareStatement("select login,senha from usuario");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("login").equals(usuario.getLogin())
					&& rs.getString("senha").equals(usuario.getSenha())) {

				rs.close();
				stmt.close();
				System.out.println("usuario existente");
				this.connection.close();
				System.out.println("conex�o encerrada");
				return true;
			}
		}
		rs.close();
		stmt.close();
		this.connection.close();
		System.out.println("usuario INexistente");
		System.out.println("conex�o encerrada");
		return false;
	}
}// classe
