package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Livro;

public class LivroDAO extends GenericDAO<Livro> {
	public static void createLivro(Livro livro) {
		String query = "INSERT INTO livro(titulo, autor) VALUES (?, ?)";
		if (create(query, livro.getTitulo(), livro.getAutor())) {
			System.out.println(" Livro salvo com sucesso!");
		}
		else {
			System.out.println(" Erro ao salvar livro!");
		}
	}
	
	public static Livro readLivro(int codLivro){
		String query = "SELECT * FROM livro WHERE cod_livro = " + codLivro + ";";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();	
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			if (rset.next()) {
				Livro livro = new Livro(rset.getInt("cod_livro"),rset.getString("titulo"),rset.getString("autor"), rset.getString("data_empres"), rset.getString("data_devol"), rset.getInt("cod_aluno"));
				return livro;
			}
			else {
				Livro livro = new Livro();
				livro.setCodLivro(0);
				livro.setCodAluno(0);
				livro.setTitulo("");
				livro.setAutor("");
				livro.setDataEmprestimo(null);
				livro.setDataDevolucao(null);
				return livro;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset!=null) {
					rset.close();
				}
				if (pstm!=null) {
					pstm.close();
				}
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ArrayList<Livro> readTodosLivros(){
		String query = "SELECT * FROM livro";
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();	
			pstm = (PreparedStatement) conn.prepareStatement(query);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Livro livro = new Livro(rset.getInt("cod_livro"),rset.getString("titulo"),rset.getString("autor"), rset.getString("data_empres"), rset.getString("data_devol"), rset.getInt("cod_aluno"));
				livros.add(livro);
			}
			return livros;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset!=null) {
					rset.close();
				}
				if (pstm!=null) {
					pstm.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void updateLivro(Livro livro) {
		String query = "UPDATE livro set titulo = ?, autor = ?, data_empres = ?, cod_aluno = ? where cod_livro = ?;";
		if (update(query, livro.getTitulo(), livro.getAutor(), livro.getDataEmprestimo(), livro.getCodAluno(), livro.getCodLivro())) {
			System.out.println(" Livro atualizado com sucesso!");
		}
		else {
			System.out.println(" Erro ao autalizar livro!");
		}
	}
	
	public static void deleteLivro(int codLivro) throws SQLException {
		String query = "DELETE FROM livro WHERE cod_livro = " + codLivro + ";";
		if (delete(query)) {
			System.out.println(" Livro apagado com sucesso!");
		}
		else {
			System.out.println(" Erro ao apagar livro!");
		}
	}
}