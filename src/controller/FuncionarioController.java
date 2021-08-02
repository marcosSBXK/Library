package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.DAO.FuncionarioDAO;
import model.entity.Funcionario;
import view.FuncionarioView;

public class FuncionarioController {
	public static void salvarFuncionario() {
		Funcionario funcionario = new Funcionario(FuncionarioView.salvarFuncionario());
		FuncionarioDAO.createFuncionario(funcionario);
	}
	
	public static void buscarFuncionario() {
		Funcionario funcionario = new Funcionario(FuncionarioDAO.readFuncionario(FuncionarioView.getCodFunc()));
		FuncionarioView.exibirFuncionario(funcionario);
	}
	
	public static void listarTodosFuncionarios() {
		ArrayList<Funcionario> lista = FuncionarioDAO.readTodosFuncionarios();
		FuncionarioView.listarTodosFuncionarios(lista);
	}
	
	public static void atualizarFuncionario() {
		Funcionario funcionario = new Funcionario(FuncionarioView.atualizarFuncionario());
		FuncionarioDAO.updateFuncionario(funcionario);
	}
	
	public static void apagarFuncionario() throws SQLException {
		FuncionarioDAO.deleteFuncionario(FuncionarioView.getCodFunc());
	}
}