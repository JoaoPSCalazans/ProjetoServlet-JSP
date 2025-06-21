package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Contatos;


public class ContatosDAO {
	
	private final String driver ="org.mariadb.jdbc.Driver";
	private final String url = "jdbc:mariadb://localhost:3306/agenda_de_contatos";
	private final String user = "root";
	private final String password = "senha123";
	
	//Classe Responsavel Pela Conexão Com O Banco De Dados
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
	
	//Metodo Para Listar Os Contatos Na Tabela
	public ArrayList<Contatos> listarContatos(){
		String sql = "SELECT *  FROM contato";
		ArrayList<Contatos> lista = new ArrayList<>();
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			//Armazenar os compos em variaveis
				Integer id = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
			//Adicinar a lista
				lista.add(new Contatos(id,nome,fone,email));
			}
			conn.close();
			return lista;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}	
	}
	//Adicionar mais um contato na Tabela
	public void criarContato(Contatos contato) {
		String sql = "INSERT INTO contato (nome,fone,email) VALUES (?, ?, ?)";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			//Setando os valores dos campos do sql
			pst.setString(1, contato.getNome());
			pst.setString(2,contato.getFone());
			pst.setString(3, contato.getEmail());
			
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	//Metodo Para Deletar um Contato no banco de dados
	public void deletarContato(Integer id) {
		String sql = "DELETE FROM contato WHERE id = ?";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
