package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ContatosDAO {
	
	private final String driver ="org.mariadb.jdbc.Driver";
	private final String url = "jdbc:mariadb://localhost:3306/agenda_de_contatos";
	private final String user = "root";
	private final String password = "senha123";
	
	private Connection conexao() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
