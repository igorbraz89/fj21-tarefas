package fj21.tarefas.struts2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TarefaDAO {
	private Connection connection;

	public TarefaDAO() {

	}

	public void adiciona(Tarefa tarefa) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		// cria um preparedStatement
		String sql_insertIntoContatos = "insert into Tarefas"
				+ " (Id,descricao,dataFinalizacao,finalizado)"
				+ " values (?,?,?,?)";
		PreparedStatement stmt_insert = this.connection
				.prepareStatement(sql_insertIntoContatos);
		// preenche os valores
		stmt_insert.setLong(1, tarefa.getId());
		stmt_insert.setString(2, tarefa.getDescricao());
		Date date = new Date(tarefa.getDataFinalizado().getTime());
		stmt_insert.setDate(3, date);
		int finalizado = 0;
		if (tarefa.isFinalizado()) {
			finalizado = 1;
		}
		stmt_insert.setInt(4, finalizado);
		System.out.println(tarefa.getDataFinalizado());
		// executa
		stmt_insert.execute();

		stmt_insert.close();
		System.out.println("Gravado!");

		this.connection.close();
		System.out.println("conex�o encerrada");
	}
	public void remove(Tarefa tarefa) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		// cria um preparedStatement
		
		String sql_delete="DELETE FROM tarefas WHERE Id="+tarefa.getId();
		PreparedStatement stmt_delete = this.connection
				.prepareStatement(sql_delete);
		// preenche os valores
		
		System.out.println(tarefa.getDataFinalizado());
		// executa
		stmt_delete.execute();

		stmt_delete.close();
		System.out.println("Gravado!");

		this.connection.close();
		System.out.println("conex�o encerrada");
	}

	public List<Tarefa> getLista() {
		this.connection = new ConnectionFactory().getConnection();
		try {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select Id,finalizado,dataFinalizacao,descricao from tarefas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Tarefa tarefa = new Tarefa();

				tarefa.setId(rs.getString("Id"));
				boolean finalizado = false;
				if (rs.getInt("finalizado") == 1) {
					finalizado = true;
				}
				tarefa.setFinalizado(finalizado);
				tarefa.setDataFinalizado(rs.getString("dataFinalizacao"));
				
				tarefa.setDescricao(rs.getString("descricao"));
				// adicionando o objeto � lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			this.connection.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}// classe
