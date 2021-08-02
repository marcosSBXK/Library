package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.DAO.AlunoDAO;
import model.entity.Aluno;
import model.services.AlunoServices;
import view.AlunoView;

public class AlunoController {
	public static void salvarAluno() {
		Aluno aluno = new Aluno(AlunoView.salvarAluno());
		AlunoDAO.createAluno(aluno);
	}
	
	public static void buscarAluno() {
		Aluno aluno = new Aluno(AlunoDAO.readAluno(AlunoView.getCodAluno()));
		AlunoView.exibirAluno(aluno);
	}
	
	public static void listarTodosAlunos() {
		ArrayList<Aluno> lista = AlunoDAO.readTodosAlunos();
		AlunoView.listarTodosAlunos(lista);
	}
	
	public static void atualizarAluno() {
		Aluno aluno = new Aluno(AlunoView.atualizarAluno());
		AlunoDAO.updateAluno(aluno);
	}
	
	public static void apagarAluno() throws SQLException {
		AlunoDAO.deleteAluno(AlunoView.getCodAluno());
	}
	
	public static void verificaRestricao(Aluno aluno) {
		if (!AlunoServices.isRestrito(aluno)) {
        	aluno.setPeriodoRestrito(0);
        	aluno.setRestricao(false);
        	aluno.setDataRestricao(null);
			AlunoDAO.removeRestricao(aluno);
		}
	}
}