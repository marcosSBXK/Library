package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.DAO.LivroDAO;
import model.entity.Livro;
import view.LivroView;

public class LivroController {
	public static void salvarLivro() {
		Livro livro = new Livro(LivroView.salvarLivro());
		LivroDAO.createLivro(livro);
	}
	
	public static void buscarLivro() {
		Livro livro = new Livro(LivroDAO.readLivro(LivroView.getCodLivro()));
		LivroView.exibirLivro(livro);
	}
	
	public static void listarTodosLivros() {
		ArrayList<Livro> lista = LivroDAO.readTodosLivros();
		LivroView.listarTodosLivros(lista);
	}
	
	public static void listarLivrosLivres() {
		ArrayList<Livro> lista = LivroDAO.readTodosLivros();
		LivroView.listarLivrosLivres(lista);
	}
	
	public static void listarLivrosEmprestados() {
		ArrayList<Livro> lista = LivroDAO.readTodosLivros();
		LivroView.listarLivrosEmprestados(lista);
	}
	
	public static void atualizarLivro() {
		Livro livro = new Livro(LivroView.atualizarLivro());
		LivroDAO.updateLivro(livro);
	}
	
	public static void apagarLivro() throws SQLException {
		LivroDAO.deleteLivro(LivroView.getCodLivro());
	}
}