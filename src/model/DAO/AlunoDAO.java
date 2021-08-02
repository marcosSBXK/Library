package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Aluno;

public class AlunoDAO extends GenericDAO<Aluno> {

	public static void createAluno(Aluno aluno) {
		String query = "INSERT INTO aluno(nome_aluno, tel_aluno, matricula, restricao, periodo_restrito, data_restr) VALUES (?, ?, ?, ?, ?, ?);";
		if (create(query, aluno.getNomeAluno(), aluno.getTelAluno(), aluno.getMatricula(), aluno.isRestricao(), aluno.getPeriodoRestrito(), aluno.getDataRestricao())) {
			System.out.println(" Aluno salvo com sucesso!");
		}
		else {
			System.out.println(" Erro ao salvar aluno!");
		}
	}
	
	public static Aluno readAluno(int codAluno){
		String query = "SELECT * FROM aluno WHERE cod_aluno = " + codAluno + ";";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();	
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			if (rset.next()) {
				Aluno aluno = new Aluno(rset.getInt("cod_aluno"),rset.getString("nome_aluno"),rset.getString("tel_aluno"),rset.getString("matricula"),rset.getBoolean("restricao"),rset.getInt("periodo_restrito"),rset.getString("data_restr"));
				return aluno;
			}
			else {
				Aluno aluno = new Aluno();
				aluno.setCodAluno(0);
				aluno.setNomeAluno("");
				aluno.setTelAluno("");
				aluno.setMatricula("");
				return aluno;
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ArrayList<Aluno> readTodosAlunos(){
		String query = "SELECT * FROM aluno";
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();	
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Aluno aluno = new Aluno(rset.getInt("cod_aluno"),rset.getString("nome_aluno"),rset.getString("tel_aluno"),rset.getString("matricula"),rset.getBoolean("restricao"),rset.getInt("periodo_restrito"),rset.getString("data_restr"));
				alunos.add(aluno);
			}
			return alunos;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	
	public static void updateAluno(Aluno aluno) {
		String query = "UPDATE aluno set nome_aluno = ?, tel_aluno = ?, matricula = ?, restricao = ?, periodo_restrito = ?, data_restr = ? where cod_aluno = ?;";
		if (update(query, aluno.getNomeAluno(), aluno.getTelAluno(), aluno.getMatricula(), aluno.isRestricao(), aluno.getPeriodoRestrito(), aluno.getDataRestricao(), aluno.getCodAluno())) {
			System.out.println(" Aluno atualizado com sucesso!");
		}
		else {
			System.out.println(" Erro ao autalizar aluno!");
		}
	}
	
	public static void removeRestricao(Aluno aluno) {
		String query = "UPDATE aluno set nome_aluno = ?, tel_aluno = ?, matricula = ?, restricao = ?, periodo_restrito = ?, data_restr = ? where cod_aluno = ?;";
		update(query, aluno.getNomeAluno(), aluno.getTelAluno(), aluno.getMatricula(), aluno.isRestricao(), aluno.getPeriodoRestrito(), aluno.getDataRestricao(), aluno.getCodAluno());
	}
	
	public static void deleteAluno(int codAluno) throws SQLException {
		String query = "DELETE FROM aluno WHERE cod_aluno = " + codAluno + ";";
		if (delete(query)) {
			System.out.println(" Aluno apagado com sucesso!");
		}
		else {
			System.out.println(" Erro ao apagar aluno!");
		}
	}
}