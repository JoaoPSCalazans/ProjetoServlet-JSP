package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Contatos;

public class ContatosDAO {

	private final String driver = "org.mariadb.jdbc.Driver";
	private final String url = "jdbc:mariadb://localhost:3306/agenda_de_contatos";
	private final String user = "root";
	private final String password = "senha123";

	private Contatos contato = new Contatos();

	// Estabele uma conexão com o banco de dados Mariadb usando JDBC
	private Connection conexao() { 
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// Retorna uma lista com todos os contatos armazenados no banco de dados
	public ArrayList<Contatos> listarContatos() {
		String sql = "SELECT *  FROM contato";
		ArrayList<Contatos> lista = new ArrayList<>();
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Armazenar o resultados e variaveis locais
				Integer id = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				lista.add(new Contatos(id, nome, fone, email));
			}
			conn.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	//Adiciona um contato ao banco de dados
	public void criarContato(Contatos contato) {
		String sql = "INSERT INTO contato (nome,fone,email) VALUES (?, ?, ?)";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			// Setar os parametros da query sql
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Deletar um contato com base no ID fornecido
	public void deletarContato(Integer id) {
		String sql = "DELETE FROM contato WHERE id = ?";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			// Setar o parametro da query sql
			pst.setInt(1, id);
			
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Buscar contato com base no ID fornecido
	public Contatos encontrarPorId(Integer id) {
		String sql = "SELECT * FROM contato WHERE id = ?";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			// Setar o parametro da query sql
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			return contato;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	//Atualizar atributos de um contato ja existente
	public void editarContato(Contatos contato) {
		String sql = "UPDATE contato SET nome = ?,fone = ?,email = ? WHERE id = ?";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			// Setar os parametros da query sql
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setInt(4, contato.getId());
			
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
