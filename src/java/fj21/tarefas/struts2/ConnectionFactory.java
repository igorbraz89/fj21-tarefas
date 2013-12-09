package fj21.tarefas.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/tarefas",
					"root", "");
		} catch (SQLException e) {
			System.out.println("Problemas na connection factory");
			throw new RuntimeException(e);
		}
	}
}