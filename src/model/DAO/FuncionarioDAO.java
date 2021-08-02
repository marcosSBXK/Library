package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
	public static void createFuncionario(Funcionario funcionario) {
		String query = "INSERT INTO funcionario(nome_func, tel_func, senha_func) VALUES (?, ?, ?)";
		if (create(query, funcionario.getNomeFunc(), funcionario.getTelFunc(), funcionario.getSenha())) {
			System.out.println(" Funcionario salvo com sucesso!");
		}
		else {
			System.out.println(" Erro ao salvar funcionario!");
		}
	}
	
	public static Funcionario readFuncionario(int codFunc) {
		String query = "SELECT * FROM funcionario WHERE cod_func = " + codFunc + ";";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			if (rset.next()) {
				Funcionario funcionario = new Funcionario(rset.getInt("cod_func"),rset.getString("nome_func"),rset.getString("tel_func"),rset.getString("senha_func"));
				return funcionario;
			}
			else {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodFunc(0);
				funcionario.setNomeFunc("");
				funcionario.setTelFunc("");
				funcionario.setSenha("");
				return funcionario;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ArrayList<Funcionario> readTodosFuncionarios() {
		String query = "SELECT *FROM funcionario;";
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Funcionario funcionario = new Funcionario(rset.getInt("cod_func"),rset.getString("nome_func"),rset.getString("tel_func"),rset.getString("senha_func"));
				funcionarios.add(funcionario);
			}
			return funcionarios;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void updateFuncionario(Funcionario funcionario) {
		String query = "UPDATE funcionario set nome_func = ?, tel_func = ?, senha_func = ? where cod_func = ?;";
		if (update(query, funcionario.getNomeFunc(), funcionario.getTelFunc(), funcionario.getSenha(), funcionario.getCodFunc())) {
			System.out.println(" Funcionario atualizado com sucesso!");
		}
		else {
			System.out.println(" Erro ao autalizar funcionario!");
		}
	}
	
	public static void deleteFuncionario(int codFunc) throws SQLException {
		String query = "DELETE FROM funcionario WHERE cod_func = " + codFunc + ";";
		if (delete(query)) {
			System.out.println(" Funcionario apagado com sucesso!");
		}
		else {
			System.out.println(" Erro ao apagar funcionario!");
		}
	}
}